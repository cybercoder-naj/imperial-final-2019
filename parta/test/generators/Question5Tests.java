package generators;

public class Question5Tests {

  //  class AnIntegerGenerator implements DataGenerator<Integer> {
  //    private final int bound;
  //    private int current;
  //
  //    AnIntegerGenerator(int bound) {
  //      this.bound = bound;
  //      this.current = 0;
  //    }
  //
  //    @Override
  //    public Integer next() {
  //      if (current < bound) {
  //        current++;
  //        return current - 1;
  //      }
  //      throw new UnsupportedOperationException();
  //    }
  //
  //    @Override
  //    public boolean hasNext() {
  //      return current < bound;
  //    }
  //  }
  //
  //  class NothingGenerator implements DataGenerator<Integer> {
  //
  //    @Override
  //    public Integer next() {
  //      throw new UnsupportedOperationException();
  //    }
  //
  //    @Override
  //    public boolean hasNext() {
  //      return false;
  //    }
  //  }
  //
  //  @Test
  //  public void testCompoundGenerator1() {
  //    final DataGenerator<Integer> generator = new CompoundDataGenerator<>(
  //            Arrays.asList(new AnIntegerGenerator(1),
  //                          new AnIntegerGenerator(2),
  //                          new AnIntegerGenerator(3)));
  //    Assert.assertTrue(generator.hasNext());
  //    Assert.assertEquals(0, generator.next().intValue());
  //    Assert.assertTrue(generator.hasNext());
  //    Assert.assertEquals(0, generator.next().intValue());
  //    Assert.assertTrue(generator.hasNext());
  //    Assert.assertEquals(1, generator.next().intValue());
  //    Assert.assertTrue(generator.hasNext());
  //    Assert.assertEquals(0, generator.next().intValue());
  //    Assert.assertTrue(generator.hasNext());
  //    Assert.assertEquals(1, generator.next().intValue());
  //    Assert.assertTrue(generator.hasNext());
  //    Assert.assertEquals(2, generator.next().intValue());
  //  }
  //
  //  @Test
  //  public void testCompoundGenerator2() {
  //    final DataGenerator<Integer> generator = new CompoundDataGenerator<>(
  //            Arrays.asList(
  //                    new NothingGenerator(),
  //                    new NothingGenerator(),
  //                    new AnIntegerGenerator(1),
  //                    new NothingGenerator(),
  //                    new AnIntegerGenerator(2),
  //                    new NothingGenerator(),
  //                    new AnIntegerGenerator(3),
  //                    new NothingGenerator(),
  //                    new NothingGenerator()));
  //    Assert.assertTrue(generator.hasNext());
  //    Assert.assertEquals(0, generator.next().intValue());
  //    Assert.assertTrue(generator.hasNext());
  //    Assert.assertEquals(0, generator.next().intValue());
  //    Assert.assertTrue(generator.hasNext());
  //    Assert.assertEquals(1, generator.next().intValue());
  //    Assert.assertTrue(generator.hasNext());
  //    Assert.assertEquals(0, generator.next().intValue());
  //    Assert.assertTrue(generator.hasNext());
  //    Assert.assertEquals(1, generator.next().intValue());
  //    Assert.assertTrue(generator.hasNext());
  //    Assert.assertEquals(2, generator.next().intValue());
  //  }

}
