package testutils;

import domain.Agent;
import market.Market;

public class MockAgent extends Agent {

  public MockAgent(Market market) {
    this(1, market);
  }

  public MockAgent(int thinkingTimeInMillis, Market market) {
    super(thinkingTimeInMillis, market);
  }

  @Override
  public void doAction() {}
}
