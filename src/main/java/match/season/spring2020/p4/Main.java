package match.season.spring2020.p4;


import java.util.LinkedList;
import java.util.Queue;

class Solution {

    class Node {
        int idx, cnt;

        public Node(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }
    }

    public int minJump(int[] jump) {
        int N = jump.length;
        Queue<Node> qu = new LinkedList<>();
        boolean[] vis = new boolean[N];
        qu.add(new Node(0, 0));
        vis[0] = true;
        int added = 0;
        while (!qu.isEmpty()) {
            Node top = qu.poll();
            int to = top.idx + jump[top.idx];
            if (to >= N) {
                return top.cnt + 1;
            }
            if (!vis[to]) {
                qu.add(new Node(to, top.cnt + 1));
                vis[to] = true;
            }
            for (; added < top.idx; ++added) {
                if (vis[added]) continue;
                qu.add(new Node(added, top.cnt + 1));
                vis[added] = true;
            }
        }
        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().minJump(new int[]{2, 5, 1, 1, 1, 1}));
    }
}
