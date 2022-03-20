package normal.cat2.cat21.p2187;

class Solution {

    private long test(int[] time, long givenTime) {
        long res = 0;
        for (int j : time) {
            res += givenTime / j;
        }
        return res;
    }

    public long minimumTime(int[] time, int totalTrips) {
        long L = 1, R = (long) (1e14 + 5);
        long ans = R;
        while (L < R) {
            long mid = (L + R) / 2;
            if (test(time, mid) >= totalTrips) {
                ans = Math.min(ans, mid);
                R = mid;
            } else {
                L = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minimumTime(new int[]{1, 2, 3}, 5));
        System.out.println(new Solution().minimumTime(new int[]{2}, 1));
    }
}
