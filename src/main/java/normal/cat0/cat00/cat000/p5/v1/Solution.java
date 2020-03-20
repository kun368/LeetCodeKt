package normal.cat0.cat00.cat000.p5.v1;

class Solution {
    public String longestPalindrome(String s) {
        StringBuilder str = new StringBuilder("#");
        for (int i = 0; i < s.length(); ++i) {
            str.append(s.charAt(i)).append('#');
        }
        s = str.toString();

        String ret = "";
        for (int i = 0; i < s.length(); ++i) {
            int j = 0;
            for (; i - j >= 0 && i + j < s.length(); ++j) {
                if (s.charAt(i - j) != s.charAt(i + j))
                    break;
            }
            String cur = s.substring(i - j + 1, i + j).replace("#", "");
            if (cur.length() > ret.length()) {
                ret = cur;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("babad"));
        System.out.println(new Solution().longestPalindrome("cbbd"));
    }
}