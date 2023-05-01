package generators;

public class MissingPrimesGenerator implements IntegerGenerator {
  private int current = 1;

  @Override
  public Integer next() {
    int r = current++;
    while ((current % 3 == 0) ^ (current % 5 == 0)) {
      current++;
    }
    return r;
  }

  @Override
  public boolean hasNext() {
    return true;
  }
}
