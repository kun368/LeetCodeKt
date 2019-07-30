package cat0.cat01.cat016.p162.v1;

/**
 * 162. Ñ°ÕÒ·åÖµ
 */
class Solution {

    private int comp(int[] nums, int x, int y) {
        Long vx = x >= 0 && x < nums.length ? nums[x] : Long.MIN_VALUE;
        Long vy = y >= 0 && y < nums.length ? nums[y] : Long.MIN_VALUE;
        return vx.compareTo(vy);
    }

    public int findPeakElement(int[] nums) {
        int L = 0, R = nums.length;
        while (L < R) {
            int mid = (L + R) / 2;
            int lcomp = comp(nums, mid, mid - 1);
            int rcomp = comp(nums, mid, mid + 1);
            if (lcomp > 0 && rcomp > 0) {
                return mid;
            }
            if (lcomp < 0) {
                R = mid;
            } else {
                L = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findPeakElement(new int[]{1, 2, 3, 1}));
        System.out.println(solution.findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));
    }
}