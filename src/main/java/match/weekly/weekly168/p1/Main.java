package match.weekly.weekly168.p1;

class Solution {
    public int findNumbers(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            if (String.valueOf(num).length() % 2 == 0) {
                ans += 1;
            }
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().findNumbers(new int[]{12, 345, 2, 6, 7896}));
        System.out.println(new Solution().findNumbers(new int[]{555, 901, 482, 1771}));
    }
}
