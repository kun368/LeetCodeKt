package match.season.spring2020.p2;


import utils.java.DebugUtils;

class Solution {

    private int n, k;
    private int[][] relation;
    private int ans;

    public int numWays(int n, int[][] relation, int k) {
        this.n = n;
        this.k = k;
        this.relation = relation;
        this.ans = 0;
        dfs(0, 0);
        return this.ans;
    }

    private void dfs(int cur, int d) {
        if (cur == n - 1 && d == k) {
            ans += 1;
        }
        if (d >= k) {
            return;
        }
        for (int[] i : relation) {
            if (i[0] == cur) {
                dfs(i[1], d + 1);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().numWays(
                5, DebugUtils.parseIntArr2("[[0,2],[2,1],[3,4],[2,3],[1,4],[2,0],[0,4]]"), 3));
        System.out.println(new Solution().numWays(
                3, DebugUtils.parseIntArr2("[[0,2],[2,1]]"), 2));
    }
}
