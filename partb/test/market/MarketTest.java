package market;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import agents.Consumer;
import agents.LaptopManufacturer;
import agents.RawAluminiumSupplier;
import agents.RawGlassSupplier;
import agents.RecycleCenter;
import domain.Agent;
import domain.producttypes.Product;
import domain.producttypes.RawMaterial.Origin;
import goods.Laptop;
import goods.RawAluminium;
import goods.RawGlass;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;
import testutils.MockAgent;

public class MarketTest {

  private Market market;
  private Agent agent0, agent1;
  private RawGlass newGlass1, newGlass2, recycledGlass1, recycledGlass2;
  private RawAluminium newAluminium1, newAluminium2, recycledAluminium1, recycledAluminium2;

  @Before
  public void setup() {
    market = new MarketImpl();

    newGlass1 = new RawGlass(Origin.NEW);
    newGlass2 = new RawGlass(Origin.NEW);
    recycledGlass1 = new RawGlass(Origin.RECYCLED);
    recycledGlass2 = new RawGlass(Origin.RECYCLED);

    newAluminium1 = new RawAluminium(Origin.NEW);
    newAluminium2 = new RawAluminium(Origin.NEW);
    recycledAluminium1 = new RawAluminium(Origin.RECYCLED);
    recycledAluminium2 = new RawAluminium(Origin.RECYCLED);

    agent0 = new MockAgent(market);
    agent1 = new MockAgent(market);
  }

  @Test
  public void marketHasInitiallyNoGoods() {
    assertTrue(market.buyRawGlass().isEmpty());
    assertTrue(market.buyRawAluminium().isEmpty());
    assertTrue(market.buyLaptop().isEmpty());
    assertTrue(market.collectDisposedGood().isEmpty());
  }

  @Test
  public void productsDoNotGetLost() {
    marketHasInitiallyNoGoods();

    market.sellRawGlass(newGlass1, agent0);
    market.sellRawGlass(recycledGlass2, agent1);
    market.sellRawGlass(newGlass2, agent1);
    market.sellRawGlass(recycledGlass1, agent0);

    Set<RawGlass> boughtSet = new HashSet<>();

    Optional<RawGlass> bought = market.buyRawGlass();
    assertTrue(bought.isPresent());
    boughtSet.add(bought.get());

    bought = market.buyRawGlass();
    assertTrue(bought.isPresent());
    boughtSet.add(bought.get());

    bought = market.buyRawGlass();
    assertTrue(bought.isPresent());
    boughtSet.add(bought.get());

    bought = market.buyRawGlass();
    assertTrue(bought.isPresent());
    boughtSet.add(bought.get());

    bought = market.buyRawGlass();
    assertFalse(bought.isPresent());

    assertEquals(Set.of(newGlass1, newGlass2, recycledGlass1, recycledGlass2), boughtSet);
  }

  @Test
  public void trashDoesNotGetLost() {
    marketHasInitiallyNoGoods();

    var laptop1 = new Laptop(newGlass1, recycledAluminium1, newAluminium1);
    var laptop2 = new Laptop(newGlass2, recycledAluminium2, newAluminium2);
    market.disposeLaptop(laptop1, agent0);
    market.disposeLaptop(laptop2, agent1);

    Set<Product> boughtSet = new HashSet<>();

    Optional<Product> bought = market.collectDisposedGood();
    assertTrue(bought.isPresent());
    boughtSet.add(bought.get());

    bought = market.collectDisposedGood();
    assertTrue(bought.isPresent());
    boughtSet.add(bought.get());

    bought = market.collectDisposedGood();
    assertFalse(bought.isPresent());

    assertEquals(Set.of(laptop1, laptop2), boughtSet);
  }

  @Test
  public void recycledRawMaterialsFirstAndThenAgentsPriority() {
    marketHasInitiallyNoGoods();

    market.sellRawGlass(newGlass1, agent0);
    market.sellRawGlass(recycledGlass2, agent1);
    market.sellRawGlass(newGlass2, agent1);
    market.sellRawGlass(recycledGlass1, agent0);

    Optional<RawGlass> bought = market.buyRawGlass();
    assertTrue(bought.isPresent());
    assertEquals(recycledGlass2, bought.get());

    bought = market.buyRawGlass();
    assertTrue(bought.isPresent());
    assertEquals(recycledGlass1, bought.get());

    bought = market.buyRawGlass();
    assertTrue(bought.isPresent());
    assertEquals(newGlass2, bought.get());

    bought = market.buyRawGlass();
    assertTrue(bought.isPresent());
    assertEquals(newGlass1, bought.get());

    bought = market.buyRawGlass();
    assertFalse(bought.isPresent());
  }

  @Test
  public void lifeCycle() {
    final var glassSupplier = new RawGlassSupplier(1, market);
    final var aluminiumSupplier = new RawAluminiumSupplier(1, market);
    final var laptopManufacturer = new LaptopManufacturer(1, market);
    final var consumer = new Consumer(1, market);
    final var recycleCenter = new RecycleCenter(1, market);

    marketHasInitiallyNoGoods();

    // New raw materials
    glassSupplier.doAction();
    aluminiumSupplier.doAction();
    aluminiumSupplier.doAction();

    // Manufacturing, consume, recycle
    laptopManufacturer.doAction();
    consumer.doAction();
    recycleCenter.doAction();

    // Second manufacturing with all recycled materials (no new materials added)
    laptopManufacturer.doAction();
    consumer.doAction();
    recycleCenter.doAction();

    // The market is empty
    marketHasInitiallyNoGoods();
  }
}
