package normal.cat2.cat22.p2250.t1;

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
        TreeMap<Integer, List<Integer>> ph = new TreeMap<>();
        for (int i = 0; i < points.length; ++i) {
            ph.putIfAbsent(points[i][1], new ArrayList<>());
            ph.get(points[i][1]).add(i);
        }

        int[] ret = new int[points.length];
        for (Integer h : ph.keySet()) {
            List<Integer> rs = new ArrayList<>();
            for (int[] rectangle : rectangles) {
                if (rectangle[1] >= h) rs.add(rectangle[0]);
            }
            Collections.sort(rs);

            for (Integer id : ph.get(h)) {
                int x = points[id][0];
                ret[id] = rs.size() - lowerBound(rs, 0, rs.size(), x);
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
