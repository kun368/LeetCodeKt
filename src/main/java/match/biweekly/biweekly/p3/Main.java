package match.biweekly.biweekly.p3;


class Solution {

    private boolean eq(int[] a, int[] b) {
        int ca = 0, cb = 0;
        for (int i = 0; i < a.length; ++i) {
            if (a[i] != 0) ca += 1;
            if (b[i] != 0) cb += 1;
        }
        return ca == cb;
    }

    public int numSplits(String s) {
        int[] left = new int[27];
        int[] right = new int[27];
        for (int i = 0; i < s.length(); ++i) {
            right[s.charAt(i) - 'a'] += 1;
        }
        int ans = 0;
        for (int i = 0; i < s.length() - 1; ++i) {
            right[s.charAt(i) - 'a'] -= 1;
            left[s.charAt(i) - 'a'] += 1;
            if (eq(left, right)) {
                ans += 1;
            }
        }
        return ans;
    }
}


public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().numSplits("aacaba"));
        System.out.println(new Solution().numSplits("abcd"));
        System.out.println(new Solution().numSplits("aaaaa"));
        System.out.println(new Solution().numSplits("acbadbaada"));
    }
}
