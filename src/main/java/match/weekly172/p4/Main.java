package match.weekly172.p4;

import utils.java.DebugUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {

    static class Node {

        public int start, end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int minTaps(int n, int[] ranges) {
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < ranges.length; ++i) {
            list.add(new Node(i - ranges[i], i + ranges[i]));
        }
        list.sort(Comparator.comparingInt(o -> o.start));
        int ans = 0, pos = 0, i = 0;
        while (i < list.size() && pos < n) {
            int next = pos;
            while (i < list.size() && list.get(i).start <= pos) {
                next = Math.max(next, list.get(i++).end);
            }
            if (next == pos) {
                return -1;
            }
            ans += 1;
            pos = next;
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().minTaps(5, DebugUtils.parseIntArr1("[3,4,1,1,0,0]")));
        System.out.println(new Solution().minTaps(3, DebugUtils.parseIntArr1("[0,0,0,0]")));
        System.out.println(new Solution().minTaps(7, DebugUtils.parseIntArr1("[1,2,1,0,2,1,0,1]")));
        System.out.println(new Solution().minTaps(8, DebugUtils.parseIntArr1("[4,0,0,0,0,0,0,0,4]")));
        System.out.println(new Solution().minTaps(8, DebugUtils.parseIntArr1("[4,0,0,0,4,0,0,0,4]")));
    }
}
