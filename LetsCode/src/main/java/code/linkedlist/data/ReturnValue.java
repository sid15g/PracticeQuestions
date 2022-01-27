package code.linkedlist.data;

/**
 * Return Object for Reversing the Linked List with given 'k'
 */
public class ReturnValue {

    private LinkedNode head = null;
    private LinkedNode tail = null;
    private LinkedNode next = null;

    public void setHead(final LinkedNode head) {
        this.head = head;
    }

    public void setTail(final LinkedNode tail) {
        this.tail = tail;
    }

    public void setNext(final LinkedNode next) {
        this.next = next;
    }

    public LinkedNode getHead() {
        return this.head;
    }

    public LinkedNode getNext() {
        return this.next;
    }

    public LinkedNode getTail() {
        return this.tail;
    }
}
