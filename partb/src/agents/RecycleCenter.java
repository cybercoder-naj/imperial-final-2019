package agents;

import domain.Agent;
import domain.producttypes.Product;
import domain.producttypes.RawMaterial;
import goods.RawAluminium;
import goods.RawGlass;
import market.Market;

import java.util.Optional;
import java.util.Set;

public class RecycleCenter extends Agent {

  public RecycleCenter(int thinkingTimeInMillis, Market market) {
    super(thinkingTimeInMillis, market);
  }

  @Override
  public void doAction() {
    Optional<Product> product = market.collectDisposedGood();
    if (product.isPresent()) {
      Set<RawMaterial> rawMaterials = product.get().getConstituentMaterials();
      for (RawMaterial rawMaterial : rawMaterials) {
        if (rawMaterial.origin == RawMaterial.Origin.NEW) {
          if (rawMaterial instanceof RawGlass)
            market.sellRawGlass(new RawGlass(RawMaterial.Origin.RECYCLED), this);
          else if (rawMaterial instanceof RawAluminium) {
            market.sellRawAluminium(new RawAluminium(RawMaterial.Origin.RECYCLED), this);
          }
        }
      }
    }
  }
}
