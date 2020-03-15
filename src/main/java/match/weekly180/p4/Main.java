package match.weekly180.p4;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {

    public static final int MOD = 1000000007;

    private static class Node {
        long speed, efficiency;
    }

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            Node node = new Node();
            node.speed = speed[i];
            node.efficiency = efficiency[i];
            list.add(node);
        }
        list.sort((o1, o2) -> {
            int t = Long.compare(o2.efficiency, o1.efficiency);
            return t == 0 ? Long.compare(o2.speed, o1.speed) : t;
        });
        PriorityQueue<Long> qu = new PriorityQueue<>();
        long quSum = 0, ans = 0;
        for (Node node : list) {
            qu.add(node.speed);
            quSum += node.speed;
            if (qu.size() > k) {
                quSum -= qu.poll();
            }
            ans = Math.max(ans, quSum * node.efficiency);
        }
        return (int) (ans % MOD);
    }
}


public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().maxPerformance(
                6, new int[]{2, 10, 3, 1, 5, 8}, new int[]{5, 4, 3, 9, 7, 2}, 2
        ));
        System.out.println(new Solution().maxPerformance(
                6, new int[]{2, 10, 3, 1, 5, 8}, new int[]{5, 4, 3, 9, 7, 2}, 3
        ));
        System.out.println(new Solution().maxPerformance(
                6, new int[]{2, 10, 3, 1, 5, 8}, new int[]{5, 4, 3, 9, 7, 2}, 4
        ));
        System.out.println(new Solution().maxPerformance(
                7, new int[]{1, 4, 1, 9, 4, 4, 4}, new int[]{8, 2, 1, 7, 1, 8, 4}, 6
        ));
    }
}
