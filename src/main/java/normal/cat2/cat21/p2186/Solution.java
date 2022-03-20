package normal.cat2.cat21.p2186;

import java.util.TreeMap;

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

    public int minSteps(String s, String t) {
        Counter<Character> ss = new Counter<>();
        Counter<Character> tt = new Counter<>();
        for (int i = 0; i < s.length(); ++i) {
            ss.addOnce(s.charAt(i));
        }
        for (int i = 0; i < t.length(); ++i) {
            tt.addOnce(t.charAt(i));
        }
        int res = 0;
        for (Character i : ss.keySet()) {
            res += Math.max(0, ss.get(i) - tt.getOrDefault(i, 0));
        }
        for (Character i : tt.keySet()) {
            res += Math.max(0, tt.get(i) - ss.getOrDefault(i, 0));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minSteps("leetcode", "coats"));
        System.out.println(new Solution().minSteps("night", "thing"));
        System.out.println(new Solution().minSteps("cotxazilut", "nahrrmcchxwrieqqdwdpneitkxgnt")); // 27
    }
}
