package match.weekly168.p2;

import java.util.TreeMap;

class Solution {

    private boolean sub(TreeMap<Integer, Integer> cnt, int key) {
        Integer v = cnt.get(key);
        if (v == null) {
            return false;
        }
        if (v <= 1) {
            cnt.remove(key);
        } else {
            cnt.put(key, v - 1);
        }
        return true;
    }

    public boolean isPossibleDivide(int[] nums, int k) {
        TreeMap<Integer, Integer> cnt = new TreeMap<>();
        for (int i : nums) {
            cnt.put(i, cnt.getOrDefault(i, 0) + 1);
        }
        while (!cnt.isEmpty()) {
            Integer top = cnt.firstKey();
            for (int i = 0; i < k; ++i) {
                if (!sub(cnt, top + i)) {
                    return false;
                }
            }
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().isPossibleDivide(new int[]{1, 2, 3, 3, 4, 4, 5, 6}, 4));
        System.out.println(new Solution().isPossibleDivide(new int[]{3, 2, 1, 2, 3, 4, 3, 4, 5, 9, 10, 11}, 3));
        System.out.println(new Solution().isPossibleDivide(new int[]{3, 3, 2, 2, 1, 1}, 3));
        System.out.println(new Solution().isPossibleDivide(new int[]{1, 2, 3, 4}, 3));
    }
}
