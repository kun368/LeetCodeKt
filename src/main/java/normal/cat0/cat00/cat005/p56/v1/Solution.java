package normal.cat0.cat00.cat005.p56.v1;


import utils.java.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ret = new ArrayList<>();
        for (Interval it : intervals) {
            Interval last = ret.isEmpty() ? null : ret.get(ret.size() - 1);
            if (last != null && it.start <= last.end) {
                last.end = it.end;
            } else {
                ret.add(it);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.merge(Arrays.asList(
                new Interval(1, 3),
                new Interval(2, 6),
                new Interval(8, 10),
                new Interval(15, 18)
        )));
        System.out.println(solution.merge(Arrays.asList(
                new Interval(1, 4),
                new Interval(4, 5)
        )));
    }
}