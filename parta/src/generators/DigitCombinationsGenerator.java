package generators;

public class DigitCombinationsGenerator implements StringGenerator {

  private int current = 0;

  @Override
  public String next() {
    if (current == 0) {
      current = 2;
      return "";
    }

    int r = current++;
    if (current % 10 == 6) {
      current = addOneToNext(current);
    }
    return String.valueOf(r);
  }

  private int addOneToNext(int number) {
    number /= 10;
    if (number == 0) {
      return 22;
    }
    if (2 <= number % 10 && number % 10 <= 4) {
      return ((number / 10) * 10 + number % 10 + 1) * 10 + 2;
    }
    return addOneToNext(number) * 10 + 2;
  }

  @Override
  public boolean hasNext() {
    return true;
  }
}
