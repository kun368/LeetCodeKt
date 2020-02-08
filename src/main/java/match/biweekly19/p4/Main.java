package match.biweekly19.p4;

import utils.java.DebugUtils;

import java.util.*;

class Solution {

    static class Node {
        int idx, cnt;

        public Node(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }
    }

    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> mp = new HashMap<>();
        for (int i = 0; i < arr.length; ++i) {
            if (!mp.containsKey(arr[i])) {
                mp.put(arr[i], new ArrayList<>());
            }
            mp.get(arr[i]).add(i);
        }

        Queue<Node> qu = new ArrayDeque<>();
        Set<Integer> vis = new HashSet<>();
        qu.add(new Node(0, 0));
        vis.add(0);
        while (!qu.isEmpty()) {
            Node top = qu.poll();
            if (top.idx == arr.length - 1) {
                return top.cnt;
            }
            List<Integer> has = mp.put(arr[top.idx], new ArrayList<>());
            has.add(top.idx - 1);
            has.add(top.idx + 1);
            for (Integer next : has) {
                if (next < 0 || next >= arr.length || vis.contains(next)) {
                    continue;
                }
                qu.add(new Node(next, top.cnt + 1));
                vis.add(next);
            }
        }
        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().minJumps(DebugUtils.parseIntArr1("[100,-23,-23,404,100,23,23,23,3,404]")));
        System.out.println(new Solution().minJumps(DebugUtils.parseIntArr1("[7]")));
        System.out.println(new Solution().minJumps(DebugUtils.parseIntArr1("[7,6,9,6,9,6,9,7]")));
        System.out.println(new Solution().minJumps(DebugUtils.parseIntArr1("[6,1,9]")));
        System.out.println(new Solution().minJumps(DebugUtils.parseIntArr1("[11,22,7,7,7,7,7,7,7,22,13]")));
    }
}
