package match.biweekly.biweekly23.p2;

class Solution {
    public boolean canConstruct(String s, int k) {
        if (k > s.length()) {
            return false;
        }
        int[] cnt = new int[27];
        for (int i = 0; i < s.length(); ++i) {
            cnt[s.charAt(i) - 'a'] += 1;
        }
        int scnt = 0;
        for (int value : cnt) {
            if (value % 2 == 1) {
                scnt += 1;
            }
        }
        return k >= scnt;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().canConstruct("annabelle", 2));
        System.out.println(new Solution().canConstruct("leetcode", 3));
        System.out.println(new Solution().canConstruct("true", 4));
        System.out.println(new Solution().canConstruct("yzyzyzyzyzyzyzy", 2));
        System.out.println(new Solution().canConstruct("cr", 7));
        System.out.println(new Solution().canConstruct("messi", 3)); // true
    }
}
