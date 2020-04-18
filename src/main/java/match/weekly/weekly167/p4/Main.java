package match.weekly.weekly167.p4;

import utils.java.ArrayInputUtils;

import java.util.*;

class Solution {

    static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static class Node {
        int x, y, use, ans;

        public Node(int x, int y, int use, int ans) {
            this.x = x;
            this.y = y;
            this.use = use;
            this.ans = ans;
        }
    }

    public int shortestPath(int[][] grid, int k) {
        int N = grid.length, M = grid[0].length;
        boolean[][][] vis = new boolean[N + 1][M + 1][k + 1];
        Queue<Node> qu = new LinkedList<>();
        Node head = new Node(0, 0, 0, 0);
        qu.add(head);
        vis[0][0][0] = true;
        int ans = Integer.MAX_VALUE;
        while (!qu.isEmpty()) {
            Node top = qu.poll();
            if (top.x == N - 1 && top.y == M - 1) {
                ans = Math.min(ans, top.ans);
            }
            for (int[] dir : dirs) {
                int xx = top.x + dir[0];
                int yy = top.y + dir[1];
                if (xx < 0 || xx >= N || yy < 0 || yy >= M) {
                    continue;
                }
                int use = grid[xx][yy] == 1 ? top.use + 1 : top.use;
                if (use > k) {
                    continue;
                }
                Node next = new Node(xx, yy, use, top.ans + 1);
                if (vis[next.x][next.y][next.use]) {
                    continue;
                }
                qu.add(next);
                vis[next.x][next.y][next.use] = true;
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().shortestPath(ArrayInputUtils.parseIntArr2("[[0,0,0],\n" +
                " [1,1,0],\n" +
                " [0,0,0],\n" +
                " [0,1,1],\n" +
                " [0,0,0]]"), 6));
        System.out.println(new Solution().shortestPath(ArrayInputUtils.parseIntArr2("[[0,1,1],\n" +
                " [1,1,1],\n" +
                " [1,0,0]]"), 1));
        System.out.println(new Solution().shortestPath(ArrayInputUtils.parseIntArr2("[[0,0,0,1,0,1,0,0,0,1,0,1,1,1,1,0,0,0],[1,0,0,0,1,0,0,1,0,0,1,0,0,1,0,1,1,0],[1,0,0,1,1,1,0,0,0,1,1,0,0,1,1,1,0,1],[0,0,1,0,0,0,1,0,0,0,0,1,0,0,1,1,0,1],[1,1,0,0,0,0,0,0,0,0,1,1,0,0,1,1,1,1],[0,0,1,1,0,0,0,1,0,0,0,1,0,0,1,1,0,0],[0,0,0,0,0,1,1,0,1,0,0,1,1,1,1,1,0,0],[1,1,1,0,1,0,1,0,1,0,0,0,0,0,0,1,0,0],[0,0,1,1,0,0,1,0,0,1,1,1,1,1,0,0,1,0],[1,0,0,0,0,1,1,1,1,1,0,0,1,1,1,1,0,0],[0,0,1,1,1,0,0,0,1,1,0,1,0,1,1,1,1,0],[1,0,0,0,0,0,1,0,0,1,1,0,1,0,0,1,1,1],[0,0,1,0,1,0,0,0,1,1,0,0,1,0,1,0,0,0],[1,1,0,0,1,1,1,0,0,0,1,0,0,0,1,0,1,0],[1,0,1,1,1,1,0,1,0,1,0,1,0,0,0,0,0,0],[0,0,0,0,0,1,0,1,0,0,0,1,1,1,1,1,1,0],[0,0,1,0,1,1,1,1,1,1,1,1,1,1,1,0,0,1],[0,1,1,1,0,0,0,1,1,0,0,0,1,0,1,0,0,0],[1,1,1,0,0,0,1,1,0,0,0,1,0,1,0,0,1,1],[0,0,1,1,1,1,0,1,0,0,1,1,0,1,1,1,1,0],[0,1,1,0,1,0,0,1,0,1,0,0,0,0,0,0,1,1],[1,1,0,0,1,0,0,1,0,1,1,1,0,0,0,1,0,1],[0,0,1,1,0,1,0,1,0,1,1,1,0,0,1,1,0,1],[0,1,0,0,0,0,1,0,1,0,1,0,1,1,1,0,1,0],[0,1,0,0,1,0,0,0,0,1,0,0,1,1,0,0,1,1],[0,1,1,1,1,1,0,1,1,1,0,1,0,0,0,1,0,0],[0,0,1,0,1,0,1,1,1,0,1,0,0,0,0,0,1,1],[0,0,0,1,1,0,0,1,1,0,0,0,0,1,0,0,1,0],[1,1,1,1,0,1,0,0,1,0,0,0,1,1,0,0,1,0],[0,1,0,1,0,1,0,0,0,1,0,0,1,0,1,0,1,0],[1,0,0,1,0,0,1,1,1,1,1,1,1,1,0,1,1,0],[1,1,1,1,1,0,1,0,1,1,1,0,0,0,1,0,0,1],[0,0,0,0,1,0,1,1,1,1,1,0,0,1,0,1,0,1],[1,0,0,1,0,0,1,0,0,0,1,1,0,0,0,0,1,0],[1,0,1,1,1,0,1,0,0,1,1,0,0,1,1,1,0,0],[1,1,1,1,1,1,0,0,0,0,0,1,0,0,1,1,1,0],[0,1,0,0,1,1,1,0,0,0,1,1,0,1,0,0,1,0],[1,0,1,1,0,0,0,0,0,1,1,1,0,0,1,1,1,1],[1,1,0,0,0,1,1,0,0,0,0,1,0,1,1,0,0,0],[0,1,1,1,0,1,1,0,1,1,1,1,0,1,1,1,0,0]]\n"),
                696));
    }
}
