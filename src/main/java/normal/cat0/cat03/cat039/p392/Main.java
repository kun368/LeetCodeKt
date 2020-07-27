package normal.cat0.cat03.cat039.p392;

class Solution {
    public boolean isSubsequence(String s, String t) {
        int pos = -1;
        for (int i = 0; i < s.length(); ++i) {
            pos = t.indexOf(s.charAt(i), pos + 1);
            if (pos < 0) return false;
        }
        return true;
    }
}


public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().isSubsequence("abc", "ahbgdc"));
        System.out.println(new Solution().isSubsequence("axc", "ahbgdc"));
    }
}
