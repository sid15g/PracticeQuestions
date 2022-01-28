package code.tree.data;

/**
 * Node representing a Binary Tree
 */
public interface BinaryTreeNode {

    int getValue();

    BinaryTreeNode getLeftChild();

    BinaryTreeNode getRightChild();

    void setLeftChild(BinaryTreeNode node);

    void setRightChild(BinaryTreeNode node);

    default boolean hasChild() {
        return getLeftChild() != null || getRightChild() != null;
    }
}
