package generators;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Question3Tests {

    @Test
    public void testGetters() {
      final Pair<Integer, Integer> p1 = new Pair<>(1, 2);
      Assert.assertEquals(1, p1.getFirst().intValue());
      Assert.assertEquals(2, p1.getSecond().intValue());

      final IOException ioException = new IOException();
      final Number aNumber = 3.2;
      final Pair<IOException, Number> p2 = new Pair<>(ioException, aNumber);
      Assert.assertSame(ioException, p2.getFirst());
      Assert.assertSame(aNumber, p2.getSecond());
    }

    @Test
    public void testToString() {
      Assert.assertEquals("<10, 20>", new Pair<>(10, 20).toString());
      Assert.assertEquals("<Hello, 100>", new Pair<>("Hello", 100).toString());
      Assert.assertEquals("<<10, 20>, <Hello, There>>",
              new Pair<>(new Pair<>(10, 20), new Pair<>("Hello", "There")).toString());
    }

    @Test
    public void testEquals1() {
      final Pair<Integer, String> p1 = new Pair<>(10, "Hello");
      final Pair<Integer, String> p2 = new Pair<>(10, "Hello");
      final Pair<Integer, String> p3 = new Pair<>(11, "Hello");
      final Pair<Pair<Integer, String>, String> p4 = new Pair<>(p1, "Goodbye");
      final Pair<Pair<Integer, String>, String> p5 = new Pair<>(p2, "Goodbye");
      final Pair<Pair<Integer, String>, String> p6 = new Pair<>(p2, "Goodby");

      Assert.assertEquals(p1, p1);
      Assert.assertEquals(p1, p2);
      Assert.assertNotEquals(p1, p3);
      Assert.assertNotEquals(p1, p4);
      Assert.assertEquals(p4, p4);
      Assert.assertEquals(p4, p5);
      Assert.assertNotEquals(p5, p6);
    }

    @Test
    public void testEquals2() {
      final Set<Pair<String, String>> set = new HashSet<>();
      final Pair<String, String> p1 = new Pair<>("Hello", "There");
      final Pair<String, String> p2 = new Pair<>("Hello", "There");
      set.add(p1);
      Assert.assertTrue(set.contains(p2));
    }

}
