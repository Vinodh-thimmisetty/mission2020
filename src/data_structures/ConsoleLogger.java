package data_structures;

import data_structures.trees.BinaryTreeNode;

/**
 * @author Vinodh Kumar Thimmisetty
 */
public class ConsoleLogger {

    private static final String NEXT_POINTER = " --> ";


    public static void log(String message) {
        System.out.println(message);
    }

    public static void log(Integer result) {
        System.out.println(result);
    }

    public static void log(Object object) {
        System.out.println(object);
    }

    public static <T> void printNodeValue(BinaryTreeNode<T> node) {
        log(node.getValue().toString() + NEXT_POINTER);
    }
}
