package agents;

import domain.Agent;
import goods.Laptop;
import market.Market;

import java.util.Optional;

public class Consumer extends Agent {

  public Consumer(int thinkingTimeInMillis, Market market) {
    super(thinkingTimeInMillis, market);
  }

  @Override
  public void doAction() {
    Laptop l = null;

    while (l == null) {
      Optional<Laptop> o = market.buyLaptop();
      if (o.isPresent()) {
        l = o.get();
      }
    }

    think();
    market.disposeLaptop(l, this);
  }
}
