package generators;

public class PairGenerator<S, T> implements DataGenerator<Pair<S, T>> {
  private final DataGenerator<S> sGenerator;
  private final DataGenerator<T> tGenerator;

  public PairGenerator(DataGenerator<S> sGenerator, DataGenerator<T> tGenerator) {
    this.sGenerator = sGenerator;
    this.tGenerator = tGenerator;
  }

  @Override
  public Pair<S, T> next() {
    if (!(sGenerator.hasNext() && tGenerator.hasNext()))
      throw new UnsupportedOperationException();

    S first = sGenerator.next();
    T second = tGenerator.next();
    return new Pair<>(first, second);
  }

  @Override
  public boolean hasNext() {
    return sGenerator.hasNext() && tGenerator.hasNext();
  }
}
