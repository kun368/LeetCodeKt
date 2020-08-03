package normal.cat0.cat04.cat047.p475;

import java.util.Arrays;

class Solution {

    private boolean check(int[] houses, int[] heaters, int r) {
        int i = 0;
        for (int j = 0; j < houses.length; ) {
            if (houses[j] < heaters[i] - r) return false;
            if (houses[j] > heaters[i] + r) {
                if (++i >= heaters.length) return false;
                else continue;
            }
            j += 1;
        }
        return true;
    }

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int L = 0, R = 1000000007;
        int ok = R;
        while (L < R) {
            int mid = (L + R) / 2;
            boolean check = check(houses, heaters, mid);
            if (check) {
                ok = mid;
                R = mid;
            } else {
                L = mid + 1;
            }
        }
        return ok;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().findRadius(new int[]{1, 2, 3}, new int[]{2}));
        System.out.println(new Solution().findRadius(new int[]{1, 2, 3, 4}, new int[]{1, 4}));
        System.out.println(new Solution().findRadius(new int[]{1, 5}, new int[]{2}));
        System.out.println(new Solution().findRadius(new int[]{1, 2, 3, 5, 15}, new int[]{2, 30}));
        System.out.println(new Solution().findRadius(new int[]{1, 5}, new int[]{10}));
    }
}
