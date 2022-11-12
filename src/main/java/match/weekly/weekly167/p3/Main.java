package match.weekly.weekly167.p3;

import utils.java.DebugUtils;

class Solution {

    boolean check(int N, int M, int[][] sum, int len, int threshold) {
        for (int pos = 0; pos + len <= M; ++pos) {
            int cur = 0;
            for (int i = 0; i < len; ++i) {
                cur += sum[i][pos + len] - sum[i][pos];
            }
            if (cur <= threshold) {
                return true;
            }

            for (int i = len; i < N; ++i) {
                cur += sum[i][pos + len] - sum[i][pos];
                cur -= sum[i - len][pos + len] - sum[i - len][pos];
                if (cur <= threshold) {
                    return true;
                }
            }
        }
        return false;
    }

    public int maxSideLength(int[][] mat, int threshold) {
        int N = mat.length, M = mat[0].length;
        int[][] sum = new int[N + 5][M + 5];
        for (int i = 0; i < N; ++i) {
            sum[i][0] = 0;
            for (int j = 0; j < M; ++j) {
                sum[i][j + 1] = sum[i][j] + mat[i][j];
            }
        }
        int ok = 0, L = 1, R = Math.min(N, M) + 1;
        while (L < R) {
            int mid = (L + R) / 2;
            if (check(N, M, sum, mid, threshold)) {
                ok = mid;
                L = mid + 1;
            } else {
                R = mid;
            }
        }
        return ok;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().maxSideLength(DebugUtils.parseIntArr2("[[1,1,3,2,4,3,2],[1,1,3,2,4,3,2],[1,1,3,2,4,3,2]]"), 4));
        System.out.println(new Solution().maxSideLength(DebugUtils.parseIntArr2("[[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2]]"), 1));
        System.out.println(new Solution().maxSideLength(DebugUtils.parseIntArr2("[[1,1,1,1],[1,0,0,0],[1,0,0,0],[1,0,0,0]]"), 6));
        System.out.println(new Solution().maxSideLength(DebugUtils.parseIntArr2("[[18,70],[61,1],[25,85],[14,40],[11,96],[97,96],[63,45]]"), 40184));
    }
}
