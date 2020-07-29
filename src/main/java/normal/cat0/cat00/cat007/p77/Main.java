package normal.cat0.cat00.cat007.p77;


import java.util.ArrayList;
import java.util.List;

class Solution {

    private List<List<Integer>> retList;

    private void dfs(int n, int k, int curIndex, List<Integer> curList) {
        if (curList.size() == k) {
            retList.add(curList);
            return;
        }
        if (curIndex > n) {
            return;
        }
        dfs(n, k, curIndex + 1, curList);
        List<Integer> next = new ArrayList<>(curList);
        next.add(curIndex);
        dfs(n, k, curIndex + 1, next);
    }

    public List<List<Integer>> combine(int n, int k) {
        this.retList = new ArrayList<>();
        dfs(n, k, 1, new ArrayList<>());
        return retList;
    }
}


public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().combine(4, 2));
        System.out.println(new Solution().combine(4, 3));
        System.out.println(new Solution().combine(1, 1));
    }
}
