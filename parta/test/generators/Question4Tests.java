package generators;

public class Question4Tests {

  //  class AnotherStringGenerator implements DataGenerator<String> {
  //
  //    private int step = 0;
  //
  //    @Override
  //    public String next() {
  //      step++;
  //      switch (step - 1) {
  //        case 0:
  //          return "A";
  //        case 1:
  //          return "B";
  //        case 2:
  //          return "C";
  //        default:
  //          throw new UnsupportedOperationException("Out of strings.");
  //      }
  //    }
  //
  //    @Override
  //    public boolean hasNext() {
  //      return step <= 2;
  //    }
  //  }
  //
  //  class AnotherIntegerGenerator implements IntegerGenerator {
  //
  //    private int nextValue = 0;
  //
  //    @Override
  //    public Integer next() {
  //      final int result = nextValue;
  //      nextValue = 1 - nextValue;
  //      return result;
  //    }
  //
  //    @Override
  //    public boolean hasNext() {
  //      return true;
  //    }
  //  }
  //
  //  @Test
  //  public void testAnotherStringGenerator() {
  //    final DataGenerator<String> generator = new AnotherStringGenerator();
  //    Assert.assertTrue(generator.hasNext());
  //    Assert.assertEquals("A", generator.next());
  //    Assert.assertTrue(generator.hasNext());
  //    Assert.assertEquals("B", generator.next());
  //    Assert.assertTrue(generator.hasNext());
  //    Assert.assertEquals("C", generator.next());
  //    Assert.assertFalse(generator.hasNext());
  //    try {
  //      generator.next();
  //      Assert.fail("An exception was expected.");
  //    } catch (UnsupportedOperationException exception) {
  //      // Good: an exception should have been thrown.
  //    }
  //  }
  //
  //  @Test
  //  public void testPairGenerator1() {
  //    final PairGenerator<String, Integer> generator = new PairGenerator<>(
  //            new AnotherStringGenerator(), new AnotherIntegerGenerator()
  //    );
  //
  //    Assert.assertTrue(generator.hasNext());
  //    final Pair<String, Integer> p1 = generator.next();
  //    Assert.assertEquals("A", p1.getFirst());
  //    Assert.assertEquals(0, p1.getSecond().intValue());
  //  }
  //
  //  @Test
  //  public void testPairGenerator2() {
  //    final PairGenerator<String, Integer> generator = new PairGenerator<>(
  //            new AnotherStringGenerator(), new AnotherIntegerGenerator()
  //    );
  //
  //    Assert.assertTrue(generator.hasNext());
  //    final Pair<String, Integer> p1 = generator.next();
  //    Assert.assertEquals("A", p1.getFirst());
  //    Assert.assertEquals(0, p1.getSecond().intValue());
  //
  //    Assert.assertTrue(generator.hasNext());
  //    final Pair<String, Integer> p2 = generator.next();
  //    Assert.assertEquals("B", p2.getFirst());
  //    Assert.assertEquals(1, p2.getSecond().intValue());
  //
  //    Assert.assertTrue(generator.hasNext());
  //    final Pair<String, Integer> p3 = generator.next();
  //    Assert.assertEquals("C", p3.getFirst());
  //    Assert.assertEquals(0, p3.getSecond().intValue());
  //
  //    Assert.assertFalse(generator.hasNext());
  //  }

}
