package normal.cat0.cat00.cat007.p73.v1;

import java.util.*;

class Solution {
    public void setZeroes(int[][] matrix) {
        int N = matrix.length, M = matrix[0].length;
        Set<Integer> fx = new HashSet<>(N), fy = new HashSet<>(M);
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (matrix[i][j] == 0) {
                    fx.add(i);
                    fy.add(j);
                }
            }
        }
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (fx.contains(i) || fy.contains(j)) {
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
