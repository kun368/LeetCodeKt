package normal.cat0.cat00.cat006.p65.v1;

import java.math.BigDecimal;

class Solution {
    public boolean isNumber(String s) {
        try {
            new BigDecimal(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

public class Main {

    private static void check(String str, boolean ans) {
        if (new Solution().isNumber(str) != ans) {
            System.out.println("Error, str = " + str + ", ans = " + ans);
        }
    }

    public static void main(String[] args) {
        check("0", true);
        check(" 0.1 ", true);
        check("abc", false);
        check("1 a", false);
        check("2e10", true);
        check(" -90e3 ", true);
        check(" 1e", false);
        check("e3", false);
        check(" 6e-1", true);
        check(" 99e2.5 ", false);
        check("53.5e93", true);
        check(" --6 ", false);
        check("-+3", false);
        check("95a54e53", false);
        check("44e016912630333", true);
        check("959440.94f", false);
        check("46.e3", true);
        check("+.8", true);
        check(" -.", false);
        check(".e1", false);
        check(".e1", false);

    }
}
