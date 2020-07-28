package normal.cat0.cat00.cat006.p67;

class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int up = 0;
        for (int i = 0; i < Math.max(a.length(), b.length()); ++i) {
            int c1 = i < a.length() ? a.charAt(a.length() - i - 1) - '0' : 0;
            int c2 = i < b.length() ? b.charAt(b.length() - i - 1) - '0' : 0;
            int cur = c1 + c2 + up;
            sb.append(cur % 2);
            up = cur / 2;
        }
        if (up > 0) sb.append(up);
        return sb.reverse().toString();
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().addBinary("11", "1"));
        System.out.println(new Solution().addBinary("1010", "1011"));
    }
}
