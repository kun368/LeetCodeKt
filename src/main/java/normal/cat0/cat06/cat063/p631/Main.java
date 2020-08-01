package normal.cat0.cat06.cat063.p631;

import utils.java.DebugUtils;

import java.util.*;

/**
 * 632. 最小区间
 * 滑动窗口 + 计数
 */
class Solution {

    private static class Counter {

        public TreeMap<Integer, Integer> map = new TreeMap<>();

        public void addOnce(int x) {
            map.merge(x, 1, Integer::sum);
        }

        public void removeOnce(int x) {
            map.computeIfPresent(x, (key, oldValue) -> {
                int t = oldValue - 1;
                return t <= 0 ? null : t;
            });
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> searchMap = new TreeMap<>();
        for (int i = 0; i < nums.size(); ++i) {
            for (Integer j : nums.get(i)) {
                searchMap.putIfAbsent(j, new ArrayList<>());
                searchMap.get(j).add(i);
            }
        }
        List<Map.Entry<Integer, List<Integer>>> searchList = new ArrayList<>(searchMap.entrySet());
        int end = 0;
        int[] best = {0, Integer.MAX_VALUE};
        Counter counter = new Counter();
        for (int i = 0; i < searchList.size(); ++i) {
            while (counter.map.size() < nums.size() && end < searchList.size()) {
                searchList.get(end++).getValue().forEach(counter::addOnce);
            }
            if (counter.map.size() < nums.size()) {
                break;
            }
            int L = searchList.get(i).getKey(), R = searchList.get(end - 1).getKey();
            if (R - L < best[1] - best[0]) {
                best[0] = L;
                best[1] = R;
            }
            searchList.get(i).getValue().forEach(counter::removeOnce);
        }
        return best;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().smallestRange(
                DebugUtils.parseIntList2("[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]"))));
    }
}
