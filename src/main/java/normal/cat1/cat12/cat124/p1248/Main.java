package normal.cat1.cat12.cat124.p1248;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public int numberOfSubarrays(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        int cnt = 0;
        for (int num : nums) {
            if (num % 2 == 1) {
                list.add(cnt);
                cnt = 0;
            } else {
                cnt += 1;
            }
        }
        list.add(cnt);
        System.out.println(list);
        if (list.size() <= k) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i + k < list.size(); ++i) {
            ans += (list.get(i) + 1) * (list.get(i + k) + 1);
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().numberOfSubarrays(new int[]{1, 1, 2, 1, 1}, 1));
        System.out.println(new Solution().numberOfSubarrays(new int[]{1, 1, 2, 1, 1}, 2));
        System.out.println(new Solution().numberOfSubarrays(new int[]{1, 1, 2, 1, 1}, 3));
        System.out.println(new Solution().numberOfSubarrays(new int[]{1, 1, 2, 1, 1}, 4));
        System.out.println(new Solution().numberOfSubarrays(new int[]{1, 1, 2, 1, 1}, 5));
        System.out.println(new Solution().numberOfSubarrays(new int[]{1, 1, 2, 1, 1}, 6));
        System.out.println(new Solution().numberOfSubarrays(new int[]{2, 4, 6}, 1));
        System.out.println(new Solution().numberOfSubarrays(new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2}, 2));
    }
}
