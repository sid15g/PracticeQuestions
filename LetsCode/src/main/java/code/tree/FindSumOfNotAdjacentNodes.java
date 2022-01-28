package code.tree;

import code.tree.data.BinaryNode;
import code.tree.data.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.geeksforgeeks.org/maximum-sum-nodes-binary-tree-no-two-adjacent/
 * <p>
 * Given a binary tree with a value associated with each node, we need to choose a subset of these nodes such that
 * the sum of chosen nodes is maximum under a constraint that no two chosen nodes in the subset should be directly connected that is,
 * if we have taken a node in our sum then we can’t take any of its children in consideration and vice versa.
 */
public class FindSumOfNotAdjacentNodes {

    public BinaryTreeNode createATree(final int[] nodeMap) {
        if (nodeMap == null || nodeMap.length == 0) {
            return null;
        }

        final BinaryTreeNode root = new BinaryNode(nodeMap[0]);
        final Queue<BinaryTreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        int index = 0;
        while (index < nodeMap.length) {

            if (nodeMap[index] == -1) {
                index++;
                continue;
            }

            int leftChildIndex = (2 * index) + 1;
            int rightChildIndex = (2 * index) + 2;

            if (leftChildIndex >= nodeMap.length) {
                break;
            }

            final BinaryTreeNode node = nodes.remove();

            if (nodeMap[leftChildIndex] > 0) {
                node.setLeftChild(new BinaryNode(nodeMap[leftChildIndex]));
                nodes.add(node.getLeftChild());
            }

            if (nodeMap[rightChildIndex] > 0) {
                node.setRightChild(new BinaryNode(nodeMap[rightChildIndex]));
                nodes.add(node.getRightChild());
            }
            index++;
        }

        return root;
    }

    public void print(BinaryTreeNode node) {
        if (node == null) {
            return;
        }

        System.out.printf("%d -> ", node.getValue());
        print(node.getLeftChild());
        print(node.getRightChild());
    }

    public int findMaximumSum(final BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        if (!root.hasChild()) {
            //if root has no child, implies tree has a single node
            return root.getValue();
        }

        //find max of by both including and excluding the node
        return Math.max(
                findMaximumSumUsingRecursion(root, true),
                findMaximumSumUsingRecursion(root, false)
        );
    }

    private int findMaximumSumUsingRecursion(final BinaryTreeNode node, final boolean skipMe) {
        if (node == null) {
            return 0;
        }
        if (!node.hasChild()) {
            return skipMe ? 0 : node.getValue();
        }

        if (skipMe) {
            return findMaximumSumUsingRecursion(node.getLeftChild(), false)
                    + findMaximumSumUsingRecursion(node.getRightChild(), false);
        } else {
            int includingMe = node.getValue() + findMaximumSumUsingRecursion(node.getLeftChild(), true)
                    + findMaximumSumUsingRecursion(node.getRightChild(), true);

            int excludingMe = findMaximumSumUsingRecursion(node.getLeftChild(), false)
                    + findMaximumSumUsingRecursion(node.getRightChild(), false);

            return Math.max(includingMe, excludingMe);
        }
    }

}
