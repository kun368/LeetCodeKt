package normal.cat0.cat00.cat006.p69;

class Solution {
    public int mySqrt(int x) {
        if (x <= 1) return x;
        int L = 1, R = x, ok = 1;
        while (L < R) {
            int mid = (L + R) / 2;
            if (mid * mid <= x) {
                ok = mid;
                L = mid + 1;
            } else {
                R = mid;
            }
        }
        return ok;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().mySqrt(2));
        System.out.println(new Solution().mySqrt(4));
        System.out.println(new Solution().mySqrt(8));
    }
}
