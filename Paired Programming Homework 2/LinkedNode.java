// Name: Joshua Simpers
// Class: CSCI 3302 in-class example
// File: LinkedNode.java
//
// Linked Node makes the linked list possible. it is a simple structure that has an item and a 
// reference to the next link.

package LinkedNode;

public class LinkedNode<T> {
    public T item;
    public LinkedNode<T> next;

    public LinkedNode(T item, LinkedNode<T> next) {
        this.item = item;
        this.next = next;
    }

    public LinkedNode(T item) {
        this.item = item;
        this.next = null;
    }
}
