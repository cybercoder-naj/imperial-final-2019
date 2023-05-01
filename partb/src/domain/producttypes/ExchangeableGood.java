package domain.producttypes;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class ExchangeableGood {

  private static final AtomicInteger nextUniqueId = new AtomicInteger(0);
  public final int id = ExchangeableGood.nextUniqueId.getAndIncrement();

  @Override
  public final boolean equals(Object obj) {
    if (obj instanceof ExchangeableGood) {
      return id == ((ExchangeableGood) obj).id;
    }
    return false;
  }

  @Override
  public int hashCode() {
    return id;
  }
}
