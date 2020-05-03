package match.weekly.weekly187.p3;

import java.util.TreeMap;

class Solution {

    TreeMap<Integer, Integer> set;

    int maxDiff() {
        if (set.isEmpty()) return 0;
        return set.lastKey() - set.firstKey();
    }


    void add(int x) {
        set.merge(x, 1, Integer::sum);
    }

    void remove(int x) {
        if (set.containsKey(x)) {
            int o = set.get(x) - 1;
            if (o <= 0) set.remove(x);
            else set.put(x, o);
        }
    }


    public int longestSubarray(int[] nums, int limit) {
        set = new TreeMap<>();
        int a = 0, b = 0, ans = 0;
        while (b < nums.length) {
            add(nums[b++]);
            while (a < b && maxDiff() > limit) {
                remove(nums[a++]);
            }
            ans = Math.max(ans, b - a);
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().longestSubarray(new int[]{8, 2, 4, 7}, 4));
        System.out.println(new Solution().longestSubarray(new int[]{10, 1, 2, 4, 7, 2}, 5));
        System.out.println(new Solution().longestSubarray(new int[]{4, 2, 2, 2, 4, 4, 2, 2}, 0));
    }
}
