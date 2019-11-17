package match.weekly163.p1;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        List<Integer> list = new ArrayList<>();
        for (int[] i : grid) for (int j : i) list.add(j);
        int cur = list.size() - (k % list.size());
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < m; ++j) {
                cur %= list.size();
                row.add(list.get(cur));
                cur += 1;
            }
            ret.add(row);
        }
        return ret;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().shiftGrid(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        }, 9));
    }
}
