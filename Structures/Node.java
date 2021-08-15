package Structures;
public class Node<T> {
    private T data;
    private Node<T> next;

    public Node(T data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    public boolean hasNext() {
        if (this.next == null) {
            return false;
        }
        return true;
    }

    public Node<T> getNext() {
        return this.next;
    }

    public void setNext(Node<T> node){
        this.next = node;
    }
    public T getData(){
        return this.data;
    }
}