package datastructures;

import domain.Agent;
import domain.producttypes.ExchangeableGood;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * PLEASE NOTE. THIS IS THE FINE GRAINED IMPLEMENTATION
 * IF THIS DOES NOT WORK, PLEASE CONSIDER MY COURSE GRAINED IMPLEMENTATION
 * IN THE SAME PACKAGE.
 */
public class StockImpl<E extends ExchangeableGood> implements Stock<E> {

  private Node<E> root;

  public StockImpl() {
    this.root = null;
  }

  @Override
  public void push(E item, Agent agent) {
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

    subtree.lock.lock();
    if (subtree.key == agent.id) {
      subtree.add(item);
      return;
    }

    if (agent.id < subtree.key) {
      if (subtree.left == null) {
        subtree.left = new Node<>(agent.id, item);
      } else {
        subtree.lock.unlock();
        push(subtree.left, item, agent);
      }
      return;
    }

    if (subtree.right == null) {
      subtree.right = new Node<>(agent.id, item);
      return;
    }
    subtree.lock.unlock();
    push(subtree.right, item, agent);
  }

  @Override
  public Optional<E> pop() {
    if (root == null)
      return Optional.empty();

    Node<E> node = root;
    Node<E> parent = null;
    try {
      node.lock.lock();
      while (node.right != null) {
        if (parent != null)
          parent.lock.lock();
        parent = node;
        node = node.right;
        node.lock.lock();
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
    } finally {
      if (parent != null) {
        parent.lock.unlock();
      }
      node.lock.unlock();
    }
  }

  @Override
  public int size() {
    return root == null ? 0 : root.size();
  }

  @Override
  public String toString() {
    return "Size " + size();
  }

  private static class Node<E> {
    public final int key;
    public final List<E> items;
    public Node<E> left;
    public Node<E> right;

    public Lock lock;

    public Node(int key) {
      this.key = key;
      this.items = new ArrayList<>();
      this.left = null;
      this.right = null;
      this.lock = new ReentrantLock();
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
}
