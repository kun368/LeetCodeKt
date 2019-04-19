package cat004.p47.v2;

import java.util.*;

class Solution {

    private List<List<Integer>> ret = new ArrayList<>();
    private boolean[] vis;
    private Deque<Integer> path = new LinkedList<>();

    private void dfs(int[] nums) {
        if (path.size() == nums.length) {
            ret.add(new ArrayList<>(path));
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (vis[i]) {
                continue;
            }
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
            } else {
                continue;
            }
            vis[i] = true;
            path.add(nums[i]);
            dfs(nums);
            path.pollLast();
            vis[i] = false;
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.parallelSort(nums);
        vis = new boolean[nums.length];
        dfs(nums);
        return ret;
    }
}