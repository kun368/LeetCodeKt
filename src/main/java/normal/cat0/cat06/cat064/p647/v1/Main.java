package normal.cat0.cat06.cat064.p647.v1;

/**
 * 647. 回文子串
 */
class Solution {
    public int countSubstrings(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); ++i) {
            cnt += 1;
            int j = 1;
            while (i - j >= 0 && i + j < s.length() && s.charAt(i - j) == s.charAt(i + j)) {
                j += 1;
                cnt += 1;
            }
            j = 1;
            while (i - j >= 0 && i + j - 1 < s.length() && s.charAt(i - j) == s.charAt(i + j - 1)) {
                j += 1;
                cnt += 1;
            }
        }
        return cnt;
    }
}


public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().countSubstrings(""));
        System.out.println(new Solution().countSubstrings("a"));
        System.out.println(new Solution().countSubstrings("abc"));
        System.out.println(new Solution().countSubstrings("aaa"));
    }
}