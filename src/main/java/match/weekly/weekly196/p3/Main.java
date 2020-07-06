package match.weekly.weekly196.p3;


import utils.java.DebugUtils;

class Solution {
    public int numSubmat(int[][] mat) {
        int N = mat.length, M = mat[0].length, ans = 0;
        int[][] preSum = new int[N][M];
        for (int i = 0; i < N; ++i) {
            int s = 0;
            for (int j = 0; j < M; ++j) {
                preSum[i][j] = (s = mat[i][j] == 0 ? 0 : s + 1);
                int cur = Integer.MAX_VALUE;
                for (int k = i; k >= 0; --k) {
                    ans += (cur = Math.min(cur, preSum[k][j]));
                }
            }
        }
        return ans;
    }
}

/**
 * @author kunwu
 * @date 2020/7/5 10:22 上午
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().numSubmat(DebugUtils.parseIntArr2("[[1,0,1],\n" +
                "            [1,1,0],\n" +
                "            [1,1,0]]")));
        System.out.println(new Solution().numSubmat(DebugUtils.parseIntArr2("[[0,1,1,0],\n" +
                "            [0,1,1,1],\n" +
                "            [1,1,1,0]]")));
        System.out.println(new Solution().numSubmat(DebugUtils.parseIntArr2("[[1,1,1,1,1,1]]")));
        System.out.println(new Solution().numSubmat(DebugUtils.parseIntArr2("[[1,0,1],[0,1,0],[1,0,1]]")));
    }
}
