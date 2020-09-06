package match.biweekly.biweekly33.p2;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] dp = new int[n];
        for (List<Integer> road : edges) {
            int x = road.get(1);
            dp[x] = 1;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (dp[i] == 0) res.add(i);
        }
        return res;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("1");
    }
}
