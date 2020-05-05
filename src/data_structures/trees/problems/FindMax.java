package data_structures.trees.problems;

import data_structures.ConsoleLogger;
import data_structures.trees.BinaryTreeNode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

import static data_structures.trees.BinaryTreeUtil.getInstance;

/**
 * @author Vinodh Kumar Thimmisetty
 */
public class FindMax {

    public static void main(String[] args) {
        ConsoleLogger.log(findMaxRecursion(getInstance().getRoot()));
        ConsoleLogger.log(findMaxIterative(getInstance().getRoot()));
    }


    public static int findMaxRecursion(BinaryTreeNode<Integer> node) {
        int leftTreeVal = Integer.MIN_VALUE;
        int rightTreeVal = Integer.MIN_VALUE;
        int rootVal = Integer.MIN_VALUE;
        int maxVal = Integer.MIN_VALUE;

        if (node != null) {
            rootVal = node.getValue();
            leftTreeVal = findMaxRecursion(node.getLeft());
            rightTreeVal = findMaxRecursion(node.getRight());
        }

        return Stream
                .of(maxVal, rootVal, leftTreeVal, rightTreeVal)
                .max(Comparator.naturalOrder())
                .orElse(-1);
    }

    public static int findMaxIterative(BinaryTreeNode<Integer> root) {

        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);

        int max = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {
            if (root.getLeft() != null) queue.add(root.getLeft());
            if (root.getRight() != null) queue.add(root.getRight());
            root = queue.remove();

            if (max < root.getValue()) {
                max = root.getValue();
            }
        }
        return max;
    }


}
