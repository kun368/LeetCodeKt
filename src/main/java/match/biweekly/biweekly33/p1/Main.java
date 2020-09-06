package match.biweekly.biweekly33.p1;

class Solution {
    public String thousandSeparator(int n) {
        String t = String.valueOf(n);
        StringBuilder sb = new StringBuilder();
        for (int i = t.length() - 1; i >= 0; --i) {
            sb.append(t.charAt(i));
            if ((t.length() - i) % 3 == 0 && i != 0) {
                sb.append(".");
            }
        }
        return sb.reverse().toString();
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().thousandSeparator(987));
        System.out.println(new Solution().thousandSeparator(1234));
        System.out.println(new Solution().thousandSeparator(123456789));
        System.out.println(new Solution().thousandSeparator(0));
    }
}
