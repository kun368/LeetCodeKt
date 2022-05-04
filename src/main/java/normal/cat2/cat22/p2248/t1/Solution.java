package normal.cat2.cat22.p2248.t1;

import utils.java.ArrayInputUtils;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

class Solution {

    public static class Counter<K> extends TreeMap<K, Integer> {

        public void addOnce(K x) {
            this.merge(x, 1, Integer::sum);
        }

        public void removeOnce(K x) {
            this.computeIfPresent(x, (key, oldValue) -> {
                int t = oldValue - 1;
                return t <= 0 ? null : t;
            });
        }
    }

    public List<Integer> intersection(int[][] nums) {
        Counter<Integer> counter = new Counter<>();
        for (int[] num : nums) for (int i : num) counter.addOnce(i);
        return counter.entrySet().stream()
                .filter(it -> it.getValue() == nums.length)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(new Solution().intersection(ArrayInputUtils.parseIntArr2("[[3,1,2,4,5],[1,2,3,4],[3,4,5,6]]")));
        System.out.println(new Solution().intersection(ArrayInputUtils.parseIntArr2("[[1,2,3],[4,5,6]]")));
    }
}
