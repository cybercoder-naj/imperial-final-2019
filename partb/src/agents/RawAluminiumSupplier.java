package agents;

import domain.Agent;
import domain.producttypes.RawMaterial;
import goods.RawAluminium;
import market.Market;

public class RawAluminiumSupplier extends Agent {

  public RawAluminiumSupplier(int thinkingTimeInMillis, Market market) {
    super(thinkingTimeInMillis, market);
  }

  @Override
  public void doAction() {
    market.sellRawAluminium(new RawAluminium(RawMaterial.Origin.NEW), this);
  }
}
