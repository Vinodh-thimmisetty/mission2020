package data_structures;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Vinodh Kumar Thimmisetty
 */

public class JumpThroughHoles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> collect = Stream.of(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int totalHoles = collect.get(0);
        int W = collect.get(1);
        int L = collect.get(2);
        char[][] matrix = new char[L][W];
//        for (int i = 0; i < W; i++) {
//            for (int j = 0; j < L; j++) {
//                matrix[i][j] = 'T';
//            }
//        }

        for (int i = 0; i < totalHoles; i++) {
            List<Integer> holePosition = Stream.of(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

            int x1 = holePosition.get(0);
            int y1 = holePosition.get(1);
            int x2 = holePosition.get(2);
            int y2 = holePosition.get(3);

            for (int j = y1; j < x1; j++) {
                for (int k = y2; k > x2; k--) {
                    try {
                        matrix[j][k] = 'F';
                    } catch (ArrayIndexOutOfBoundsException ignored) {
                    }
                }
            }
        }


        for (int i = 0; i < W; i++) {
            for (int j = 0; j < L; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }


}
