package match.weekly.weekly173.p3;

import utils.java.DebugUtils;

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] d = new int[n][n];
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1], w = edge[2];
            d[from][to] += w;
            d[to][from] += w;
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (d[i][j] == 0)
                    d[i][j] = Integer.MAX_VALUE / 2;
            }
        }
        for (int k = 0; k < n; ++k)
            for (int i = 0; i < n; ++i)
                for (int j = 0; j < n; ++j)
                    d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);

        int ans = -1, pef = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            int cur = 0;
            for (int j = 0; j < n; ++j) {
                if (j != i && d[i][j] <= distanceThreshold) {
                    cur += 1;
                }
            }
            if (cur <= pef) {
                pef = cur;
                ans = i;
            }
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().findTheCity(4, DebugUtils.parseIntArr2("[[0,1,3],[1,2,1],[1,3,4],[2,3,1]]"), 4));
        System.out.println(new Solution().findTheCity(5, DebugUtils.parseIntArr2("[[0,1,2],[0,4,8],[1,2,3],[1,4,2],[2,3,1],[3,4,1]]"), 2));
    }
}
