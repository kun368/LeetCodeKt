package normal.cat2.cat21.p2146;

import utils.java.ArrayInputUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    private static final int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static class Node {
        int dis, price, x, y;

        public Node(int dis, int price, int x, int y) {
            this.dis = dis;
            this.price = price;
            this.x = x;
            this.y = y;
        }
    }

    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        int m = grid.length, n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        List<Node> nodes = new ArrayList<>(m * n);
        int quStart = 0;
        Node head = new Node(0, grid[start[0]][start[1]], start[0], start[1]);
        nodes.add(head);
        vis[head.x][head.y] = true;

        while (quStart < nodes.size()) {
            Node top = nodes.get(quStart++);
            for (int i = 0; i < 4; ++i) {
                int x = top.x + dir[i][0];
                int y = top.y + dir[i][1];
                if (x < 0 || y < 0 || x >= m || y >= n) continue;
                if (grid[x][y] == 0) continue;
                Node next = new Node(top.dis + 1, grid[x][y], x, y);
                if (!vis[x][y]) {
                    nodes.add(next);
                    vis[x][y] = true;
                }
            }
        }

        List<Node> priceNodes = new ArrayList<>();
        for (Node it : nodes) {
            if (it.price >= pricing[0] && it.price <= pricing[1]) {
                priceNodes.add(it);
            }
        }
        priceNodes.sort((o1, o2) -> {
            if (o1.dis != o2.dis) return Integer.compare(o1.dis, o2.dis);
            if (o1.price != o2.price) return Integer.compare(o1.price, o2.price);
            if (o1.x != o2.x) return Integer.compare(o1.x, o2.x);
            return Integer.compare(o1.y, o2.y);
        });

        List<List<Integer>> retNodes = new ArrayList<>(Math.min(k, priceNodes.size()));
        for (int i = 0; i < k && i < priceNodes.size(); ++i) {
            Node cur = priceNodes.get(i);
            retNodes.add(Arrays.asList(cur.x, cur.y));
        }
        return retNodes;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().highestRankedKItems(
                ArrayInputUtils.parseIntArr2("[[1,2,0,1],[1,3,0,1],[0,2,5,1]]"),
                new int[]{2, 5},
                new int[]{0, 0},
                3
        )); // [[0, 1], [1, 1], [2, 1]]
        System.out.println(new Solution().highestRankedKItems(
                ArrayInputUtils.parseIntArr2("[[1,2,0,1],[1,3,3,1],[0,2,5,1]]"),
                new int[]{2, 3},
                new int[]{2, 3},
                2
        )); // [[2, 1], [1, 2]]
        System.out.println(new Solution().highestRankedKItems(
                ArrayInputUtils.parseIntArr2("[[1,1,1],[0,0,1],[2,3,4]]"),
                new int[]{2, 3},
                new int[]{0, 0},
                3
        )); // [[2, 1], [2, 0]]
        System.out.println(new Solution().highestRankedKItems(
                ArrayInputUtils.parseIntArr2("[[0,2,0]]"),
                new int[]{2, 2},
                new int[]{0, 1},
                1
        )); // [[0,1]]
    }
}
