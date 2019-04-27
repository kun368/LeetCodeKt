package cat007.p73.v1;

import java.util.Arrays;

class Solution {

    private static final int fuck = -0x3f3f3f3f;

    public void setZeroes(int[][] matrix) {
        while (true) {
            int x = -1, y = -1;
            for (int i = 0; i < matrix.length; ++i) {
                for (int j = 0; j < matrix[i].length; ++j) {
                    if (matrix[i][j] == 0) {
                        x = i;
                        y = j;
                        break;
                    }
                }
                if (x != -1) break;
            }
            System.out.println("x = " + x + ", y = " + y);
            if (x == -1) break;
            for (int i = 0; i < matrix.length; ++i) {
                for (int j = 0; j < matrix[i].length; ++j) {
                    if ((i == x || j == y) && matrix[i][j] != 0) {
                        matrix[i][j] = fuck;
                    }
                }
            }
        }
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                if (matrix[i][j] == fuck) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                new int[]{1, 1, 1},
                new int[]{1, 0, 1},
                new int[]{1, 1, 1}
        };
        Solution solution = new Solution();
        solution.setZeroes(arr);
        System.out.println(Arrays.deepToString(arr));

        arr = new int[][]{
                new int[]{0, 1, 2, 0},
                new int[]{3, 4, 5, 2},
                new int[]{1, 3, 1, 5}
        };
        solution.setZeroes(arr);
        System.out.println(Arrays.deepToString(arr));
    }
}
