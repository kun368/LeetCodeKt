package match.weekly.weekly200.p3;

import utils.java.DebugUtils;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int minSwaps(int[][] grid) {
        int N = grid.length;
        List<Integer> pos = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            int cnt = 0;
            for (int j = N - 1; j >= 0 && grid[i][j] == 0; --j) {
                cnt += 1;
            }
            pos.add(cnt);
        }
        int ans = 0;
        for (int i = N - 1; i >= 0; --i) {
            int found = -1;
            for (int j = 0; j < pos.size(); ++j) {
                if (pos.get(j) >= i) {
                    found = j;
                    break;
                }
            }
            if (found >= 0) {
                ans += found;
                pos.remove(found);
            } else {
                return -1;
            }
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().minSwaps(DebugUtils.parseIntArr2("[[0,0,1],[1,1,0],[1,0,0]]")));
        System.out.println(new Solution().minSwaps(DebugUtils.parseIntArr2("[[0,1,1,0],[0,1,1,0],[0,1,1,0],[0,1,1,0]]")));
        System.out.println(new Solution().minSwaps(DebugUtils.parseIntArr2("[[1,0,0],[1,1,0],[1,1,1]]")));
    }
}
