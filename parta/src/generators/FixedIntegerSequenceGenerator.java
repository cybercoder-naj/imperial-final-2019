package generators;

public class FixedIntegerSequenceGenerator implements IntegerGenerator {
  private int current = 0;

  @Override
  public Integer next() {
    if (!hasNext()) {
      throw new UnsupportedOperationException();
    }
    return current++;
  }

  @Override
  public boolean hasNext() {
    return current != 30;
  }
}
