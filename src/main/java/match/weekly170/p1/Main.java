package match.weekly170.p1;

class Solution {
    public String freqAlphabets(String s) {
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            char c1 = s.charAt(i);
            char c2 = i + 1 < s.length() ? s.charAt(i + 1) : '?';
            char c3 = i + 2 < s.length() ? s.charAt(i + 2) : '?';
            if (c3 == '#') {
                int t = (c1 - '0') * 10 + (c2 - '0') - 10;
                ret.append((char) ('j' + t));
                i += 2;
            } else {
                int t = c1 - '1';
                ret.append((char) ('a' + t));
            }
        }
        return ret.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().freqAlphabets("10#11#12"));
        System.out.println(new Solution().freqAlphabets("1326#"));
        System.out.println(new Solution().freqAlphabets("25#"));
        System.out.println(new Solution().freqAlphabets("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"));
    }
}
