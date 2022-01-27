package code.linkedlist.data;

/**
 * Linked List Node
 */
public class LinkedNode implements Comparable<LinkedNode> {

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

    @Override
    public int compareTo(LinkedNode o) {
        return Integer.compare(this.value, o.getValue());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkedNode that = (LinkedNode) o;
        return value == that.value;
    }
}
