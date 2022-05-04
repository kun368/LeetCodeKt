package normal.cat2.cat22.p2248.t2;

import utils.java.ArrayInputUtils;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<Integer> intersection(int[][] nums) {
        int[] vis = new int[1024];
        for (int[] num : nums) for (int i : num) vis[i] += 1;
        List<Integer> ret = new ArrayList<>();
        for (int i = 1; i < vis.length; ++i) {
            if (vis[i] == nums.length) ret.add(i);
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().intersection(ArrayInputUtils.parseIntArr2("[[3,1,2,4,5],[1,2,3,4],[3,4,5,6]]")));
        System.out.println(new Solution().intersection(ArrayInputUtils.parseIntArr2("[[1,2,3],[4,5,6]]")));
    }
}
