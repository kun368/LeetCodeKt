package cat1.cat12.cat125.p1252;

class Solution {
    public int oddCells(int n, int m, int[][] indices) {
        int[][] tab = new int[n][m];
        for (int[] i : indices) {
            int rx = i[0], ry = i[1];
            for (int j = 0; j < n; ++j) tab[j][ry] += 1;
            for (int j = 0; j < m; ++j) tab[rx][j] += 1;
        }
        int ret = 0;
        for (int[] i : tab) for (int j : i) ret += j % 2;
        return ret;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().oddCells(2, 3, new int[][]{{0, 1}, {1, 1}}));
        System.out.println(new Solution().oddCells(2, 2, new int[][]{{1, 1}, {0, 0}}));
    }
}
