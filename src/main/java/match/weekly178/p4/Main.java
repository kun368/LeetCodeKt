package match.weekly178.p4;

import utils.java.DebugUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {

    private static final int[][] dir = {{0, 0}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    class Node {
        int rx, ry, cnt;

        public Node(int rx, int ry, int cnt) {
            this.rx = rx;
            this.ry = ry;
            this.cnt = cnt;
        }
    }

    public int minCost(int[][] grid) {
        int N = grid.length, M = grid[0].length;
        int[][] vis = new int[N][M];
        for (int i = 0; i < N; ++i) {
            Arrays.fill(vis[i], Integer.MAX_VALUE);
        }

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cnt));
        Node node = new Node(0, 0, 0);
        queue.add(node);
        vis[0][0] = 0;
        while (!queue.isEmpty()) {
            Node top = queue.poll();
            if (top.rx == N - 1 && top.ry == M - 1) {
                return top.cnt;
            }
            if (top.cnt > vis[top.rx][top.ry]) {
                continue;
            }
            for (int i = 1; i <= 4; ++i) {
                int cost = i == grid[top.rx][top.ry] ? 0 : 1;
                int nx = top.rx + dir[i][0];
                int ny = top.ry + dir[i][1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }
                if (top.cnt + cost >= vis[nx][ny]) {
                    continue;
                }
                Node next = new Node(nx, ny, top.cnt + cost);
                queue.add(next);
                vis[nx][ny] = next.cnt;
            }
        }
        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().minCost(DebugUtils.parseIntArr2("[[1,1,1,1],[2,2,2,2],[1,1,1,1],[2,2,2,2]]")));
        System.out.println(new Solution().minCost(DebugUtils.parseIntArr2("[[1,1,3],[3,2,2],[1,1,4]]")));
        System.out.println(new Solution().minCost(DebugUtils.parseIntArr2("[[1,2],[4,3]]")));
        System.out.println(new Solution().minCost(DebugUtils.parseIntArr2("[[2,2,2],[2,2,2]]")));
        System.out.println(new Solution().minCost(DebugUtils.parseIntArr2("[[4]]")));
    }
}
