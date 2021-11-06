package normal.cat1.cat19.cat199.p1994;

class Solution {

    private static final int[] pri = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
    private static final long MOD = 1000000007;

    public int numberOfGoodSubsets(int[] nums) {
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberOfGoodSubsets(new int[]{2, 3, 5}));
        System.out.println(solution.numberOfGoodSubsets(new int[]{1, 2, 3, 4})); // 6
        System.out.println(solution.numberOfGoodSubsets(new int[]{4, 2, 3, 15})); // 5
        System.out.println(solution.numberOfGoodSubsets(new int[]{9, 7, 20, 20, 2})); // 3
        System.out.println(solution.numberOfGoodSubsets(new int[]{18, 28, 2, 17, 29, 30, 15, 9, 12})); // 19
        System.out.println(solution.numberOfGoodSubsets(new int[]{5, 10, 1, 26, 24, 21, 24, 23, 11, 12, 27, 4, 17, 16, 2, 6, 1, 1, 6, 8, 13, 30, 24, 20, 2, 19})); // 5368
    }
}
