package datastructures;

import domain.Agent;
import domain.producttypes.ExchangeableGood;
import java.util.Optional;

public class StockImpl<E extends ExchangeableGood> implements Stock<E> {

  // TODO Implement a BST based priority queue as described in the specs

  @Override
  public void push(E item, Agent agent) {
    // TODO Q1/Q3
  }

  @Override
  public Optional<E> pop() {
    // Hint: always returns a product from the highest priority node. If a node gets to zero
    // products, it should be removed. Because this structure is a BST with nodes sorted by
    // agent.id,
    // the highest priority node should be the rightmost node, which can only be either a leaf or a
    // node with a single child (the left one).

    // TODO Q1/Q3
    return null;
  }

  @Override
  public int size() {
    // Hint: it is just an integer that needs incrementing/decrementing...

    // TODO Q1/Q3
    return -1;
  }
}
