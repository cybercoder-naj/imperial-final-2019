package generators;

public interface IntegerGenerator extends DataGenerator<Integer> {
  @Override
  Integer next();

  @Override
  boolean hasNext();
}