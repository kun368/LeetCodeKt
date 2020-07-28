package normal.cat0.cat00.cat005.p56.v1;


import utils.java.DebugUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> retList = new ArrayList<>();
        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int[] i : intervals) {
            if (i[0] > right) {
                retList.add(new int[]{left, right});
                left = i[0];
                right = i[1];
            } else {
                right = Math.max(right, i[1]);
            }
        }
        retList.add(new int[]{left, right});
        int[][] retArray = new int[retList.size()][2];
        for (int i = 0; i < retList.size(); ++i) {
            retArray[i] = retList.get(i);
        }
        return retArray;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution().merge(DebugUtils.parseIntArr2("[[1,3],[2,6],[8,10],[15,18]]"))));
        System.out.println(Arrays.deepToString(new Solution().merge(DebugUtils.parseIntArr2("[[1,4],[4,5]]"))));
    }
}
