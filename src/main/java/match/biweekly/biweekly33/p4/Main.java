package match.biweekly.biweekly33.p4;

import utils.java.DebugUtils;

class Solution {

    private static final int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private char[][] grid;
    private int N, M;
    private int[][] vis;

    private boolean dfs(int x, int y, int deep) {
        for (int[] d : dir) {
            int xx = x + d[0], yy = y + d[1];
            if (xx >= 0 && xx < N && yy >= 0 && yy < M && grid[xx][yy] == grid[x][y]) {
                if (vis[xx][yy] == 0) {
                    vis[xx][yy] = deep + 1;
                    if (dfs(xx, yy, deep + 1)) return true;
                } else if (vis[xx][yy] < deep - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsCycle(char[][] grid) {
        this.grid = grid;
        N = grid.length;
        M = grid[0].length;
        vis = new int[N][M];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (vis[i][j] == 0) {
                    vis[i][j] = 1;
                    if (dfs(i, j, 1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().containsCycle(DebugUtils.parseCharArr2(
                "[[\"a\",\"a\",\"a\",\"a\"],[\"a\",\"b\",\"b\",\"a\"],[\"a\",\"b\",\"b\",\"a\"],[\"a\",\"a\",\"a\",\"a\"]]"
        )));
        System.out.println(new Solution().containsCycle(DebugUtils.parseCharArr2(
                "[[\"c\",\"c\",\"c\",\"a\"],[\"c\",\"d\",\"c\",\"c\"],[\"c\",\"c\",\"e\",\"c\"],[\"f\",\"c\",\"c\",\"c\"]]"
        )));
        System.out.println(new Solution().containsCycle(DebugUtils.parseCharArr2(
                "[[\"a\",\"b\",\"b\"],[\"b\",\"z\",\"b\"],[\"b\",\"b\",\"a\"]]"
        )));
    }
}
