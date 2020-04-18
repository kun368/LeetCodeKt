package match.weekly.weekly164.p2;

class Solution {
    public int countServers(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] cntn = new int[n + 1];
        int[] cntm = new int[m + 1];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] > 0) {
                    ++cntn[i];
                    ++cntm[j];
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] > 0) if (cntn[i] >= 2 || cntm[j] >= 2) ++ans;
            }
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().countServers(new int[][]{
                {1, 0},
                {0, 1},
        }));
        System.out.println(new Solution().countServers(new int[][]{
                {1, 0},
                {1, 1},
        }));
        System.out.println(new Solution().countServers(new int[][]{
                {1, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1},
        }));
    }
}
