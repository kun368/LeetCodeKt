package match.biweekly.biweekly32.p2;

import java.util.*;

class Solution {
    public boolean canConvertString(String s, String t, int k) {
        if (s.length() != t.length()) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); ++i) {
            int a = s.charAt(i) - 'a';
            int b = t.charAt(i) - 'a' + 26;
            int chg = (b - a) % 26;
            if (chg != 0) {
                list.add(chg);
            }
        }
        Map<Integer, Integer> used = new HashMap<>();
        for (Integer i : list) {
            int cur;
            if (!used.containsKey(i)) {
                cur = i;
                used.put(i, 1);
            } else {
                cur = used.get(i) * 26 + i;
                used.put(i, used.get(i) + 1);
            }
            if (cur > k) {
                return false;
            }
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().canConvertString("input", "ouput", 9));
        System.out.println(new Solution().canConvertString("abc", "bcd", 10));
        System.out.println(new Solution().canConvertString("aab", "bbb", 27));
        System.out.println(new Solution().canConvertString("aaa", "bbb", 27));
    }
}
