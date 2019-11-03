package match.weekly161.p4;

class Solution {

    int gcd(int a, int b) {
        return b > 0 ? gcd(b, a % b) : a;
    }

    public boolean isGoodArray(int[] nums) {
        int g = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            g = gcd(g, nums[i]);
        }
        return g == 1;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().isGoodArray(new int[]{12, 5, 7, 23}));
        System.out.println(new Solution().isGoodArray(new int[]{29, 6, 10}));
        System.out.println(new Solution().isGoodArray(new int[]{3, 6}));
        System.out.println(new Solution().isGoodArray(new int[]{3, 3, 3, 3, 3, 3, 3}));
        System.out.println(new Solution().isGoodArray(new int[]{6, 8, 10}));
        System.out.println(new Solution().isGoodArray(new int[]{18, 18, 18, 15, 54, 45, 45, 45}));
    }
}
