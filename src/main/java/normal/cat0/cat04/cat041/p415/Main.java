package normal.cat0.cat04.cat041.p415;

class Solution {
    public String addStrings(String num1, String num2) {
        int up = 0;
        int limit = Math.max(num1.length(), num2.length());
        StringBuilder sb = new StringBuilder(limit + 1);
        for (int i = 0; i < limit; ++i) {
            up += i >= num1.length() ? 0 : num1.charAt(num1.length() - i - 1) - '0';
            up += i >= num2.length() ? 0 : num2.charAt(num2.length() - i - 1) - '0';
            sb.append(up % 10);
            up /= 10;
        }
        if (up > 0) sb.append(up);
        return sb.reverse().toString();
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().addStrings("1", "1"));
        System.out.println(new Solution().addStrings("123", "45666"));
        System.out.println(new Solution().addStrings("9999", "12"));
    }
}
