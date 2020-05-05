package data_structures.trees;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

import static data_structures.ConsoleLogger.printNodeValue;

/**
 * @author Vinodh Kumar Thimmisetty
 */
public class BinaryTreeTraversal<T> {


    public void preOrderTraversalRecursion(BinaryTreeNode<T> node) {
        if (Objects.isNull(node)) return;
        printNodeValue(node);
        preOrderTraversalRecursion(node.getLeft());
        preOrderTraversalRecursion(node.getRight());
    }

    public void inOrderTraversalRecursion(BinaryTreeNode<T> node) {
        if (Objects.isNull(node)) return;
        inOrderTraversalRecursion(node.getLeft());
        printNodeValue(node);
        inOrderTraversalRecursion(node.getRight());
    }

    public void postOrderTraversalRecursion(BinaryTreeNode<T> node) {
        if (Objects.isNull(node)) return;
        postOrderTraversalRecursion(node.getLeft());
        postOrderTraversalRecursion(node.getRight());
        printNodeValue(node);
    }

    public void preOrderTraversalIterative(BinaryTreeNode<T> node) {
        Deque<BinaryTreeNode<T>> stack = new ArrayDeque<>();
        stack.push(node);
        do {
            node = stack.pop();
            printNodeValue(node);
            final BinaryTreeNode<T> rightNode = node.getRight();
            final BinaryTreeNode<T> leftNode = node.getLeft();
            if (rightNode != null) {
                stack.push(rightNode);
            }
            if (leftNode != null) {
                stack.push(leftNode);
            }

        } while (!stack.isEmpty());
    }

    public void inOrderTraversalIterative(BinaryTreeNode<T> node) {
        Deque<BinaryTreeNode<T>> stack = new ArrayDeque<>();
        do {
            while (node != null) {
                stack.push(node);
                node = node.getLeft();
            }
            final BinaryTreeNode<T> topNode = stack.peek();
            if (topNode != null) {
                printNodeValue(topNode);
                node = stack.pop().getRight();
            }
        } while (node != null || !stack.isEmpty());
    }

    public void postOrderTraversalIterative(BinaryTreeNode<T> node) {
        Deque<BinaryTreeNode<T>> stack = new ArrayDeque<>();
        BinaryTreeNode<T> prevVisitedNode = null;
        do {
            while (node != null) {
                stack.push(node);
                node = node.getLeft();
            }
            BinaryTreeNode<T> topNode = stack.peek();
            if (topNode != null) {
                if (topNode.getRight() != null && topNode.getRight() != prevVisitedNode) {
                    prevVisitedNode = node = topNode.getRight();
                } else {
                    printNodeValue(topNode);
                    prevVisitedNode = stack.pop();
                }
            }

        } while (!stack.isEmpty());
    }

    public void levelOrderTraversalIterative(BinaryTreeNode<T> node) {

        Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
        queue.add(node);
        do {
            final BinaryTreeNode<T> firstElem = queue.remove();
            if (firstElem.getLeft() != null) queue.add(firstElem.getLeft());
            if (firstElem.getRight() != null) queue.add(firstElem.getRight());
            printNodeValue(firstElem);
        } while (!queue.isEmpty());

    }

}
