package match.weekly.weekly170.p2;

import utils.java.ArrayInputUtils;

import java.util.Arrays;

class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] pre = new int[arr.length + 1];
        for (int i = 0; i < arr.length; ++i) {
            pre[i + 1] = pre[i] ^ arr[i];
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            int L = queries[i][0] + 1;
            int R = queries[i][1] + 1;
            ans[i] = pre[R] ^ pre[L - 1];
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().xorQueries(ArrayInputUtils.parseIntArr1("[1,3,4,8]"), ArrayInputUtils.parseIntArr2("[[0,1],[1,2],[0,3],[3,3]]"))));
        System.out.println(Arrays.toString(new Solution().xorQueries(ArrayInputUtils.parseIntArr1("[4,8,2,10]"), ArrayInputUtils.parseIntArr2("[[2,3],[1,3],[0,0],[0,3]]"))));
    }
}
