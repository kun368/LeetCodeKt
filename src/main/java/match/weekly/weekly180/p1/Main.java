package match.weekly.weekly180.p1;


import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> ret = new ArrayList<>();
        int N = matrix.length, M = matrix[0].length;
        for (int i = 0; i < N; ++i) {
            int minIdx = -1, val = Integer.MAX_VALUE;
            for (int j = 0; j < M; ++j) {
                if (matrix[i][j] < val) {
                    val = matrix[i][j];
                    minIdx = j;
                }
            }
            boolean ok = true;
            for (int j = 0; j < N; ++j) {
                if (matrix[j][minIdx] > val) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                ret.add(val);
            }
        }
        return ret;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("1");
    }
}
