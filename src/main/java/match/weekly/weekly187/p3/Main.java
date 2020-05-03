package match.weekly.weekly187.p3;

import java.util.TreeMap;

class Solution {

    private static class MultiSet {

        public TreeMap<Integer, Integer> map = new TreeMap<>();

        public void add(int x) {
            map.merge(x, 1, Integer::sum);
        }

        public void removeOnce(int x) {
            map.computeIfPresent(x, (key, oldValue) -> {
                int t = oldValue - 1;
                return t <= 0 ? null : t;
            });
        }

        public boolean contains(int x) {
            return map.containsKey(x);
        }

        int maxDiff() {
            if (map.isEmpty()) return 0;
            return map.lastKey() - map.firstKey();
        }
    }


    public int longestSubarray(int[] nums, int limit) {
        MultiSet set = new MultiSet();
        int a = 0, b = 0, ans = 0;
        while (b < nums.length) {
            set.add(nums[b++]);
            while (a < b && set.maxDiff() > limit) {
                set.removeOnce(nums[a++]);
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
