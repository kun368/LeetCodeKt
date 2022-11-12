package normal.cat2.cat22.p2250.t2;

import utils.java.DebugUtils;

import java.util.*;

class Solution {

    private static int lowerBound(List<Integer> a, int low, int high, int element) {
        while (low < high) {
            int middle = low + (high - low) / 2;
            if (element > a.get(middle)) {
                low = middle + 1;
            } else {
                high = middle;
            }
        }
        return low;
    }

    public int[] countRectangles(int[][] rectangles, int[][] points) {
        Map<Integer, List<Integer>> rh = new HashMap<>();
        for (int[] rectangle : rectangles) {
            rh.putIfAbsent(rectangle[1], new ArrayList<>());
            rh.get(rectangle[1]).add(rectangle[0]);
        }
        for (List<Integer> value : rh.values()) {
            Collections.sort(value);
        }

        int[] ret = new int[points.length];
        for (int i = 0; i < points.length; ++i) {
            int x = points[i][0], y = points[i][1];
            for (Map.Entry<Integer, List<Integer>> entry : rh.entrySet()) {
                if (entry.getKey() < y) continue;
                ret[i] += entry.getValue().size() - lowerBound(entry.getValue(), 0, entry.getValue().size(), x);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().countRectangles(
                DebugUtils.parseIntArr2("[[1,2],[2,3],[2,5]]"),
                DebugUtils.parseIntArr2("[[2,1],[1,4]]"))));
        System.out.println(Arrays.toString(new Solution().countRectangles(
                DebugUtils.parseIntArr2("[[1,1],[2,2],[3,3]]"),
                DebugUtils.parseIntArr2("[[1,3],[1,1]]"))));
    }
}
