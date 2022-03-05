package normal.cat2.cat21.p2167;

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

    public int minimumTime(String s) {
        Counter<Integer> counter = new Counter<>();
        counter.addOnce(s.length());
        int right = 0;
        for (int i = s.length() - 1; i >= 0; --i) {
            if (s.charAt(i) == '1') right += 2;
            counter.addOnce(i + right);
        }
        int result = counter.firstKey();

        right = 0;
        for (int i = s.length() - 1; i >= 0; --i) {
            counter.removeOnce(i + 1 + right);
            if (s.charAt(i) == '1') right += 2;
            result = Math.min(result, counter.firstKey() - right + (s.length() - i));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minimumTime("1100101"));
        System.out.println(new Solution().minimumTime("0010"));
    }
}
