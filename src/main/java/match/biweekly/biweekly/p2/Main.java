package match.biweekly.biweekly.p2;


class Solution {

    public static final long MOD = 1000000007;

    public int numOfSubarrays(int[] arr) {
        int sum = 0, cnt0 = 1, cnt1 = 0;
        long ans = 0;
        for (int i : arr) {
            sum += i;
            if (sum % 2 == 0) {
                ans = (ans + cnt1) % MOD;
                cnt0 += 1;
            } else {
                ans = (ans + cnt0) % MOD;
                cnt1 += 1;
            }
        }
        return (int) ans;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().numOfSubarrays(new int[]{1, 3, 5}));
        System.out.println(new Solution().numOfSubarrays(new int[]{2, 4, 6}));
        System.out.println(new Solution().numOfSubarrays(new int[]{1, 2, 3, 4, 5, 6, 7}));
        System.out.println(new Solution().numOfSubarrays(new int[]{100, 100, 99, 99}));
        System.out.println(new Solution().numOfSubarrays(new int[]{7}));
    }
}
