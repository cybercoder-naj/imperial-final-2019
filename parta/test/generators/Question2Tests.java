package generators;

import org.junit.Assert;
import org.junit.Test;

public class Question2Tests {

    @Test
    public void testDigitCombinationsGenerator1() {
      final StringGenerator generator = new DigitCombinationsGenerator();
      Assert.assertTrue(generator.hasNext());
      Assert.assertEquals("", generator.next());
      Assert.assertTrue(generator.hasNext());
      Assert.assertEquals("2", generator.next());
      Assert.assertTrue(generator.hasNext());
      Assert.assertEquals("3", generator.next());
      Assert.assertTrue(generator.hasNext());
      Assert.assertEquals("4", generator.next());
      Assert.assertTrue(generator.hasNext());
      Assert.assertEquals("5", generator.next());
      Assert.assertTrue(generator.hasNext());
      Assert.assertEquals("22", generator.next());
      Assert.assertTrue(generator.hasNext());
      Assert.assertEquals("23", generator.next());
      Assert.assertTrue(generator.hasNext());
      Assert.assertEquals("24", generator.next());
      Assert.assertTrue(generator.hasNext());
      Assert.assertEquals("25", generator.next());
      Assert.assertTrue(generator.hasNext());
      Assert.assertEquals("32", generator.next());
      Assert.assertTrue(generator.hasNext());
      Assert.assertEquals("33", generator.next());
      Assert.assertTrue(generator.hasNext());
      Assert.assertEquals("34", generator.next());
      Assert.assertTrue(generator.hasNext());
      Assert.assertEquals("35", generator.next());
      Assert.assertTrue(generator.hasNext());
      Assert.assertEquals("42", generator.next());
      Assert.assertTrue(generator.hasNext());
      Assert.assertEquals("43", generator.next());
      Assert.assertTrue(generator.hasNext());
      Assert.assertEquals("44", generator.next());
      Assert.assertTrue(generator.hasNext());
      Assert.assertEquals("45", generator.next());
      Assert.assertTrue(generator.hasNext());
      Assert.assertEquals("52", generator.next());
      Assert.assertTrue(generator.hasNext());
      Assert.assertEquals("53", generator.next());
      Assert.assertTrue(generator.hasNext());
      Assert.assertEquals("54", generator.next());
      Assert.assertTrue(generator.hasNext());
      Assert.assertEquals("55", generator.next());
      Assert.assertTrue(generator.hasNext());
      Assert.assertEquals("222", generator.next());
    }

    @Test
    public void testDigitCombinationsGenerator2() {
      final StringGenerator generator = new DigitCombinationsGenerator();
      for (int i = 0; i < 5000; i++) {
        Assert.assertTrue(generator.hasNext());
        final String value = generator.next();
        switch (i) {
          case 4:
            Assert.assertEquals("5", value);
            break;
          case 5:
            Assert.assertEquals("22", value);
            break;
          case 6:
            Assert.assertEquals("23", value);
            break;
          case 16:
            Assert.assertEquals("45", value);
            break;
          case 17:
            Assert.assertEquals("52", value);
            break;
          case 18:
            Assert.assertEquals("53", value);
            break;
          case 64:
            Assert.assertEquals("445", value);
            break;
          case 65:
            Assert.assertEquals("452", value);
            break;
          case 66:
            Assert.assertEquals("453", value);
            break;
          case 256:
            Assert.assertEquals("4445", value);
            break;
          case 257:
            Assert.assertEquals("4452", value);
            break;
          case 258:
            Assert.assertEquals("4453", value);
            break;
          case 1024:
            Assert.assertEquals("44445", value);
            break;
          case 1025:
            Assert.assertEquals("44452", value);
            break;
          case 1026:
            Assert.assertEquals("44453", value);
            break;
          case 4096:
            Assert.assertEquals("444445", value);
            break;
          case 4097:
            Assert.assertEquals("444452", value);
            break;
          case 4098:
            Assert.assertEquals("444453", value);
            break;
          default:
            break;
        }

      }

    }

}
