package code.linkedlist;

// input1 1->2->3->4->5, k=2
// output1 2->1->4->3->5

// input2 1->2->3->4->5, k=3
// output2 3->2->1->4->5

// input2 1->2->3->4->5->6->7, k=3
// output2 3->2->1->6->5->4->7

public class ReverseLinkedList {

    public LinkedNode createAList(final int[] arr) {
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


    public LinkedNode reverseTheList(final LinkedNode head, final int k) {
        final int length = getLength(head);
        System.out.println("Length of LL " + length);

        if (length < k || k == 1) {
            return head;
        }

        LinkedNode newHead = null;
        LinkedNode next = null;
        LinkedNode tail = null;
        int count = 0;

        while (count <= length) {

            if (count == 0) {
                ReturnValue val = reverseTheList(head, head.getNext(), k - 1);
                newHead = val.getHead();
                tail = val.getTail();
                next = val.getNext();
                tail.setNext(next);
            } else if (next != null && (length - count) >= k) {
                ReturnValue val = reverseTheList(next, next.getNext(), k - 1);
                tail.setNext(val.getHead());
                tail = val.getTail();
                next = val.getNext();
            } else {
                tail.setNext(next);
            }
            count += k;
        }

        return newHead;
    }

    private ReturnValue reverseTheList(final LinkedNode prev, final LinkedNode current, int k) {

        if (k == 0) {
            //System.out.printf("Returning prev %d and current %d \n", prev.getValue(), current.getValue());
            ReturnValue val = new ReturnValue();
            val.setHead(prev);
            val.setNext(current);

            return val;
        } else {
            //System.out.printf("Recursing prev %d and current %d and k = %d \n", prev.getValue(), current.getValue(), k);

            ReturnValue value = reverseTheList(current, current.getNext(), k - 1);
            current.setNext(prev);

            value.setTail(prev);
            return value;
        }
    }


    public LinkedNode reverseTheList(final LinkedNode head) {
        LinkedNode newHead = reverseTheList(head, head.getNext());
        head.setNext(null);
        return newHead;
    }

    private LinkedNode reverseTheList(final LinkedNode prev, final LinkedNode current) {

        if (current == null) {
            return null;
        }

        if (current.getNext() == null) {
            current.setNext(prev);
            return current;
        } else {
            LinkedNode head = reverseTheList(current, current.getNext());
            current.setNext(prev);
            return head;
        }

    }


    public void print(LinkedNode node) {
        while (node.getNext() != null) {
            System.out.printf("V: %d -> ", node.getValue());
            node = node.getNext();
        }
        System.out.printf("V: %d \n", node.getValue());
    }

    public int getLength(LinkedNode node) {
        int length = 0;

        while (node.getNext() != null) {
            node = node.getNext();
            length++;
        }
        return length + 1;
    }

}