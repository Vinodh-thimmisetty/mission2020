package data_structures.trees;

/**
 * @author Vinodh Kumar Thimmisetty
 */
public class BinaryTreeUtil {

    public static BinaryTree<Integer> getInstance() {
        final BinaryTree<Integer> bTree = new BinaryTree<>(10);
        bTree.getRoot().setLeft(new BinaryTreeNode<>(20));
        bTree.getRoot().setRight(new BinaryTreeNode<>(30));
        bTree.getRoot().getLeft().setLeft(new BinaryTreeNode<>(40));
        bTree.getRoot().getLeft().setRight(new BinaryTreeNode<>(50));
        bTree.getRoot().getRight().setLeft(new BinaryTreeNode<>(60));
        bTree.getRoot().getRight().setRight(new BinaryTreeNode<>(70));
        return bTree;
    }

}
