package match.weekly.weekly202.p4;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {

    private static class Node implements Comparable<Node> {

        int cur;
        int dis;

        public Node(int cur, int dis) {
            this.cur = cur;
            this.dis = dis;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.dis, o.dis);
        }
    }

    private boolean check(int n, int max) {
        PriorityQueue<Node> qu = new PriorityQueue<>();
        Map<Integer, Integer> best = new HashMap<>();
        qu.add(new Node(n, 0));
        best.put(n, 0);
        while (!qu.isEmpty()) {
            Node top = qu.poll();
            if (top.cur == 0) {
                return true;
            }
            if (best.get(top.cur) < top.dis) {
                continue;
            }
            if (top.dis >= max) {
                continue;
            }
            if (top.cur % 3 == 0) {
                if (best.getOrDefault(top.cur / 3, Integer.MAX_VALUE) > top.dis + 1) {
                    qu.add(new Node(top.cur / 3, top.dis + 1));
                    best.put(top.cur / 3, top.dis + 1);
                }
            }
            if (top.cur % 2 == 0) {
                if (best.getOrDefault(top.cur / 2, Integer.MAX_VALUE) > top.dis + 1) {
                    qu.add(new Node(top.cur / 2, top.dis + 1));
                    best.put(top.cur / 2, top.dis + 1);
                }
            }
            if (best.getOrDefault(top.cur - 1, Integer.MAX_VALUE) > top.dis + 1) {
                qu.add(new Node(top.cur - 1, top.dis + 1));
                best.put(top.cur - 1, top.dis + 1);
            }
        }
        return false;
    }

    public int minDays(int n) {
        int L = 1, R = 100, ok = R;
        while (L < R) {
            int mid = (L + R) / 2;
            boolean check = check(n, mid);
            if (check) {
                ok = mid;
                R = mid;
            } else {
                L = mid + 1;
            }
        }
        return ok;
    }
}

public class Main {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; ++i) {
            System.out.println("i = " + i + ", ans = " + new Solution().minDays(i));
        }
        System.out.println(new Solution().minDays(820592));
        for (int i = 1; i <= 100; ++i) {
            int cur = 2 * 1000000007 - i;
            System.out.println("i = " + cur + ", ans = " + new Solution().minDays(cur));
        }
    }
}
