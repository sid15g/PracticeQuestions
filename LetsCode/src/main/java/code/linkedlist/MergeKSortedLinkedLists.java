package code.linkedlist;

import code.linkedlist.data.LinkedNode;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given the heads of sorted Linked List as an array
 * Merge them into a single sorted Linked List
 *
 * Input:-
 * [[-1, 0, 100], [2, 3, 5], [-4, 38]]
 * Output:-
 * [-4, -1, 0, 2, 3, 5, 38, 100]
 *
 */
public class MergeKSortedLinkedLists {

    /**
     * Merges K sorted linked list
     * @param nodes heads of the sorted linked lists
     * @return Head of the merged list
     */
    public LinkedNode mergeKSortedLists(final LinkedNode[] nodes) {

        if(nodes == null || nodes.length == 0) {
            return null;
        }
        if(nodes.length == 1) {
            return nodes[0];
        }

        return mergeKSortedListsUsingMinHeap(Arrays.asList(nodes));
    }

    /**
     * Merges K sorted linked list, using a min Heap
     * @param linkedListHeads heads of the sorted linked lists
     * @return Head of the merged list
     */
    private LinkedNode mergeKSortedListsUsingMinHeap(final List<LinkedNode> linkedListHeads) {

        final PriorityQueue<LinkedNode> heap = new PriorityQueue<>(linkedListHeads);

        final LinkedNode headOfNewLinkedList = heap.poll();
        LinkedNode current = headOfNewLinkedList;

        while( heap.size() > 0 ) {

            if (current == null) {
                break;
            }
            if (current.getNext() != null) {
                System.out.printf("Adding <%d> to Heap from current: %d \n", current.getNext().getValue(), current.getValue());
                heap.add(current.getNext());
            }

            LinkedNode nextMinNode = heap.poll();
            current.setNext(nextMinNode);
            current = current.getNext();
        }

        return headOfNewLinkedList;
    }
}