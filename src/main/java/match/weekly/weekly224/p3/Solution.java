package match.weekly.weekly224.p3;

import utils.java.DebugUtils;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int N = matrix.length, M = matrix[0].length;
        for (int i = 0; i < M; ++i) {
            int pre = 0;
            for (int j = 0; j < N; ++j) {
                int bak = matrix[j][i];
                if (bak == 0) {
                    matrix[j][i] = 0;
                    pre = 0;
                } else {
                    matrix[j][i] += pre;
                    pre += 1;
                }
            }
        }
        int[][] tab = new int[M][N];
        for (int i = 0; i < M; ++i) {
            for (int j = 0; j < N; ++j) {
                tab[i][j] = matrix[j][i];
            }
        }
        int best = 0;
        for (int i = 0; i < N; ++i) {
            int finalI = i;
            Arrays.sort(tab, Comparator.comparingInt(a -> -a[finalI]));
            for (int j = 0; j < M; ++j) {
                best = Math.max(best, tab[j][i] * (j + 1));
            }
        }
        return best;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().largestSubmatrix(DebugUtils.parseIntArr2("[[0,0,1],[1,1,1],[1,0,1]]")));
        System.out.println(new Solution().largestSubmatrix(DebugUtils.parseIntArr2("[[1,0,1,0,1]]")));
        System.out.println(new Solution().largestSubmatrix(DebugUtils.parseIntArr2("[[1,1,0],[1,0,1]]")));
        System.out.println(new Solution().largestSubmatrix(DebugUtils.parseIntArr2("[[0,0],[0,0]]")));
    }
}