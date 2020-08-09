package match.weekly.weekly201.p2;

class Solution {
    public char findKthBit(int n, int k) {
        StringBuilder sb = new StringBuilder("0");
        for (int i = 2; i <= n; ++i) {
            String t = sb.toString();
            sb.append("1");
            for (int j = t.length() - 1; j >= 0; --j) {
                if (t.charAt(j) == '0') sb.append("1");
                else sb.append("0");
            }
        }
        return sb.toString().charAt(k - 1);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().findKthBit(3, 1));
        System.out.println(new Solution().findKthBit(4, 11));
        System.out.println(new Solution().findKthBit(1, 1));
        System.out.println(new Solution().findKthBit(2, 3));
        System.out.println(new Solution().findKthBit(20, 20));
    }
}
