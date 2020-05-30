package match.biweekly.biweekly27.p2;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i + k <= s.length(); ++i) {
            String t = s.substring(i, i + k);
            set.add(Integer.valueOf(t, 2));
        }
        return set.size() == (1 << k);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().hasAllCodes("00110110", 2));
        System.out.println(new Solution().hasAllCodes("00110", 2));
        System.out.println(new Solution().hasAllCodes("00110", 1));
        System.out.println(new Solution().hasAllCodes("0110", 2));
        System.out.println(new Solution().hasAllCodes("0000000001011100", 4));
    }
}
