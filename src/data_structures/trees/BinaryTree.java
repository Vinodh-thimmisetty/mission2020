package data_structures.trees;

/**
 * @author Vinodh Kumar Thimmisetty
 */
public class BinaryTree<T> {

    private BinaryTreeNode<T> root;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(final T rootValue) {
        this.root = new BinaryTreeNode<>(rootValue);
    }

    public BinaryTreeNode<T> getRoot() {
        return root;
    }

}
