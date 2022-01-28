package code.tree.data;

import java.util.Objects;

/**
 * Implementation of a Binary Tree Node
 */
public class BinaryNode implements BinaryTreeNode {

    private final int value;

    private BinaryNode leftChild = null;
    private BinaryNode rightChild = null;

    public BinaryNode(final int value) {
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public BinaryTreeNode getLeftChild() {
        return leftChild;
    }

    @Override
    public BinaryTreeNode getRightChild() {
        return rightChild;
    }

    @Override
    public void setLeftChild(BinaryTreeNode node) {
        this.leftChild = (BinaryNode) node;
    }

    @Override
    public void setRightChild(BinaryTreeNode node) {
        this.rightChild = (BinaryNode) node;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BinaryNode that = (BinaryNode) o;
        return value == that.value &&
                leftChild == that.leftChild &&
                rightChild == that.rightChild;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
