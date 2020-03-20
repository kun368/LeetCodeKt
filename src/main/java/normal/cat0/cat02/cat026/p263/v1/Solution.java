package normal.cat0.cat02.cat026.p263.v1;

/**
 * 丑数
 */
class Solution {
    public boolean isUgly(int num) {
        while (num > 0 && num % 2 == 0) num /= 2;
        while (num > 0 && num % 3 == 0) num /= 3;
        while (num > 0 && num % 5 == 0) num /= 5;
        return num == 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isUgly(6));
        System.out.println(new Solution().isUgly(8));
        System.out.println(new Solution().isUgly(14));
    }
}