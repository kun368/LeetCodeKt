package normal.cat0.cat00.cat008.p84.v1;


import java.util.*;

/**
 * 考虑高度为1的可行解，再考虑高度为2、3、4的
 * 维护一个有序Set保存比当前高度低的所有index，然后对于从低到高的每一个柱子，查找出两侧最近的比自身低的柱子位置
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
        TreeSet<Integer> has = new TreeSet<>(Arrays.asList(-1, heights.length));
        TreeMap<Integer, List<Integer>> vMap = new TreeMap<>();
        for (int i = 0; i < heights.length; ++i) {
            int c = heights[i];
            if (!vMap.containsKey(c)) vMap.put(c, new ArrayList<>());
            vMap.get(c).add(i);
        }
        int ans = 0;
        for (Map.Entry<Integer, List<Integer>> entry : vMap.entrySet()) {
            Integer height = entry.getKey();
            for (Integer idx : entry.getValue()) {
                ans = Math.max(ans, (has.higher(idx) - has.lower(idx) - 1) * height);
            }
            has.addAll(entry.getValue());
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }
}
