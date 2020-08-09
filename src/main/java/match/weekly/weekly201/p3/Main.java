package match.weekly.weekly201.p3;


import utils.java.DebugUtils;

import java.util.*;

class Solution {

    static class Node {
        int l, r;

        public Node(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }

    public int maxNonOverlapping(int[] nums, int target) {
        int[] psum = new int[nums.length + 1];
        Map<Integer, TreeSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            psum[i + 1] = psum[i] + nums[i];
            if (!map.containsKey(psum[i + 1])) {
                map.put(psum[i + 1], new TreeSet<>());
            }
            map.get(psum[i + 1]).add(i + 1);
        }

        List<Node> list = new ArrayList<>();
        for (int i = 1; i <= nums.length; ++i) {
            int t = psum[i - 1] + target;
            if (!map.containsKey(t)) continue;
            Integer R = map.get(t).ceiling(i);
            if (R == null) continue;
            list.add(new Node(i, R));
        }
        list.sort(Comparator.comparingInt(o -> o.r));
        TreeMap<Integer, Integer> rightMap = new TreeMap<>();
        for (int i = 0; i < list.size(); ++i) {
            rightMap.put(list.get(i).r, i);
        }

        int[] dp = new int[list.size() + 1];
        for (int i = 0; i < list.size(); ++i) {
            dp[i + 1] = 1;
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
            Map.Entry<Integer, Integer> entry = rightMap.lowerEntry(list.get(i).l);
            if (entry != null) {
                dp[i + 1] = Math.max(dp[i + 1], dp[entry.getValue() + 1] + 1);
            }
        }
        return dp[list.size()];
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().maxNonOverlapping(new int[]{1, 1, 1, 1, 1}, 2));
        System.out.println(new Solution().maxNonOverlapping(new int[]{-1, 3, 5, 1, 4, 2, -9}, 6));
        System.out.println(new Solution().maxNonOverlapping(new int[]{-2, 6, 6, 3, 5, 4, 1, 2, 8}, 10));
        System.out.println(new Solution().maxNonOverlapping(new int[]{0, 0, 0}, 0));
    }
}
