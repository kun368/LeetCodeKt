package normal.cat0.cat00.cat007.p79;


import utils.java.DebugUtils;

import java.util.Arrays;

class Solution {

    private static final int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private char[][] board;
    private String word;
    private boolean found;
    private boolean[][] visited;

    private void dfs(int index, int x, int y) {
        if (index >= word.length()) {
            found = true;
            return;
        }
        if (found || x < 0 || y < 0 || x >= board.length || y >= board[0].length
                || visited[x][y] || board[x][y] != word.charAt(index)) {
            return;
        }
        visited[x][y] = true;
        for (int[] d : dir) {
            dfs(index + 1, x + d[0], y + d[1]);
        }
        visited[x][y] = false;
    }

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        this.found = false;
        this.visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                dfs(0, i, j);
            }
        }
        return found;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        char[][] chars = DebugUtils.parseCharArr2("[['A','B','C','E'],['S','F','C','S'],['A','D','E','E']]");
        System.out.println(Arrays.deepToString(chars));
        System.out.println(new Solution().exist(chars, "ABCCED"));
        System.out.println(new Solution().exist(chars, "SEE"));
        System.out.println(new Solution().exist(chars, "ABCB"));
    }
}
