package normal.cat0.cat00.cat007.p74;

class Solution {

    private int get(int[][] matrix, int idx) {
        int r = idx / matrix[0].length;
        int c = idx % matrix[0].length;
        return matrix[r][c];
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        final int N = matrix.length, M = matrix[0].length;
        int L = 0, R = N * M;
        while (L < R) {
            int mid = (L + R) / 2;
            int v = get(matrix, mid);
            if (v == target) {
                return true;
            } else if (v < target) {
                L = mid + 1;
            } else {
                R = mid;
            }
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().searchMatrix(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        }, 3));
        System.out.println(new Solution().searchMatrix(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        }, 13));
        System.out.println(new Solution().searchMatrix(new int[][]{{1}}, 2));
    }
}
