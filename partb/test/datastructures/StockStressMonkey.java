package datastructures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.IntStream;
import org.junit.Before;
import org.junit.Test;
import testutils.MockAgent;
import testutils.MockProduct;

public class StockStressMonkey {

  public static final int NUM_PUSHERS = 10;
  public static final int NUM_PRODUCTS_PER_PUSHER = 50_000;
  public static final int NUM_POPPERS = 5;

  private Stock<MockProduct> stock;

  private final PrintStream psNull =
      new PrintStream(
          new OutputStream() {
            @Override
            public void write(int b) throws IOException {
              // Discard any write operation
            }
          });

  @Before
  public void initializeStock() {
    stock = new StockImpl<>();

    // Comment out the following line if you want to see output on the output stream
    System.setOut(psNull);
  }

  @Test
  public void unleashChaos() {
    MockAgent agents[] = new MockAgent[StockStressMonkey.NUM_PUSHERS];
    Arrays.setAll(agents, i -> new MockAgent(1, null));

    MonkeyPusher monkeyPushers[] = new MonkeyPusher[StockStressMonkey.NUM_PUSHERS];
    Arrays.setAll(
        monkeyPushers,
        i -> new MonkeyPusher(agents[i], stock, StockStressMonkey.NUM_PRODUCTS_PER_PUSHER));

    MonkeyPopper monkeyPoppers[] = new MonkeyPopper[StockStressMonkey.NUM_POPPERS];
    final int num_pops_per_popper =
        (StockStressMonkey.NUM_PUSHERS * StockStressMonkey.NUM_PRODUCTS_PER_PUSHER)
            / StockStressMonkey.NUM_POPPERS;

    // Make sure the numbers add up, avoiding rounding losses due to int division
    assert StockStressMonkey.NUM_POPPERS * num_pops_per_popper
        == StockStressMonkey.NUM_PUSHERS * StockStressMonkey.NUM_PRODUCTS_PER_PUSHER;

    Arrays.setAll(monkeyPoppers, i -> new MonkeyPopper(stock, num_pops_per_popper));

    Arrays.stream(monkeyPoppers).forEach(p -> p.start());
    Arrays.stream(monkeyPushers).forEach(p -> p.start());

    Arrays.stream(monkeyPushers)
        .forEach(
            p -> {
              try {
                p.join();
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            });

    Arrays.stream(monkeyPoppers)
        .forEach(
            p -> {
              try {
                p.join();
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            });

    assertEquals(0, stock.size());

    var allProduced = new HashSet<>();
    var allConsumed = new HashSet<>();

    Arrays.stream(monkeyPushers).forEach(p -> allProduced.addAll(p.producedProducts));
    Arrays.stream(monkeyPoppers).forEach(p -> allConsumed.addAll(p.consumedProducts));

    assertEquals(allProduced, allConsumed);
    assertEquals(
        allProduced.size(),
        StockStressMonkey.NUM_PUSHERS * StockStressMonkey.NUM_PRODUCTS_PER_PUSHER);
  }

  @Test
  public void prioritiesEvenDuringChaos() {
    MockAgent agents[] = new MockAgent[StockStressMonkey.NUM_PUSHERS];
    Arrays.setAll(agents, i -> new MockAgent(1, null));

    MonkeyPusher monkeyPushers[] = new MonkeyPusher[StockStressMonkey.NUM_PUSHERS];
    Arrays.setAll(
        monkeyPushers,
        i -> new MonkeyPusher(agents[i], stock, StockStressMonkey.NUM_PRODUCTS_PER_PUSHER));

    Arrays.stream(monkeyPushers).forEach(p -> p.start());

    Arrays.stream(monkeyPushers)
        .forEach(
            p -> {
              try {
                p.join();
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            });

    for (int i = StockStressMonkey.NUM_PUSHERS - 1; i >= 0; i--) {
      var producedByPusherI = monkeyPushers[i].producedProducts;
      for (int j = 0; j < StockStressMonkey.NUM_PRODUCTS_PER_PUSHER; j++) {
        Optional<MockProduct> nextProduct = stock.pop();
        assertTrue(nextProduct.isPresent());
        assertTrue(producedByPusherI.contains(nextProduct.get()));
      }
    }
    assertEquals(0, stock.size());
  }

  private class MonkeyPusher extends Thread {

    private final MockAgent agent;
    private final Stock<MockProduct> stock;
    private final int numProducts;
    private final Set<MockProduct> producedProducts = new HashSet<>();

    public MonkeyPusher(MockAgent agent, Stock<MockProduct> stock, int numProducts) {
      this.agent = agent;
      this.stock = stock;
      this.numProducts = numProducts;
    }

    @Override
    public void run() {
      IntStream.range(0, numProducts)
          .forEach(
              i -> {
                var product = new MockProduct();
                producedProducts.add(product);
                stock.push(product, agent);
              });
    }
  }

  private class MonkeyPopper extends Thread {

    private final Set<MockProduct> consumedProducts = new HashSet<>();
    private final Stock<MockProduct> stock;
    private final int numPops;

    public MonkeyPopper(Stock<MockProduct> stock, int numPops) {
      this.stock = stock;
      this.numPops = numPops;
    }

    @Override
    public void run() {
      while (consumedProducts.size() < numPops) {
        // If this does not terminate, something is wrong (or you are producing in total less than
        // numPops
        Optional<MockProduct> product = stock.pop();
        product.ifPresent(p -> consumedProducts.add(p));
        // If you want to make sure it is still processing:
        //  if(consumedProducts.size() %1000 ==0){
        //      System.out.println("consumed: "+consumedProducts.size());
        //  }
      }
    }
  }
}
