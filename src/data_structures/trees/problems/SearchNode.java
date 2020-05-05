package data_structures.trees.problems;

import data_structures.ConsoleLogger;
import data_structures.trees.BinaryTreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

import static data_structures.trees.BinaryTreeUtil.getInstance;

/**
 * @author Vinodh Kumar Thimmisetty
 */
public class SearchNode {

    public static void main(String[] args) {
        ConsoleLogger.log(findRecursive(getInstance().getRoot(), 50));
        ConsoleLogger.log(findRecursive(getInstance().getRoot(), 150));
        ConsoleLogger.log(findIterativeQueue(getInstance().getRoot(), 50));
        ConsoleLogger.log(findIterativeQueue(getInstance().getRoot(), 150));
        ConsoleLogger.log(findIterativeStack(getInstance().getRoot(), 50));
        ConsoleLogger.log(findIterativeStack(getInstance().getRoot(), 150));
    }


    // PRE-ORDER
    public static boolean findRecursive(final BinaryTreeNode<Integer> root, Integer input) {
        return root != null && (
                root.getValue().equals(input) ||
                        findRecursive(root.getLeft(), input) ||
                        findRecursive(root.getRight(), input));

    }


    public static boolean findIterativeQueue(BinaryTreeNode<Integer> root, Integer input) {
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            root = queue.remove();
            if (root.getValue().equals(input)) return true;
            if (root.getLeft() != null) queue.add(root.getLeft());
            if (root.getRight() != null) queue.add(root.getRight());

        }
        return false;
    }

    private static boolean findIterativeStack(BinaryTreeNode<Integer> root, final Integer input) {

        Deque<BinaryTreeNode<Integer>> stack = new ArrayDeque<>();

        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.getLeft();
            }
            if (stack.isEmpty()) {
                return false;
            } else {
                root = stack.pop();
                if (root.getValue().equals(input)) return true;
                root = root.getRight();
            }
        }
    }
}
