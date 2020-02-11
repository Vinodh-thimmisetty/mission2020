package data_structures;

import data_structures.trees.BinaryTreeTraversal;

import static data_structures.trees.BinaryTreeUtil.getInstance;

/**
 * @author Vinodh Kumar Thimmisetty
 */
public class Demo {

    public static void main(String[] args) {

        System.out.println("----- Iterative Traversal-----");
        new BinaryTreeTraversal<Integer>()
                .preOrderTraversalIterative(getInstance().getRoot());
        System.out.println();
        new BinaryTreeTraversal<Integer>()
                .inOrderTraversalIterative(getInstance().getRoot());
        System.out.println();
        new BinaryTreeTraversal<Integer>()
                .postOrderTraversalIterative(getInstance().getRoot());
        System.out.println();
        new BinaryTreeTraversal<Integer>()
                .levelOrderTraversalIterative(getInstance().getRoot());
        System.out.println("\n----- Recursive Traversal-----");
        new BinaryTreeTraversal<Integer>()
                .preOrderTraversalRecursion(getInstance().getRoot());
        System.out.println();
        new BinaryTreeTraversal<Integer>()
                .inOrderTraversalRecursion(getInstance().getRoot());
        System.out.println();
        new BinaryTreeTraversal<Integer>()
                .postOrderTraversalRecursion(getInstance().getRoot());

    }
}
