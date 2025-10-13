// Name: Joshua Simpers
// Class: CSCI 3302
// File: LinkedList.java
//
// Our linked list will keep data items in order.
// Features supported:
//      Iterators!
//      Insert items
//      Remove items (by value)
//      Search to see if list contains a particular value  

package LinkedNode;

import java.util.Iterator;

public class LinkedList <E extends Comparable<E>> implements Iterable<E> {
    
    // first link in our structure
    private LinkedNode<E> head;

    // Inner class for iterator support
    private class ListIterator implements Iterator<E> {
        private LinkedNode<E> currentNode;

        // Constructor starts as head
        public ListIterator(LinkedNode<E> head) {
            currentNode = head;
        }

        public boolean hasNext() {
            return currentNode != null;
        }

        public E next() {
            E currentItemTemp = currentNode.item;
            currentNode = currentNode.next;
            return currentItemTemp;
        }
    }

    // Insert items! Items will be added in sorted order
    public void insert(E newItem) {

        LinkedNode<E> newNode = new LinkedNode<>(newItem);

        // New first item in list
        if (head == null || newItem.compareTo(head.item) < 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        // Find the spot to insert
        LinkedNode<E> nextNode = head.next;
        LinkedNode<E> prevNode = head;

        while (nextNode != null && nextNode.item.compareTo(newItem) < 0) {
            nextNode = nextNode.next;
            prevNode = prevNode.next;
        }
        // At this point, nextNode is the node after the location to insert (or null)
        // and prevNode is the node just before the location to insert
        prevNode.next = newNode;
        newNode.next = nextNode;
    }

    // Remove items by value
    public void remove(E itemToRemove) {

        // Check: The list is empty
        if (head == null) {
            System.out.println("Error: The list was empty! Cannot remove an item from an empty list!");
            return;
        }

        // Check: Remove first item from list
        if (itemToRemove.compareTo(head.item) == 0) {
            head = head.next;
            return; // All done!
        }

        LinkedNode<E> current = head;
        LinkedNode<E> prev = null;

        while (current.item.compareTo(itemToRemove) != 0) {
            prev = current;
            current = current.next;
            if (current == null) {
                System.out.println("Error: The item: " + itemToRemove + " is not in the list.");
                return;
            }
        }

        prev.next = current.next;
        
    }

    // Search the list for a given value
    public boolean contains(E target) {
        LinkedNode<E> currentNode = head;
        while(currentNode != null) {
            if (currentNode.item.compareTo(target) == 0) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    // Iterator support!
    public Iterator<E> iterator() {
        return new ListIterator(head);
    }
}
