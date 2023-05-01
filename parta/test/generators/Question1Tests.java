package generators;

public class Question1Tests {

  //  @Test
  //  public void testFixedIntegerSequenceGenerator1() {
  //    final IntegerGenerator generator = new FixedIntegerSequenceGenerator();
  //    Assert.assertTrue(generator.hasNext());
  //    Assert.assertEquals(0, generator.next().intValue());
  //    Assert.assertTrue(generator.hasNext());
  //    Assert.assertEquals(1, generator.next().intValue());
  //    Assert.assertTrue(generator.hasNext());
  //    Assert.assertEquals(2, generator.next().intValue());
  //    Assert.assertTrue(generator.hasNext());
  //    Assert.assertEquals(3, generator.next().intValue());
  //    Assert.assertTrue(generator.hasNext());
  //    Assert.assertEquals(4, generator.next().intValue());
  //    Assert.assertTrue(generator.hasNext());
  //    Assert.assertEquals(5, generator.next().intValue());
  //  }
  //
  //  @Test
  //  public void testFixedIntegerSequenceGenerator2() {
  //    final IntegerGenerator generator = new FixedIntegerSequenceGenerator();
  //    final int limit = 30;
  //    for (int i = 0; i < limit; i++) {
  //      Assert.assertTrue(generator.hasNext());
  //      Assert.assertEquals(i, generator.next().intValue());
  //    }
  //    Assert.assertFalse(generator.hasNext());
  //  }
  //
  //  @Test
  //  public void testFixedIntegerSequenceGenerator3() {
  //    final IntegerGenerator generator = new FixedIntegerSequenceGenerator();
  //    final int limit = 30;
  //    for (int i = 0; i < limit; i++) {
  //      generator.next();
  //    }
  //    try {
  //      generator.next();
  //      Assert.fail("An exception was expected.");
  //    } catch (UnsupportedOperationException exception) {
  //      // Good: an exception should have been thrown.
  //    }
  //  }
  //
  //  @Test
  //  public void testMissingPrimesGenerator() {
  //    final Set<Integer> expected = new HashSet<>(Arrays.asList(
  //        1, 2, 4, 7, 8, 11, 13, 14, 15,
  //        16, 17, 19, 22, 23, 26, 28, 29, 30, 31,
  //        32, 34, 37, 38, 41, 43, 44, 45, 46, 47,
  //        49, 52, 53, 56, 58, 59, 60, 61, 62, 64,
  //        67, 68, 71, 73, 74, 75, 76, 77, 79, 82,
  //        83, 86, 88, 89, 90, 91, 92, 94, 97, 98,
  //        101, 103, 104, 105, 106, 107, 109, 112, 113, 116,
  //        118, 119, 120, 121, 122, 124, 127, 128, 131, 133,
  //        134, 135, 136, 137, 139, 142, 143, 146, 148, 149,
  //        150, 151, 152, 154, 157, 158, 161, 163, 164, 165,
  //        166
  //    ));
  //
  //    final IntegerGenerator generator = new MissingPrimesGenerator();
  //    for (int i = 0; i < 100; i++) {
  //      Assert.assertTrue(generator.hasNext());
  //      int element = generator.next();
  //      Assert.assertTrue("Did not expect " + element, expected.contains(element));
  //      expected.remove(element);
  //    }
  //    Assert.assertTrue("Expected but did not see " + expected, expected.isEmpty());
  //  }

}
