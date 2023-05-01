package domain;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import market.Market;

public abstract class Agent extends Thread {

  private static final AtomicInteger nextUniqueId = new AtomicInteger(0);
  public final int id = nextUniqueId.getAndIncrement();

  protected final Market market;
  private final int thinkingTimeInMillis;
  private boolean interrupted = false;
  private Random random;

  public Agent(int thinkingTimeInMillis, Market market) {
    assert thinkingTimeInMillis > 0;
    this.thinkingTimeInMillis = thinkingTimeInMillis;
    this.market = market;
  }

  @Override
  public final void run() {
    // Each player thread will generate different waiting times
    this.random = new Random(Thread.currentThread().getId());
    while (!interrupted) {
      doAction();
      think();
    }
  }

  public void interrupt() {
    this.interrupted = true;
  }

  private int sampleExponentialWaitingTime() {
    // In case you are curious, the exponential distribution is the simplest statistical model for
    // used to represent waiting times. Can be used when only the average inter-arrival time (or
    // the arrival frequency is available), fo example, if you only know that bus 74 passes every
    // 10 minutes, this is may be your model to reason about your waiting
    return (int) Math.ceil(Math.log(1 - random.nextDouble()) * (-1.0 * thinkingTimeInMillis));
  }

  protected void think() {
    try {
      Thread.sleep(thinkingTimeInMillis);
    } catch (InterruptedException e) {
      interrupted = true;
    }
  }

  public abstract void doAction();
}
