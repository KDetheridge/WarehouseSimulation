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
    public Node(Node<T> n){
        this.data = n.getData();
        //only inherit the next node if one exists. Don't want to create a new node with null
        if (n.hasNext()){
            this.next = new Node(n.getNext());

        }
        else{
            this.next = null;
        }
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