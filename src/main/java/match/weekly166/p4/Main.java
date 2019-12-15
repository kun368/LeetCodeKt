package match.weekly166.p4;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

class Solution {

    static class Pair {

        public int val;
        public int len;

        public Pair(int val, int len) {
            this.val = val;
            this.len = len;
        }
    }

    static int[][] dir = new int[][]{{0, 0}, {-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int change(int pre, int N, int M, int x, int y) {
        int ans = pre;
        for (int[] d : dir) {
            int xx = x + d[0];
            int yy = y + d[1];
            if (xx >= 0 && yy >= 0 && xx < N && yy < M) {
                int pos = xx * M + yy;
                ans ^= (1 << pos);
            }
        }
        return ans;
    }

    public int minFlips(int[][] mat) {
        int N = mat.length;
        int M = mat[0].length;

        int ansVal = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (mat[i][j] == 1) ansVal |= (1 << (i * M + j));
            }
        }

        Map<Integer, Integer> vis = new HashMap<>();
        Queue<Pair> qu = new ArrayDeque<>();
        qu.add(new Pair(0, 0));
        while (!qu.isEmpty()) {
            Pair top = qu.poll();
            vis.put(top.val, top.len);
            if (top.val == ansVal) {
                return top.len;
            }
            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < M; ++j) {
                    int next = change(top.val, N, M, i, j);
                    if (!vis.containsKey(next)) {
                        qu.add(new Pair(next, top.len + 1));
                    }
                }
            }
        }
        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().minFlips(new int[][]{
                {0, 0},
                {0, 1}
        }));
        System.out.println(new Solution().minFlips(new int[][]{
                {0}
        }));
        System.out.println(new Solution().minFlips(new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {0, 0, 0}
        }));
        System.out.println(new Solution().minFlips(new int[][]{
                {1, 0, 0},
                {1, 0, 0}
        }));
    }
}
