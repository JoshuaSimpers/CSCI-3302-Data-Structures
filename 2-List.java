// Name: Joshua Simpers
// File: 2-List.java
// Class: CSCI 3302
// ADT List (now usng Generics)
// 9/22/2025
//
// A List puts items in order (not necessarily sorted). 
// With a list, you can:
//   Add an item to the list
//   Add an item at a particular location
//   Remove an item
//   Determine whether or not an item is in the list
//

public class List<T> {

    // What is the default size of the list?
    private static int DEFAULT_SIZE = 50;

    // We use a primitive array to hold our data
    private T [] array;

    // How much of the array is actually used?
    private int size;

    // How much memory is the array using?
    private int capacity;

    // Constructor creates the object
    //      (needs to initialze array)

     public List() {
        this.capacity = DEFAULT_SIZE;
        array = (T[])new Object[capacity];
        size = 0;
    }

    public List(int capacity) {
        if(capacity < 1) {
            throw new IllegalArgumentException("List capacity must be positive."); 
        }

        this.capacity = capacity;
        array = (T[])new Object[capacity];
        size = 0;
    }

    // Add an item to the list
    public void add(T newItem) {
        if(size == capacity)
            resize();

        array[size] = newItem;
        size++;
    }
    
    
    // Add an item to the list at a particular location
    public void add(T newItem, int itemLocation) {
        if (itemLocation < 0 || itemLocation > size) {
            throw new IllegalArgumentException("Item location needs to be betwen 0 and the size");
        }
        if (size == capacity) {
            resize();
        }
        size++;
        for (int i = size - 1; i > itemLocation; i--) {
            array[i] = array[i - 1];
        }

        array[itemLocation] = newItem;
    } 

    // Remove an item from the list
    // Remove takes as a parameter the index of the item to remove
    public void remove(int indexToRemove) {
        for(int i = indexToRemove; i < size - 1; i++)
            array[i] = array[i + 1];
        size--;
    }

    // Manage list capacity
    private void resize() {
        T [] newArray = (T[])new Object[capacity*2];
        for(int i = 0; i < size; ++i)
            newArray[i] = array[i];
        array = newArray;
        capacity *=2;
    } 

    // Simply checks if a user-given item is in the list, returning true or false depending
    public boolean contains(T targetItem) {
        for(int i = 0; i < size; i++) {
            if(array[i].equals(targetItem)) {
                return true;
            }
        }
        return false;
    }

    // prints the items within the list
    public void printList() {
        System.out.print("[ ");
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                System.out.print(array[i]);
            }
            else {
                System.out.print(array[i] + ", ");
            }
        }
        System.out.print(" ]");
        System.out.println();
    }

    public static void main(String[] args) {
        // test cases using list objects with generics
        List<Integer> testListInteger = new List<Integer>(5);
        List<String> testListString = new List<String>(5);
        testListInteger.add(1);
        testListInteger.add(2);
        testListInteger.add(3);
        testListInteger.add(4);
        testListInteger.add(5);
        testListInteger.printList();
        testListString.add("I am One");
        testListString.add("I am Two");
        testListString.add("I am Three");
        testListString.add("I am Four");
        testListString.add("I am Five");
        testListString.printList();
        testListInteger.remove(0);
        testListString.remove(0);
        testListInteger.remove(testListInteger.size / 2);
        testListString.remove(testListString.size / 2);
        testListInteger.remove(testListInteger.size);
        testListString.remove(testListString.size);
        testListInteger.printList();
        testListString.printList();
        testListInteger.add(1, 0);
        testListString.add("I am the new One", 0);
        testListInteger.printList();
        testListString.printList();
        System.out.println("Does the Integer list contain 3? " + testListInteger.contains(3));
        System.out.println("Does the String list contain 'I am Three'? " + testListString.contains("I am Three"));
        System.out.println("Does the Integer list contain 35? " + testListInteger.contains(35));
        System.out.println("Does the String list contain 'I am Sixty-Three'? " + testListString.contains("I am Sixty-Three"));
        testListInteger.add(35);
        testListString.add("I am Sixty-Three");
        testListInteger.printList();
        testListString.printList();
        System.out.println("Does the Integer list contain 35? " + testListInteger.contains(35));
        System.out.println("Does the String list contain 'I am Sixty-Three'? " + testListString.contains("I am Sixty-Three"));
    }




}
