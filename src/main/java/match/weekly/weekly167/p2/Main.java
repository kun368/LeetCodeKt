package match.weekly.weekly167.p2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String x = "123456789";
        Set<Integer> ret = new TreeSet<>();
        for (int i = 0; i < x.length(); ++i) {
            for (int j = i + 1; j <= x.length(); ++j) {
                String cur = x.substring(i, j);
                Long t = Long.valueOf(cur);
                if (t >= low && t <= high) {
                    ret.add(t.intValue());
                }
            }
        }
        return new ArrayList<>(ret);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().sequentialDigits(100, 300));
        System.out.println(new Solution().sequentialDigits(1000, 13000));
        System.out.println(new Solution().sequentialDigits(10, 1000000000));
    }
}
