package code.linkedlist;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class ReverseLinkedListTest {

    @Test
    public void testReversal() {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        LinkedNode head = reverseLinkedList.createAList(new int[]{1, 2, 3, 4, 5});
        reverseLinkedList.print(head);

        System.out.println("Reversing the List... ");
        LinkedNode newHead = reverseLinkedList.reverseTheList(head);
        reverseLinkedList.print(newHead);
        assertNotNull(newHead);
        assertEquals(newHead.getValue(), 5);
        assertEquals(reverseLinkedList.getLength(newHead), 5);
    }

    @Test
    public void testReversalWithK1() {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        LinkedNode head = reverseLinkedList.createAList(new int[]{1, 2, 3, 4, 5});
        reverseLinkedList.print(head);

        System.out.println("Reversing the List... ");
        LinkedNode newHead = reverseLinkedList.reverseTheList(head, 1);
        reverseLinkedList.print(newHead);
        assertNotNull(newHead);
        assertEquals(newHead.getValue(), 1);
        assertEquals(reverseLinkedList.getLength(newHead), 5);
    }

    @Test
    public void testReversalWithK2_SkipLast() {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        LinkedNode head = reverseLinkedList.createAList(new int[]{1, 2, 3, 4, 5});
        reverseLinkedList.print(head);

        System.out.println("Reversing the List... ");
        LinkedNode newHead = reverseLinkedList.reverseTheList(head, 2);
        reverseLinkedList.print(newHead);
        assertNotNull(newHead);
        assertEquals(newHead.getValue(), 2);
        assertEquals(reverseLinkedList.getLength(newHead), 5);
    }

    @Test
    public void testReversalWithK2_NoSkip() {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        LinkedNode head = reverseLinkedList.createAList(new int[]{1, 2, 3, 4, 5, 6});
        reverseLinkedList.print(head);

        System.out.println("Reversing the List... ");
        LinkedNode newHead = reverseLinkedList.reverseTheList(head, 2);
        reverseLinkedList.print(newHead);
        assertNotNull(newHead);
        assertEquals(newHead.getValue(), 2);
        assertEquals(reverseLinkedList.getLength(newHead), 6);
    }

    @Test
    public void testReversalWithK3() {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        LinkedNode head = reverseLinkedList.createAList(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        reverseLinkedList.print(head);

        System.out.println("Reversing the List... ");
        LinkedNode newHead = reverseLinkedList.reverseTheList(head, 3);
        reverseLinkedList.print(newHead);
        assertNotNull(newHead);
        assertEquals(newHead.getValue(), 3);
        assertEquals(reverseLinkedList.getLength(newHead), 8);
    }

    @Test
    public void testReversalWithKMoreThanLength() {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        LinkedNode head = reverseLinkedList.createAList(new int[]{1, 2, 3, 4, 5});
        reverseLinkedList.print(head);

        System.out.println("Reversing the List... ");
        LinkedNode newHead = reverseLinkedList.reverseTheList(head, 7);
        reverseLinkedList.print(newHead);
        assertNotNull(newHead);
        assertEquals(newHead.getValue(), 1);
        assertEquals(reverseLinkedList.getLength(newHead), 5);
    }
}