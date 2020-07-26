package match.weekly.weekly199.p2;

class Solution {
    public int minFlips(String target) {
        int ans = 0;
        boolean state = false;
        for (int i = 0; i < target.length(); ++i) {
            boolean c = target.charAt(i) == '1';
            if (state) c = !c;
            if (c) {
                ans += 1;
                state = !state;
            }
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().minFlips("10111"));
        System.out.println(new Solution().minFlips("101"));
        System.out.println(new Solution().minFlips("00000"));
        System.out.println(new Solution().minFlips("001011101"));
    }
}
