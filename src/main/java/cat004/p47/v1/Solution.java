package cat004.p47.v1;

import java.util.*;

class Solution {

    private Set<List<Integer>> ret = new HashSet<>();
    private boolean[] vis;
    private Deque<Integer> path = new LinkedList<>();

    private void dfs(int[] nums, int cnt) {
        if (cnt == nums.length) {
            ret.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (!vis[i]) {
                vis[i] = true;
                path.add(nums[i]);
                dfs(nums, cnt + 1);
                path.pollLast();
                vis[i] = false;
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        vis = new boolean[nums.length];
        dfs(nums, 0);
        return new ArrayList<>(ret);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.permuteUnique(new int[]{1, 1, 2}));
    }
}