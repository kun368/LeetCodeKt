package match.biweekly.biweekly19.p1;


class Solution {
    public int numberOfSteps (int num) {
        int ans = 0;
        while (num > 0) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num -= 1;
            }
            ans += 1;
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().numberOfSteps(14));
        System.out.println(new Solution().numberOfSteps(8));
        System.out.println(new Solution().numberOfSteps(123));
    }
}
