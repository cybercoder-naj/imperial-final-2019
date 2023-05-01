package market;

import domain.Agent;
import domain.producttypes.Product;
import goods.Laptop;
import goods.RawAluminium;
import goods.RawGlass;
import java.util.Optional;

public interface Market {

  void sellRawAluminium(RawAluminium item, Agent agent);

  Optional<RawAluminium> buyRawAluminium();

  void sellRawGlass(RawGlass item, Agent agent);

  Optional<RawGlass> buyRawGlass();

  void sellLaptop(Laptop item, Agent agent);

  Optional<Laptop> buyLaptop();

  void disposeLaptop(Laptop item, Agent agent);

  Optional<Product> collectDisposedGood();
}
