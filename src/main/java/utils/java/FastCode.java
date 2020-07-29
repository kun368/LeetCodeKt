package utils.java;

import java.util.TreeMap;

public class FastCode {

    // 10^9 + 7
    public static final long MOD = 1000000007;

    // → ↓ ← ↑
    private static final int[][] dir = {{0, 0}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    // MAX
    private static final int MAX = 0x3f3f3f3f;

    private static class MultiSet {

        public TreeMap<Integer, Integer> map = new TreeMap<>();

        public void add(int x) {
            map.merge(x, 1, Integer::sum);
        }

        public void removeOnce(int x) {
            map.computeIfPresent(x, (key, oldValue) -> {
                int t = oldValue - 1;
                return t <= 0 ? null : t;
            });
        }

        public boolean contains(int x) {
            return map.containsKey(x);
        }
    }
}
