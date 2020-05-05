package data_structures.trees;

/**
 * @author Vinodh Kumar Thimmisetty
 */
public class DemoBinarySearchTree {

    public static void main(String[] args) {
        int[] input = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int searchFor = 70;
        System.out.println(bst(input, searchFor));

    }

    public static boolean bst(int[] input, int search) {
        int low = 0, high = input.length - 1;
        while (low <= high) {
            int mid = low + high / 2;
            if (input[mid] == search) return true;
            if (input[mid] < search) high = mid - 1;
            else low = mid + 1;
        }
        return false;
    }
}
