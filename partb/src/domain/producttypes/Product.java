package domain.producttypes;

import java.util.Collections;
import java.util.Set;

public abstract class Product extends ExchangeableGood {

  private final Set<RawMaterial> constituentMaterials;

  public Product(Set<RawMaterial> constituentMaterials) {
    this.constituentMaterials = Collections.unmodifiableSet(constituentMaterials);
  }

  public Set<RawMaterial> getConstituentMaterials() {
    return constituentMaterials;
  }

  @Override
  public String toString() {
    return "Product "
        + this.getClass().getName()
        + " ["
        + id
        + ", Materials: "
        + constituentMaterials
        + "]";
  }
}
