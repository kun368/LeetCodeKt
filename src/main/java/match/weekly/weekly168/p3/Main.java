package match.weekly.weekly168.p3;


import java.util.HashMap;
import java.util.Map;

class Solution {

    private boolean sub(Map<Character, Integer> cnt, char key) {
        Integer v = cnt.get(key);
        if (v == null) {
            return false;
        }
        if (v <= 1) {
            cnt.remove(key);
        } else {
            cnt.put(key, v - 1);
        }
        return true;
    }

    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int ans = 0;
        for (int len = minSize; len <= maxSize; ++len) {
            Map<Character, Integer> lts = new HashMap<>();
            Map<String, Integer> cnt = new HashMap<>();
            for (int i = 0; i < len - 1; ++i) {
                char c = s.charAt(i);
                lts.put(c, lts.getOrDefault(c, 0) + 1);
            }
            for (int i = 0; i + len <= s.length(); ++i) {
                char c = s.charAt(i + len - 1);
                lts.put(c, lts.getOrDefault(c, 0) + 1);
                if (lts.size() <= maxLetters) {
                    String cur = s.substring(i, i + len);
                    cnt.put(cur, cnt.getOrDefault(cur, 0) + 1);
                }
                sub(lts, s.charAt(i));
            }
            System.out.println(cnt);
            for (Integer value : cnt.values()) {
                ans = Math.max(ans, value);
            }
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().maxFreq("aababcaab", 2, 3, 4));
        System.out.println(new Solution().maxFreq("aaaa", 1, 3, 3));
        System.out.println(new Solution().maxFreq("aabcabcab", 2, 2, 3));
        System.out.println(new Solution().maxFreq("abcde", 2, 3, 3));
        System.out.println(new Solution().maxFreq("babcbceccaaacddbdaedbadcddcbdbcbaaddbcabcccbacebda", 1, 1, 1));
    }
}
