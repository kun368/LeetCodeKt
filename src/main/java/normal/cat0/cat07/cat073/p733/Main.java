package normal.cat0.cat07.cat073.p733;

import utils.java.DebugUtils;

import java.util.Arrays;

class Solution {

    private static final int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private int[][] image;
    private int preColor, newColor;

    private void dfs(int x, int y) {
        if (x < 0 || y < 0 || x >= image.length || y >= image[0].length || image[x][y] != preColor) {
            return;
        }
        image[x][y] = newColor;
        for (int[] d : dir) {
            dfs(x + d[0], y + d[1]);
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image;
        }
        this.image = image;
        this.newColor = newColor;
        this.preColor = image[sr][sc];
        dfs(sr, sc);
        return image;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution().floodFill(DebugUtils.parseIntArr2("[[1,1,1],[1,1,0],[1,0,1]]"), 1, 1, 2)));
    }
}
