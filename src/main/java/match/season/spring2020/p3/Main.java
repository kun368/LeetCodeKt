package match.season.spring2020.p3;

import utils.java.DebugUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Solution {

    private static final int INF = 0x3f3f3f3f;

    class Node {
        int idx;
        int[] require;
        int[] yesTime = new int[]{INF, INF, INF};

        public int calcTime() {
            int t = Math.max(yesTime[0], Math.max(yesTime[1], yesTime[2]));
            return t == INF ? -1 : t;
        }
    }

    public int[] getTriggerTime(int[][] increase, int[][] requirements) {
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < requirements.length; ++i) {
            Node node = new Node();
            node.idx = i;
            node.require = requirements[i];
            list.add(node);
        }
        for (int i = 0; i < 3; ++i) {
            int finalI = i;
            list.sort(Comparator.comparingInt(o -> o.require[finalI]));
            int curV = 0, pos = 0;
            for (int day = 0; day <= increase.length; ++day) {
                if (day > 0) {
                    curV += increase[day - 1][i];
                }
                while (pos < list.size() && list.get(pos).require[i] <= curV) {
                    list.get(pos).yesTime[i] = day;
                    pos += 1;
                }
            }
        }
        list.sort(Comparator.comparingInt(o -> o.idx));
        int[] ret = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            ret[i] = list.get(i).calcTime();
        }
        return ret;
    }
}


public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().getTriggerTime(
                DebugUtils.parseIntArr2("[[2,8,4],[2,5,0],[10,9,8]]"), DebugUtils.parseIntArr2("[[2,11,3],[15,10,7],[9,17,12],[8,1,14]]"))));
        System.out.println(Arrays.toString(new Solution().getTriggerTime(
                DebugUtils.parseIntArr2("[[0,4,5],[4,8,8],[8,6,1],[10,10,0]]"), DebugUtils.parseIntArr2("[[12,11,16],[20,2,6],[9,2,6],[10,18,3],[8,14,9]]"))));
        System.out.println(Arrays.toString(new Solution().getTriggerTime(
                DebugUtils.parseIntArr2("[[1,1,1]]"), DebugUtils.parseIntArr2("[[0,0,0]]"))));
    }
}
