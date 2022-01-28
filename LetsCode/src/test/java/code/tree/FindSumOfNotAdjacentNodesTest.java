package code.tree;

import code.tree.data.BinaryTreeNode;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;


public class FindSumOfNotAdjacentNodesTest {

    private FindSumOfNotAdjacentNodes findSumOfNotAdjacentNodes = null;

    @BeforeMethod
    private void beforeMethod() {
        findSumOfNotAdjacentNodes = new FindSumOfNotAdjacentNodes();
    }

    @Test(groups = "unit")
    public void testNullCase() {
        final int[] treeMap = new int[]{};
        final BinaryTreeNode root = findSumOfNotAdjacentNodes.createATree(treeMap);
        assertNull(root);
    }

    @Test(groups = "unit")
    public void testSingleNode() {
        final int[] treeMap = new int[]{2};
        final BinaryTreeNode root = findSumOfNotAdjacentNodes.createATree(treeMap);
        assertNotNull(root);
        findSumOfNotAdjacentNodes.print(root);

        final int result = findSumOfNotAdjacentNodes.findMaximumSum(root);
        assertEquals(result, 2);
    }

    @Test(groups = "unit")
    public void testTwoNodes() {
        final int[] treeMap = new int[]{2, 3, -1};
        final BinaryTreeNode root = findSumOfNotAdjacentNodes.createATree(treeMap);
        assertNotNull(root);
        findSumOfNotAdjacentNodes.print(root);

        final int result = findSumOfNotAdjacentNodes.findMaximumSum(root);
        assertEquals(result, 3);
    }

    @Test(groups = "unit")
    public void testThreeNodesForChildren() {
        final int[] treeMap = new int[]{2, 3, 4};
        final BinaryTreeNode root = findSumOfNotAdjacentNodes.createATree(treeMap);
        assertNotNull(root);
        findSumOfNotAdjacentNodes.print(root);

        final int result = findSumOfNotAdjacentNodes.findMaximumSum(root);
        assertEquals(result, 7);
    }

    @Test(groups = "unit")
    public void testThreeNodesForParent() {
        final int[] treeMap = new int[]{10, 3, 4};
        final BinaryTreeNode root = findSumOfNotAdjacentNodes.createATree(treeMap);
        assertNotNull(root);
        findSumOfNotAdjacentNodes.print(root);

        final int result = findSumOfNotAdjacentNodes.findMaximumSum(root);
        assertEquals(result, 10);
    }

    @Test(groups = "unit")
    public void testThreeNodesForAlternativeGenerations() {
        final int[] treeMap = new int[]{2, 3, -1, -1, 2};
        final BinaryTreeNode root = findSumOfNotAdjacentNodes.createATree(treeMap);
        assertNotNull(root);
        findSumOfNotAdjacentNodes.print(root);

        final int result = findSumOfNotAdjacentNodes.findMaximumSum(root);
        assertEquals(result, 4);
    }

    @Test(groups = "unit")
    public void testGivenCase1() {
        final int[] treeMap = new int[]{2, 3, 4, 1, -1, 5, 6};
        final BinaryTreeNode root = findSumOfNotAdjacentNodes.createATree(treeMap);
        assertNotNull(root);
        findSumOfNotAdjacentNodes.print(root);

        final int result = findSumOfNotAdjacentNodes.findMaximumSum(root);
        assertEquals(result, 14);
    }

    @Test(groups = "unit")
    public void testGivenCase2() {
        final int[] treeMap = new int[]{10, 1, -1, 2, 3, 1, -1, 4, 5};
        final BinaryTreeNode root = findSumOfNotAdjacentNodes.createATree(treeMap);
        assertNotNull(root);
        findSumOfNotAdjacentNodes.print(root);

        final int result = findSumOfNotAdjacentNodes.findMaximumSum(root);
        assertEquals(result, 21);
    }

}