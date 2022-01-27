package code.linkedlist.util;

import code.linkedlist.data.LinkedNode;

/**
 * Utility class to test any Linked List based problem
 */
public class LinkedListTestUtil {

    /**
     * Creates a linked list for testing purpose, using an input array
     * @param arr integer array
     * @return Head of Linked List
     */
    public static LinkedNode createAList(final int[] arr) {
        LinkedNode next = null;
        LinkedNode node = null;

        for (int i = arr.length - 1; i >= 0; i--) {
            node = new LinkedNode(arr[i]);

            if (next != null) {
                node.setNext(next);
            }
            next = node;
        }

        return node;
    }

    /**
     * Prints the linked list
     * @param node Head of the Linked List
     */
    public static void print(LinkedNode node) {
        while (node.getNext() != null) {
            System.out.printf("V: %d -> ", node.getValue());
            node = node.getNext();
        }
        System.out.printf("V: %d \n", node.getValue());
    }

    /**
     * Returns the length of the Linked List
     * @param node Head of the linked list
     * @return integer (length)
     */
    public static int getLength(LinkedNode node) {
        int length = 0;

        while (node.getNext() != null) {
            node = node.getNext();
            length++;
        }
        return length + 1;
    }

}
