package match.biweekly21.p2;

import java.util.Arrays;

class Solution {
    public int findTheLongestSubstring(String s) {
        int[] arr = new int[66];
        Arrays.fill(arr, -1);
        arr[0] = 0;
        int h = 0, ans = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == 'a') h ^= (1);
            else if (c == 'e') h ^= (1 << 1);
            else if (c == 'i') h ^= (1 << 2);
            else if (c == 'o') h ^= (1 << 3);
            else if (c == 'u') h ^= (1 << 4);
            if (arr[h] >= 0) ans = Math.max(ans, i + 1 - arr[h]);
            else arr[h] = i + 1;
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().findTheLongestSubstring("eleetminicoworoep"));
        System.out.println(new Solution().findTheLongestSubstring("leetcodeisgreat"));
        System.out.println(new Solution().findTheLongestSubstring("bcbcbc"));
    }
}
