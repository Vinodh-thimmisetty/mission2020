package data_structures.trees;

/**
 * @author Vinodh Kumar Thimmisetty
 */
public class BinaryTreeNode<T> {

    private T value;
    private BinaryTreeNode<T> left, right;

    public BinaryTreeNode(final T value) {
        this.value = value;
        this.left = this.right = null;
    }

    public T getValue() {
        return value;
    }

    public void setValue(final T value) {
        this.value = value;
    }

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(final BinaryTreeNode<T> left) {
        this.left = left;
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }

    public void setRight(final BinaryTreeNode<T> right) {
        this.right = right;
    }

}
