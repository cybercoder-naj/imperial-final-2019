package market;

import domain.Agent;
import domain.producttypes.Product;
import goods.Laptop;
import goods.RawAluminium;
import goods.RawGlass;
import java.util.Optional;

public class MarketImpl implements Market {

  @Override
  public void sellRawAluminium(RawAluminium item, Agent agent) {
    // TODO Q2
  }

  @Override
  public Optional<RawAluminium> buyRawAluminium() {
    // TODO Q2
    return null;
  }

  @Override
  public void sellRawGlass(RawGlass item, Agent agent) {
    // TODO Q2
  }

  @Override
  public Optional<RawGlass> buyRawGlass() {
    // TODO Q2
    return null;
  }

  @Override
  public void sellLaptop(Laptop item, Agent agent) {
    // TODO Q2
  }

  @Override
  public Optional<Laptop> buyLaptop() {
    // TODO Q2
    return null;
  }

  @Override
  public void disposeLaptop(Laptop item, Agent agent) {
    // TODO Q2
  }

  @Override
  public Optional<Product> collectDisposedGood() {
    // TODO Q2
    return null;
  }
}
