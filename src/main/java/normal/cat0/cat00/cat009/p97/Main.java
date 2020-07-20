package normal.cat0.cat00.cat009.p97;

import java.util.HashMap;
import java.util.Map;

class Solution {

    private Map<String, Boolean> cache;
    private String s1, s2, s3;

    private boolean dfs(int idx1, int idx2, int idx3) {
        if (idx1 + idx2 != idx3) {
            return false;
        }
        if (idx3 <= 0) {
            return idx1 <= 0 && idx2 <= 0;
        }
        final String key = idx1 + "#" + idx2 + "#" + idx3;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        boolean result = false;
        if (idx1 > 0 && s1.charAt(idx1 - 1) == s3.charAt(idx3 - 1) && dfs(idx1 - 1, idx2, idx3 - 1)) {
            result = true;
        }
        if (idx2 > 0 && s2.charAt(idx2 - 1) == s3.charAt(idx3 - 1) && dfs(idx1, idx2 - 1, idx3 - 1)) {
            result = true;
        }
        cache.put(key, result);
        return result;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        this.cache = new HashMap<>();
        return dfs(s1.length(), s2.length(), s3.length());
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().isInterleave("a", "a", "aa"));
        System.out.println(new Solution().isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(new Solution().isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }
}
