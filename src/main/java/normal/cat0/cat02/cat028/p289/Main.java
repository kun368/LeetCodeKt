package normal.cat0.cat02.cat028.p289;

import java.util.Arrays;

class Solution {

    private static final int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    private int N, M;

    private boolean isIn(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }

    public void gameOfLife(int[][] board) {
        N = board.length;
        M = board[0].length;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (board[i][j] % 100 != 1) continue;
                for (int[] dir : dirs) {
                    int xx = i + dir[0], yy = j + dir[1];
                    if (isIn(xx, yy)) {
                        board[xx][yy] += 100;
                    }
                }
            }
        }
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                int cnt = board[i][j] / 100;
                int state = board[i][j] % 100;
                if (state == 1 && (cnt < 2 || cnt > 3)) {
                    board[i][j] = 0;
                } else if (state == 0 && cnt == 3) {
                    board[i][j] = 1;
                } else {
                    board[i][j] = state;
                }
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] arr = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        new Solution().gameOfLife(arr);
        System.out.println(Arrays.deepToString(arr));
    }
}
