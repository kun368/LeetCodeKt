package match.weekly.weekly171.p3;

import utils.java.ArrayInputUtils;

class Solution {

    class Bing {

        private int[] pa;

        Bing(int maxn) {
            this.pa = new int[maxn];
            for (int i = 0; i < maxn; ++i) {
                this.pa[i] = i;
            }
        }

        int find(int x) {
            return pa[x] == x ? x : (pa[x] = find(pa[x]));
        }

        int union(int x, int y) {
            return pa[find(x)] = find(y);
        }
    }

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        Bing bing = new Bing(n);
        for (int[] i : connections) {
            bing.union(i[0], i[1]);
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (bing.find(i) == i) {
                ans += 1;
            }
        }
        return ans - 1;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().makeConnected(6, ArrayInputUtils.parseIntArr2("[[0,1],[0,2],[0,3],[1,2],[1,3]]")));
        System.out.println(new Solution().makeConnected(6, ArrayInputUtils.parseIntArr2("[[0,1],[0,2],[0,3],[1,2]]")));
        System.out.println(new Solution().makeConnected(5, ArrayInputUtils.parseIntArr2("[[0,1],[0,2],[3,4],[2,3]]")));
    }
}
