package match.lcp.lcp13;


import java.util.Arrays;

class Solution {

    private int calcDay(int[] time, int dayMax) {
        int cnt = 0;
        int curSum = 0, curMax = 0;
        for (int t : time) {
            int newSum = curSum + t;
            int newMax = Math.max(curMax, t);
            if (newSum - newMax > dayMax) {
                curSum = t;
                curMax = t;
                cnt += 1;
            } else {
                curSum = newSum;
                curMax = newMax;
            }
        }
        if (curSum > 0) {
            cnt += 1;
        }
        return cnt;
    }

    public int minTime(int[] time, int m) {
        int L = 0;
        int R = Arrays.stream(time).sum() + 1;
        int ok = R - 1;
        while (L < R) {
            int mid = (L + R) / 2;
            int needDay = calcDay(time, mid);
            if (needDay <= m) {
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
        System.out.println(new Solution().minTime(new int[]{1, 2, 3, 3}, 2));
        System.out.println(new Solution().minTime(new int[]{999, 999, 999}, 4));
    }
}
