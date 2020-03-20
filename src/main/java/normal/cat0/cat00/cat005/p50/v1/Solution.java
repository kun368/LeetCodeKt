package normal.cat0.cat00.cat005.p50.v1;

class Solution {
    public double myPow(double x, Integer n) {
        if (n == 0) return 1;
        if (x == 1) return 1;
        long pw = Math.abs(n.longValue());
        double sum = 1;
        double cur = x;
        while (pw > 0) {
            if ((pw & 1) > 0) {
                sum *= cur;
            }
            pw >>= 1;
            cur = cur * cur;
        }
        if (n < 0) sum = 1 / sum;
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myPow(2.0, 10));
        System.out.println(solution.myPow(2.1, 3));
        System.out.println(solution.myPow(2.0, -2));
    }
}