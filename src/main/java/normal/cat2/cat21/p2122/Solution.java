package normal.cat2.cat21.p2122;

import java.util.Arrays;
import java.util.TreeMap;

class Solution {

    private static class MultiSet extends TreeMap<Integer, Integer> {

        public void addOnce(int x) {
            this.merge(x, 1, Integer::sum);
        }

        public void removeOnce(int x) {
            this.computeIfPresent(x, (key, oldValue) -> {
                int t = oldValue - 1;
                return t <= 0 ? null : t;
            });
        }
    }

    private int[] check(int[] nums, int k) {
        MultiSet set = new MultiSet();
        for (int num : nums) {
            set.addOnce(num);
        }

        int[] ret = new int[nums.length / 2];
        int retSize = 0;
        while (set.size() > 0) {
            int max = set.lastKey();
            int p = max - k - k;
            if (!set.containsKey(p)) {
                return null;
            }
            ret[retSize++] = max - k;
            set.removeOnce(max);
            set.removeOnce(p);
        }
        return ret;
    }

    public int[] recoverArray(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; ++i) {
            int d = nums[i] - nums[0];
            if (d % 2 != 0 || d == 0) continue;
            int[] check = check(nums, d / 2);
            if (check != null) return check;
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().recoverArray(new int[]{2, 10, 6, 4, 8, 12})));
        System.out.println(Arrays.toString(new Solution().recoverArray(new int[]{1, 1, 3, 3})));
        System.out.println(Arrays.toString(new Solution().recoverArray(new int[]{5, 435})));
    }
}
