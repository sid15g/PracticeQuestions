package code.linkedlist;

import code.linkedlist.data.LinkedNode;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static code.linkedlist.util.LinkedListTestUtil.createAList;
import static code.linkedlist.util.LinkedListTestUtil.getLength;
import static code.linkedlist.util.LinkedListTestUtil.print;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

/**
 * Unit Test for {@link MergeKSortedLinkedLists}
 */
public class MergeKSortedLinkedListsTest {

    private MergeKSortedLinkedLists mergeKSortedLinkedLists = null;

    @BeforeMethod
    private void beforeMethod() {
        mergeKSortedLinkedLists = new MergeKSortedLinkedLists();
    }

    @Test(groups = "unit")
    public void testNull() {
        final LinkedNode result = mergeKSortedLinkedLists.mergeKSortedLists(null);
        assertNull(result);
    }

    @Test(groups = "unit")
    public void testSingleArray() {
        final LinkedNode head = createAList(new int[]{1, 2, 3, 4, 5});
        print(head);

        final LinkedNode result = mergeKSortedLinkedLists.mergeKSortedLists(new LinkedNode[]{head});
        assertNotNull(result);
        print(result);
        assertEquals(getLength(result), 5);
        assertEquals(result.getValue(), 1);
    }

    @Test(groups = "unit")
    public void testArrayWithSingleElement() {
        final LinkedNode head1 = createAList(new int[]{-5, -1, 1, 3, 5, 6});
        print(head1);

        final LinkedNode head2 = createAList(new int[]{0});
        print(head2);

        final LinkedNode result = mergeKSortedLinkedLists.mergeKSortedLists(new LinkedNode[]{head1, head2});
        assertNotNull(result);
        print(result);
        assertEquals(getLength(result), 7);
        assertEquals(result.getValue(), -5);
    }

    @Test(groups = "unit")
    public void testArraysWithSingleElement() {
        final LinkedNode head1 = createAList(new int[]{2});
        print(head1);

        final LinkedNode head2 = createAList(new int[]{1});
        print(head2);

        final LinkedNode head3 = createAList(new int[]{-1});
        print(head3);

        final LinkedNode head4 = createAList(new int[]{4});
        print(head4);

        final LinkedNode result = mergeKSortedLinkedLists.mergeKSortedLists(new LinkedNode[]{head1, head2, head3, head4});
        assertNotNull(result);
        print(result);
        assertEquals(getLength(result), 4);
        assertEquals(result.getValue(), -1);
    }

    @Test(groups = "unit")
    public void testGivenCase1() {
        final LinkedNode head1 = createAList(new int[]{-1, 0, 100});
        print(head1);

        final LinkedNode head2 = createAList(new int[]{2, 3, 5});
        print(head2);

        final LinkedNode head3 = createAList(new int[]{-4, 38});
        print(head3);

        final LinkedNode result = mergeKSortedLinkedLists.mergeKSortedLists(new LinkedNode[]{head1, head2, head3});
        assertNotNull(result);
        print(result);
        assertEquals(getLength(result), 8);
        assertEquals(result.getValue(), -4);
    }


    @Test(groups = "unit")
    public void testArraysInSequence() {
        final LinkedNode head1 = createAList(new int[]{1, 2, 3, 4, 5});
        print(head1);

        final LinkedNode head2 = createAList(new int[]{6, 7, 8, 9});
        print(head2);

        final LinkedNode head3 = createAList(new int[]{10, 11, 12, 13, 14, 15, 16});
        print(head3);

        final LinkedNode result = mergeKSortedLinkedLists.mergeKSortedLists(new LinkedNode[]{head1, head2, head3});
        assertNotNull(result);
        print(result);
        assertEquals(getLength(result), 16);
        assertEquals(result.getValue(), 1);
    }

}