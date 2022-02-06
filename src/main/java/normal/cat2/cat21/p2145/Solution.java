package normal.cat2.cat21.p2145;

class Solution {

    public int numberOfArrays(int[] differences, int lower, int upper) {
        long st = 0;
        long max = 0, min = 0;
        for (int d : differences) {
            st += d;
            max = Math.max(max, st);
            min = Math.min(min, st);
        }
        return (int) Math.max(0, (upper - lower) - (max - min) + 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numberOfArrays(new int[]{1, -3, 4}, 1, 6));
        System.out.println(new Solution().numberOfArrays(new int[]{3, -4, 5, 1, -2}, -4, 5));
        System.out.println(new Solution().numberOfArrays(new int[]{4, -7, 2}, 3, 6));
        System.out.println(new Solution().numberOfArrays(new int[]{-40}, -46, 53));
    }
}
