package goods;

import domain.producttypes.Product;
import java.util.Set;

public class Laptop extends Product {

  public Laptop(RawGlass glass1, RawAluminium aluminium1, RawAluminium aluminium2) {
    super(Set.of(glass1, aluminium1, aluminium2));
  }
}
