package datastructures;

import domain.Agent;
import java.util.Optional;

public interface Stock<ExchangeableGood> {

  void push(ExchangeableGood item, Agent agent);

  Optional<ExchangeableGood> pop();

  int size();
}
