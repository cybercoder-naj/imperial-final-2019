package generators;

import java.util.List;

public class CompoundDataGenerator<T> implements DataGenerator<T> {
  private final List<DataGenerator<T>> generators;
  private int index = 0;

  public CompoundDataGenerator(List<DataGenerator<T>> generators) {
    this.generators = generators;
  }

  @Override
  public T next() {
    if (index >= generators.size()) {
      throw new UnsupportedOperationException();
    }
    if (!hasNext()) {
      throw new UnsupportedOperationException();
    }

    while (!generators.get(index).hasNext()) {
      index++;
    }
    return generators.get(index).next();
  }

  @Override
  public boolean hasNext() {
    return index != generators.size() - 1 || generators.get(index).hasNext();
  }
}
