package match.biweekly22.p1;

class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int ans = 0;
        for (int i : arr1) {
            boolean exist = false;
            for (int j : arr2) {
                if (Math.abs(i - j) <= d) {
                    exist = true;
                    break;
                }
            }
            if (!exist) {
                ans += 1;
            }
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().findTheDistanceValue(new int[]{4, 5, 8}, new int[]{10, 9, 1, 8}, 2));
        System.out.println(new Solution().findTheDistanceValue(new int[]{1, 4, 2, 3}, new int[]{-4, -3, 6, 10, 20, 30}, 3));
        System.out.println(new Solution().findTheDistanceValue(new int[]{2, 1, 100, 3}, new int[]{-5, -2, 10, -3, 7}, 6));
    }
}
