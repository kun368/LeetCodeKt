package match.weekly.weekly166.p3;

class Solution {

    private boolean judge(int[] nums, int t, int threshold) {
        long sum = 0;
        for (int num : nums) {
            if (num % t == 0) {
                sum += num / t;
            } else {
                sum += num / t + 1;
            }
        }
        return sum <= threshold;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int ans = 10000000;
        int L = 1, R = ans;
        while (L < R) {
            int mid = (L + R) / 2;
            if (judge(nums, mid, threshold)) {
                ans = mid;
                R = mid;
            } else {
                L = mid + 1;
            }
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().smallestDivisor(new int[]{1, 2, 5, 9}, 6));
        System.out.println(new Solution().smallestDivisor(new int[]{2, 3, 5, 7, 11}, 11));
        System.out.println(new Solution().smallestDivisor(new int[]{19}, 5));
        System.out.println(new Solution().smallestDivisor(new int[]{46546654}, 80000));
    }
}
