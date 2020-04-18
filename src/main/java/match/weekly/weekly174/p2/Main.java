package match.weekly.weekly174.p2;

import utils.java.DebugUtils;

import java.util.*;

class Solution {
    public int minSetSize(int[] arr) {
        int N = arr.length;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i : arr) {
            cnt.put(i, cnt.getOrDefault(i, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> ps = new ArrayList<>(cnt.entrySet());
        ps.sort((o1, o2) -> -Integer.compare(o1.getValue(), o2.getValue()));
        int cur = 0;
        for (int i = 0; i < ps.size(); ++i) {
            cur += ps.get(i).getValue();
            if (cur >= N / 2) {
                return i + 1;
            }
        }
        return N;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().minSetSize(DebugUtils.parseIntArr1("[3,3,3,3,5,5,5,2,2,7]")));
        System.out.println(new Solution().minSetSize(DebugUtils.parseIntArr1("[7,7,7,7,7,7]")));
        System.out.println(new Solution().minSetSize(DebugUtils.parseIntArr1("[1,9]")));
        System.out.println(new Solution().minSetSize(DebugUtils.parseIntArr1("[1000,1000,3,7]")));
        System.out.println(new Solution().minSetSize(DebugUtils.parseIntArr1("[1,2,3,4,5,6,7,8,9,10]")));
    }
}
