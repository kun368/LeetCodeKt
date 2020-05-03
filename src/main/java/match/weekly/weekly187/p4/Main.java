package match.weekly.weekly187.p4;

import utils.java.DebugUtils;

import java.util.*;

class Solution {

    private static class Node implements Comparable<Node> {

        int value;
        int[] select;

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.value, o.value);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            Node node = (Node) o;
            return value == node.value && Arrays.equals(select, node.select);
        }

        @Override
        public int hashCode() {
            int result = Objects.hash(value);
            result = 31 * result + Arrays.hashCode(select);
            return result;
        }
    }

    public int kthSmallest(int[][] mat, int k) {
        int N = mat.length, M = mat[0].length;
        PriorityQueue<Node> qu = new PriorityQueue<>();
        HashSet<Node> vis = new HashSet<>();
        Node root = new Node();
        root.select = new int[N];
        for (int[] ints : mat) {
            root.value += ints[0];
        }
        qu.add(root);
        vis.add(root);

        int rnk = 0;
        while (!qu.isEmpty()) {
            Node top = qu.poll();
            if (++rnk == k) {
                return top.value;
            }
            for (int i = 0; i < N; ++i) {
                int nextSelect = top.select[i] + 1;
                if (nextSelect >= M) {
                    continue;
                }
                Node cur = new Node();
                cur.value = top.value + mat[i][nextSelect] - mat[i][nextSelect - 1];
                cur.select = Arrays.copyOf(top.select, N);
                cur.select[i] = nextSelect;
                if (!vis.contains(cur)) {
                    qu.add(cur);
                    vis.add(cur);
                }
            }
        }
        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().kthSmallest(DebugUtils.parseIntArr2("[[1,3,11],[2,4,6]]"), 5));
        System.out.println(new Solution().kthSmallest(DebugUtils.parseIntArr2("[[1,3,11],[2,4,6]]"), 9));
        System.out.println(new Solution().kthSmallest(DebugUtils.parseIntArr2("[[1,10,10],[1,4,5],[2,3,6]]"), 7));
        System.out.println(new Solution().kthSmallest(DebugUtils.parseIntArr2("[[1,1,10],[2,2,9]]"), 7));
    }
}
