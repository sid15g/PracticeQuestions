package code.linkedlist;

/**
 * Linked List Node
 */
public class LinkedNode {

    private int value;

    private LinkedNode next = null;

    public LinkedNode(final int value) {
        this.value = value;
    }

    public void setNext(final LinkedNode node) {
        this.next = node;
    }

    public LinkedNode getNext() {
        return this.next;
    }

    public int getValue() {
        return this.value;
    }
}
