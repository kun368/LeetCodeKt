package match.weekly.weekly198.p4;

class Solution {

    /**
     * 计算区间的And值，左闭右开
     */
    private int spanAnd(int[][] pcnt, int l, int r) {
        int ans = 0;
        for (int t = 0; t < 32; ++t) {
            if (pcnt[r][t] - pcnt[l][t] == r - l) {
                ans |= (1 << t);
            }
        }
        return ans;
    }

    public int closestToTarget(int[] arr, int target) {
        int N = arr.length;
        int[][] pcnt = new int[N + 1][32];
        for (int i = 0; i < N; ++i) {
            int c = arr[i];
            for (int j = 0; j < 32; ++j) {
                pcnt[i + 1][j] = pcnt[i][j] + ((c & (1 << j)) > 0 ? 1 : 0);
            }
        }
        int ans = Integer.MAX_VALUE / 2;
        for (int i = 0; i < N; ++i) {
            int L = i, R = N;
            while (L < R) {
                int mid = (L + R) / 2;
                int t = spanAnd(pcnt, i, mid + 1);
                ans = Math.min(ans, Math.abs(t - target));
                if (t == target) {
                    break;
                } else if (t < target) {
                    R = mid;
                } else {
                    L = mid + 1;
                }
            }
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().closestToTarget(new int[]{9, 12, 3, 7, 15}, 5));
        System.out.println(new Solution().closestToTarget(new int[]{1000000, 1000000, 1000000}, 1));
        System.out.println(new Solution().closestToTarget(new int[]{1, 2, 4, 8, 16}, 0));
    }
}
