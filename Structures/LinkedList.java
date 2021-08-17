
package Structures;

import java.util.Iterator;

/**
 * @author Kieran Detheridge A generic LinkedList implementation that allows the
 *         retrieval of the next node through the use of methods.
 */
public class LinkedList<T> implements Iterable<T> {
    private Node head;
    private Node tail;
    private int count;
    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }

    public LinkedList(LinkedList<T> ll){
        this.head = new Node(ll.head());
        this.tail = new Node(ll.tail());
        this.count = ll.size();
    }

    /**
     * Adds an element to the end of the linked list.
     * 
     * @author Kieran Detheridge
     * @param data The data to be added to the linked list
     */
    public void add(T data) {
        Node<T> node = new Node<T>(data);
        //Head is null (Linked List is empty)
        if (this.head == null) {
            this.head = node;
            this.tail = node;
        } 
        
        //if only the head exists
        else if(this.count == 1){
            //set the tail to the new node
            this.tail = node;
            //set the next node of the head to the new node
            this.head.setNext(node);
        }
        //Head is not null
        else {
            //set the next node of the current tail to the new node
            this.tail.setNext(node);
            //set the tail to the new node.
            this.tail = node;
        }
        this.count +=1;
    }

    /**
     * @author Kieran Detheridge
     * @param data the data to create a node from and add to the list
     */
    public void addFirst(T data) {
        Node<T> node = new Node<T>(data);
        //if no head exists (the List is empty)
        if (this.head == null) {
            //set the head to the new node
            this.head = node;
            //set the tail to the new node.
            this.tail = node;
        } else {
            //set the next node for the new node to the current head
            node.setNext(head);
            //set the current head to the new node.
            head = node;
        }
        this.count+=1;
    }



    /**
     * @author Kieran Detheridge
     * @return the head node
     */
    public Node<T> head() {
        return this.head;
    }

    /**
     * @author Kieran Detheridge
     * @return the tail node
     */
    public Node<T> tail() {
        return this.tail;
    }

    public boolean isEmpty() {
        if (head == null) {
            return true;
        }
        return false;
    }

    public void addNode(Node<T> node) {
        if (this.head == null) {
            this.head = node;
            this.tail = node;
        } 
        else if(this.count == 1){
            this.head.setNext(node);
        }
        else {
            this.tail.setNext(node);
            this.tail = node;
        }
        this.count+=1;
    }

    public LinkedList<T> addAll(LinkedList<T> listToAdd) {
        for(T element : listToAdd){
            this.add(element);
        }
        return this;
    }

    public int size(){

        return this.count;
    }

    @Override
    // return Iterator instance
    public Iterator<T> iterator()
    {
        return new LinkedListIterator<T>(this);
    }
}


class LinkedListIterator<T> implements Iterator{
    Node<T> current;
    public LinkedListIterator(LinkedList<T> ll){
        current = ll.head();
    }

        /**
     * @author Kieran Detheridge
     * @return true if there is a next node, false if not
     */
    public boolean hasNext() {
        return current != null;
    }
        /**
     * sets the head to the next node and returns the new head.
     * 
     * @author Kieran Detheridge
     * @return the next node from the linked list.
     */
    public T next() {
        T data = current.getData();
        current = current.getNext();
        return data;
    }
}