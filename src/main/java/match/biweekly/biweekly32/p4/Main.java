package match.biweekly.biweekly32.p4;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {

    int[][] psum;

    static class Node implements Comparable<Node> {

        int start, end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int len() {
            return end - start;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(o.len(), this.len());
        }
    }

    private int[] getCnt(int st, int ed) {
        int[] ret = new int[10];
        for (int i = 0; i < ret.length; ++i) {
            ret[i] = psum[ed][i] - psum[st][i];
            ret[i] %= 2;
        }
        return ret;
    }

    public int longestAwesome(String s) {
        psum = new int[s.length() + 1][10];
        for (int i = 0; i < s.length(); ++i) {
            System.arraycopy(psum[i], 0, psum[i + 1], 0, 10);
            int c = s.charAt(i) - '0';
            psum[i + 1][c] += 1;
        }
        PriorityQueue<Node> qu = new PriorityQueue<>();
        qu.add(new Node(0, s.length()));
        while (!qu.isEmpty()) {
            Node top = qu.poll();
            int[] cnt = getCnt(top.start, top.end);
            if (Arrays.stream(cnt).sum() <= 1) {
                return top.len();
            }
            for (int i = top.start; i < top.end; ++i) {
                if (cnt[s.charAt(i) - '0'] == 1) {
                    qu.add(new Node(i + 1, top.end));
                    break;
                }
            }
            for (int i = top.end - 1; i >= top.start; --i) {
                if (cnt[s.charAt(i) - '0'] == 1) {
                    qu.add(new Node(top.start, i));
                    break;
                }
            }
        }
        return 1;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().longestAwesome("3242415"));
        System.out.println(new Solution().longestAwesome("12345678"));
        System.out.println(new Solution().longestAwesome("213123"));
        System.out.println(new Solution().longestAwesome("00"));
        System.out.println(new Solution().longestAwesome("4298407173779060310811573294822"));
    }
}
