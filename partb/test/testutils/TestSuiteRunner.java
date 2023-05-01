package testutils;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestSuiteRunner {

  public static void main(String[] args) {
    Result result =
        JUnitCore.runClasses(
            datastructures.StockStressMonkey.class,
            datastructures.StockTest.class,
            market.MarketTest.class);
    for (Failure failure : result.getFailures()) {
      System.out.println(failure.toString());
    }
  }
}
