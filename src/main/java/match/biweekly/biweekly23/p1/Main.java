package match.biweekly.biweekly23.p1;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

class Solution {
    public int countLargestGroup(int n) {
        Map<Integer, Integer> mp = new TreeMap<>();
        for (int i = 1; i <= n; ++i) {
            String cur = String.valueOf(i);
            int sum = 0;
            for (int j = 0; j < cur.length(); ++j) {
                sum += cur.charAt(j) - '0';
            }
            mp.put(sum, mp.getOrDefault(sum, 0) + 1);
        }
        int t = Collections.max(mp.values());
        return (int) mp.values().stream().filter(it -> it == t).count();
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().countLargestGroup(13));
        System.out.println(new Solution().countLargestGroup(2));
        System.out.println(new Solution().countLargestGroup(15));
        System.out.println(new Solution().countLargestGroup(24));
        System.out.println(new Solution().countLargestGroup(10000));
    }
}
