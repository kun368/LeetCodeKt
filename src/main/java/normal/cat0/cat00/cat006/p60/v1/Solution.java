package normal.cat0.cat00.cat006.p60.v1;

import java.util.*;

/**
 * 从头到尾一位一位的定位，确定当前数字是几
 */
class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> set = new ArrayList<>();
        int cnt = 1;
        for (int i = 1; i <= n; ++i) {
            set.add(i);
            cnt *= i;
        }
        StringBuilder ret = new StringBuilder(n);
        while (set.size() > 0) {
            int span = cnt / set.size();
            int idx = (k - 1) / span;
            ret.append(set.get(idx));
            set.remove(idx);
            cnt = span;
            k = k - idx * span;
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getPermutation(3, 3));
        System.out.println(solution.getPermutation(4, 9));
    }
}