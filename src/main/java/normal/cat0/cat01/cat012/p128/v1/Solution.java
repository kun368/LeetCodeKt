package normal.cat0.cat01.cat012.p128.v1;

import java.util.HashMap;
import java.util.Map;

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

/**
 * 最长连续序列
 */
class Solution {

    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            mp.put(nums[i], i);
        }
        Bing bing = new Bing(nums.length);
        for (int i = 0; i < nums.length; ++i) {
            Integer id1 = mp.get(nums[i] + 1);
            Integer id2 = mp.get(nums[i] - 1);
            if (id1 != null) bing.union(i, id1);
            if (id2 != null) bing.union(i, id2);
        }
        int[] counter = new int[nums.length];
        for (Integer i : mp.values()) {
            counter[bing.find(i)] += 1;
        }
        int best = 0;
        for (int i : counter) {
            best = Math.max(i, best);
        }
        return best;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(solution.longestConsecutive(new int[]{0, 0, -1}));
    }
}

