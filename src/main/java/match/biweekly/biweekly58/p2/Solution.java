package match.biweekly.biweekly58.p2;

import java.util.ArrayList;
import java.util.List;

class Solution {

    private boolean check(int x, int y) {
        return x >= 0 && y >= 0 && x < 8 && y < 8;
    }

    private final int[][] dirs = new int[][]{
            {-1, -1}, {1, 1},
            {-1, 1}, {1, -1},
            {-1, 0}, {1, 0},
            {0, -1}, {0, 1}
    };

    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        board[rMove][cMove] = color;
        for (int[] dir : dirs) {
            List<Character> t = new ArrayList<>();
            for (int i = 0; i < 8; ++i) {
                int x = rMove + i * dir[0];
                int y = cMove + i * dir[1];
                if (check(x, y)) {
                    t.add(board[x][y]);
                } else {
                    break;
                }
            }
            System.out.println(t);
            if (t.size() <= 2) continue;
            char neg = color == 'W' ? 'B' : 'W';
            if (t.get(1) != neg) continue;

            boolean ok = false;
            for (int i = 2; i < t.size(); ++i) {
                if (t.get(i) == '.') {
                    break;
                } else if (t.get(i) == color) {
                    ok = true;
                    break;
                }
            }
            if (ok) return true;
        }
        return false;
    }
}