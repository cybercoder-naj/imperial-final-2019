package datastructures;

import domain.Agent;
import domain.producttypes.ExchangeableGood;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StockImplCourse<E extends ExchangeableGood> implements Stock<E> {

  private Node<E> root;

  public StockImplCourse() {
    this.root = null;
  }

  @Override
  public synchronized void push(E item, Agent agent) {
    if (root == null) {
      root = new Node<>(agent.id, item);
      return;
    }

    push(root, item, agent);
  }

  private void push(Node<E> subtree, E item, Agent agent) {
    if (subtree == null) {
      return;
    }

    if (subtree.key == agent.id) {
      subtree.add(item);
      return;
    }

    if (agent.id < subtree.key) {
      if (subtree.left == null) {
        subtree.left = new Node<>(agent.id, item);
      } else {
        push(subtree.left, item, agent);
      }
      return;
    }

    if (subtree.right == null) {
      subtree.right = new Node<>(agent.id, item);
      return;
    }
    push(subtree.right, item, agent);
  }

  @Override
  public synchronized Optional<E> pop() {
    if (root == null)
      return Optional.empty();

    Node<E> node = root;
    Node<E> parent = null;
    while (node.right != null) {
      parent = node;
      node = node.right;
    }
    Optional<E> item = node.pop();

    if (node.peek().isEmpty()) {
      if (parent != null) {
        if (node.left == null) {
          parent.right = null;
        } else {
          parent.right = node.left;
        }
      } else {
        root = root.left;
      }
    }

    return item;
  }

  @Override
  public int size() {
    return root == null ? 0 : root.size();
  }

  private static class Node<E> {
    public final int key;
    public final List<E> items;
    public Node<E> left;
    public Node<E> right;

    public Node(int key) {
      this.key = key;
      this.items = new ArrayList<>();
      this.left = null;
      this.right = null;
    }

    public Node(int key, E item) {
      this(key);
      add(item);
    }

    public void add(E item) {
      items.add(item);
    }

    public Optional<E> peek() {
      if (items.isEmpty())
        return Optional.empty();

      return Optional.of(items.get(0));
    }

    public Optional<E> pop() {
      if (items.isEmpty())
        return Optional.empty();

      E e = items.get(0);
      items.remove(0);
      return Optional.of(e);
    }

    public int size() {
      int size = items.size();
      if (left != null) {
        size += left.size();
      }
      if (right != null) {
        size += right.size();
      }
      return size;
    }
  }

  @Override
  public String toString() {
    return "Size " + size();
  }
}
