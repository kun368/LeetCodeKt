package match.weekly173.p1;


class Solution {
    public int removePalindromeSub(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        boolean ok = true;
        for (int i = 0; i < s.length() / 2; ++i) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                ok = false;
                break;
            }
        }
        return ok ? 1 : 2;
    }
}


public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().removePalindromeSub("ababa"));
        System.out.println(new Solution().removePalindromeSub("abb"));
        System.out.println(new Solution().removePalindromeSub("baabb"));
        System.out.println(new Solution().removePalindromeSub(""));
    }
}
