package cat102.p1029.v1;

import java.util.Arrays;
import java.util.Comparator;

class Solution {

    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, Comparator.comparingInt(o -> (o[0] - o[1])));
        int sum = 0;
        for (int i = 0; i < costs.length; ++i) {
            if (i < costs.length / 2) sum += costs[i][0];
            else sum += costs[i][1];
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.twoCitySchedCost(new int[][]{
                new int[]{10, 20},
                new int[]{30, 200},
                new int[]{400, 50},
                new int[]{30, 20},
        }));
    }
}