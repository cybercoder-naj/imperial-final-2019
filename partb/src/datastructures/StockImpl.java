package datastructures;

import domain.Agent;
import domain.producttypes.ExchangeableGood;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StockImpl<E extends ExchangeableGood> implements Stock<E> {

  private Node<E> root;

  public StockImpl() {
    this.root = null;
  }

  @Override
  public void push(E item, Agent agent) {
    Node<E> parent = null;
    Node<E> current = root;

    while (current != null) {
      parent = current;
      if (agent.id < current.key) {
        current = current.left;
      } else if (agent.id > current.key) {
        current = current.right;
      } else {
        current.add(item);
        return;
      }
    }

    if (parent == null) {
      root = new Node<>(agent.id, item);
      return;
    }

    if (agent.id < parent.key) {
      parent.left = new Node<>(agent.id, item);
    } else {
      parent.right = new Node<>(agent.id, item);
    }
  }

  @Override
  public Optional<E> pop() {
    if (root == null)
      return Optional.empty();

    Node<E> parent = null;
    Node<E> current = root;
    while (current.right != null) {
      parent = current;
      current = current.right;
    }

    Optional<E> highest = current.pop();
    if (current.peek().isEmpty()) {
      if (parent == null) {
        root = deleteNode(root);
      } else {
        parent.right = deleteNode(parent.right);
      }
    }
    return highest;
  }

  private Node<E> deleteNode(Node<E> node) {
    if (node.left != null) {
      Node<E> replacmentNode = findMaxNode(node.left);
      replacmentNode.right = node.right;
      return replacmentNode;
    }
    return null;
  }

  private Node<E> findMaxNode(Node<E> subtree) {
    Node<E> current = subtree;
    while (current.right != null) {
      current = current.right;
    }
    return current;
  }

  @Override
  public int size() {
    return root == null ? 0 : root.size();
  }

  @Override
  public String toString() {
    return "size = " + size();
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
}
