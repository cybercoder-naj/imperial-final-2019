package domain.producttypes;

public abstract class RawMaterial extends ExchangeableGood {

  public enum Origin {
    NEW,
    RECYCLED
  }

  public final Origin origin;

  public RawMaterial(Origin origin) {
    this.origin = origin;
  }

  @Override
  public String toString() {
    return "RawMaterial " + this.getClass().getName() + " [" + id + ", " + origin + "]";
  }
}
