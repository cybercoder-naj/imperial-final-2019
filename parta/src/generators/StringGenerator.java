package generators;

public interface StringGenerator extends DataGenerator<String> {
  @Override
  String next();

  @Override
  boolean hasNext();
}
