package match.biweekly.biweekly.p4;

class Solution {
    public int minNumberOperations(int[] target) {
        int ans = 0, pre = 0;
        for (int i : target) {
            if (i > pre) {
                ans += i - pre;
            }
            pre = i;
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().minNumberOperations(new int[]{1, 2, 3, 2, 1}));
        System.out.println(new Solution().minNumberOperations(new int[]{3, 1, 1, 2}));
        System.out.println(new Solution().minNumberOperations(new int[]{3, 1, 5, 4, 2}));
        System.out.println(new Solution().minNumberOperations(new int[]{1, 1, 1, 1}));
    }
}
