package generators;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestSuiteRunner {
  public static void main(String[] args) {
    Result result =
        JUnitCore.runClasses(
            generators.Question1Tests.class,
            generators.Question2Tests.class,
            generators.Question3Tests.class,
            generators.Question4Tests.class,
            generators.Question5Tests.class);
    for (Failure failure : result.getFailures()) {
      System.out.println(failure.toString());
    }
  }
}
