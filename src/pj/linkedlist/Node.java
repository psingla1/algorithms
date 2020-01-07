package pj.linkedlist;

public class Node {
    public int val;
    public Node next;

    public Node(int val) {
        this(val, null);
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next= next;
    }
}
