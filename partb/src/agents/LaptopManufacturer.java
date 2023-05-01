package agents;

import domain.Agent;
import goods.Laptop;
import goods.RawAluminium;
import goods.RawGlass;
import market.Market;

import java.util.Optional;

public class LaptopManufacturer extends Agent {

  public LaptopManufacturer(int thinkingTimeInMillis, Market market) {
    super(thinkingTimeInMillis, market);
  }

  @Override
  public void doAction() {
    RawAluminium a1 = null;
    RawAluminium a2 = null;
    RawGlass g1 = null;

    while (a1 == null || a2 == null || g1 == null) {
      if (a1 == null || a2 == null) {
        Optional<RawAluminium> a = market.buyRawAluminium();
        if (a.isPresent()) {
          if (a1 == null) {
            a1 = a.get();
          } else {
            a2 = a.get();
          }
        }
      }
      if (g1 == null) {
        Optional<RawGlass> g = market.buyRawGlass();
        if (g.isPresent()) {
          g1 = g.get();
        }
      }
    }

    market.sellLaptop(new Laptop(g1, a1, a2), this);
  }
}
