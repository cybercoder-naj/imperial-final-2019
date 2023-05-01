package generators;

public interface DataGenerator<T> {

  T next();

  boolean hasNext();
}
