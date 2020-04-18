package match.weekly.weekly169.p3;

import java.util.Arrays;

class Solution {
    public boolean canReach(int[] arr, int start) {
        int N = arr.length;
        boolean[] vis = new boolean[N];
        dfs(N, arr, vis, start);
        for (int i = 0; i < N; ++i) {
            if (vis[i] && arr[i] == 0) {
                return true;
            }
        }
        return false;
    }

    void dfs(int N, int[] arr, boolean[] vis, int current) {
        vis[current] = true;
        for (int i : Arrays.asList(-1, 1)) {
            int to = current + arr[current] * i;
            if (to >= 0 && to < N && !vis[to]) {
                dfs(N, arr, vis, to);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().canReach(new int[]{
                4, 2, 3, 0, 3, 1, 2
        }, 5));
        System.out.println(new Solution().canReach(new int[]{
                4, 2, 3, 0, 3, 1, 2
        }, 0));
        System.out.println(new Solution().canReach(new int[]{
                3, 0, 2, 1, 2
        }, 2));
    }
}
