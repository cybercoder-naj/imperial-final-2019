package agents;

import domain.Agent;
import domain.producttypes.RawMaterial;
import goods.RawGlass;
import market.Market;

public class RawGlassSupplier extends Agent {

  public RawGlassSupplier(int thinkingTimeInMillis, Market market) {
    super(thinkingTimeInMillis, market);
  }

  @Override
  public void doAction() {
    market.sellRawGlass(new RawGlass(RawMaterial.Origin.NEW), this);
  }
}
