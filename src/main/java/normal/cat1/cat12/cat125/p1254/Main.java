package normal.cat1.cat12.cat125.p1254;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 纯并查集做法
 */
class Solution {

    private Map<String, String> par = new HashMap<>();

    private String find(String s) {
        if (s.equals(par.get(s))) {
            return s;
        }
        String pa = find(par.get(s));
        par.put(s, pa);
        return pa;
    }

    private String genKey(int x, int y) {
        return x + "#" + y;
    }

    public int closedIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] != 0) continue;
                par.put(genKey(i, j), genKey(i, j));
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] != 0) continue;
                if (i + 1 < n && grid[i + 1][j] == 0)
                    par.put(find(genKey(i, j)), find(genKey(i + 1, j)));
                if (j + 1 < m && grid[i][j + 1] == 0)
                    par.put(find(genKey(i, j)), find(genKey(i, j + 1)));
            }
        }
        Set<String> ok = new HashSet<>(), no = new HashSet<>();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] != 0) continue;
                String pa = find(genKey(i, j));
                ok.add(pa);
                if (i == 0 || j == 0 || i + 1 == n || j + 1 == m) {
                    no.add(pa);
                }
            }
        }
        ok.removeAll(no);
        return ok.size();
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().closedIsland(new int[][]{
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 1, 0},
                {1, 0, 1, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0}
        }));
        System.out.println(new Solution().closedIsland(new int[][]{
                {0, 0, 1, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 1, 1, 1, 0}
        }));
        System.out.println(new Solution().closedIsland(new int[][]{
                {1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1}
        }));
    }
}
