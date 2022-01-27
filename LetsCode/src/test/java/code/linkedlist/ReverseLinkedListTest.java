package code.linkedlist;

import code.linkedlist.data.LinkedNode;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static code.linkedlist.util.LinkedListTestUtil.createAList;
import static code.linkedlist.util.LinkedListTestUtil.print;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

/**
 * Unit Test for {@link code.linkedlist.ReverseLinkedList}
 */
public class ReverseLinkedListTest {

    private ReverseLinkedList reverseLinkedList = null;

    @BeforeMethod
    private void beforeMethod() {
        reverseLinkedList = new ReverseLinkedList();
    }

    @Test(groups = "unit")
    public void testReversal() {
        LinkedNode head = createAList(new int[]{1, 2, 3, 4, 5});
        print(head);

        System.out.println("Reversing the List... ");
        LinkedNode newHead = reverseLinkedList.reverseTheList(head);
        print(newHead);
        assertNotNull(newHead);
        assertEquals(newHead.getValue(), 5);
        assertEquals(reverseLinkedList.getLength(newHead), 5);
    }

    @Test(groups = "unit")
    public void testReversalWithK1() {
        LinkedNode head = createAList(new int[]{1, 2, 3, 4, 5});
        print(head);

        System.out.println("Reversing the List... ");
        LinkedNode newHead = reverseLinkedList.reverseTheList(head, 1);
        print(newHead);
        assertNotNull(newHead);
        assertEquals(newHead.getValue(), 1);
        assertEquals(reverseLinkedList.getLength(newHead), 5);
    }

    @Test(groups = "unit")
    public void testReversalWithK2_SkipLast() {
        LinkedNode head = createAList(new int[]{1, 2, 3, 4, 5});
        print(head);

        System.out.println("Reversing the List... ");
        LinkedNode newHead = reverseLinkedList.reverseTheList(head, 2);
        print(newHead);
        assertNotNull(newHead);
        assertEquals(newHead.getValue(), 2);
        assertEquals(reverseLinkedList.getLength(newHead), 5);
    }

    @Test(groups = "unit")
    public void testReversalWithK2_NoSkip() {
        LinkedNode head = createAList(new int[]{1, 2, 3, 4, 5, 6});
        print(head);

        System.out.println("Reversing the List... ");
        LinkedNode newHead = reverseLinkedList.reverseTheList(head, 2);
        print(newHead);
        assertNotNull(newHead);
        assertEquals(newHead.getValue(), 2);
        assertEquals(reverseLinkedList.getLength(newHead), 6);
    }

    @Test(groups = "unit")
    public void testReversalWithK3() {
        LinkedNode head = createAList(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        print(head);

        System.out.println("Reversing the List... ");
        LinkedNode newHead = reverseLinkedList.reverseTheList(head, 3);
        print(newHead);
        assertNotNull(newHead);
        assertEquals(newHead.getValue(), 3);
        assertEquals(reverseLinkedList.getLength(newHead), 8);
    }

    @Test(groups = "unit")
    public void testReversalWithKMoreThanLength() {
        LinkedNode head = createAList(new int[]{1, 2, 3, 4, 5});
        print(head);

        System.out.println("Reversing the List... ");
        LinkedNode newHead = reverseLinkedList.reverseTheList(head, 7);
        print(newHead);
        assertNotNull(newHead);
        assertEquals(newHead.getValue(), 1);
        assertEquals(reverseLinkedList.getLength(newHead), 5);
    }
}