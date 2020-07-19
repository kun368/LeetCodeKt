package match.weekly.weekly198.p3;

import lombok.ToString;

import java.util.*;

class Solution {

    @ToString
    static class Segment {
        int L, R;
        String s;

        public Segment(int l, int r, String s) {
            L = l;
            R = r;
            this.s = s;
        }

        public int len() {
            return s.length();
        }
    }

    @ToString
    static class DpNode implements Comparable<DpNode> {

        int cnt, totLen, curNode, preNode;

        public DpNode(int cnt, int totLen, int curNode, int preNode) {
            this.cnt = cnt;
            this.totLen = totLen;
            this.curNode = curNode;
            this.preNode = preNode;
        }

        @Override
        public int compareTo(DpNode o2) {
            int t = -Integer.compare(this.cnt, o2.cnt);
            return t != 0 ? t : Integer.compare(this.totLen, o2.totLen);
        }
    }

    public List<String> maxNumOfSubstrings(String s) {
        int[] left = new int[26], right = new int[26];
        for (int i = 0; i < 26; ++i) {
            left[i] = s.indexOf('a' + i);
            right[i] = s.lastIndexOf('a' + i);
        }
        List<Segment> segments = new ArrayList<>();
        for (int i = 0; i < 26; ++i) {
            int st = left[i], ed = right[i];
            if (st < 0) continue;
            boolean ok = true;
            for (int j = st; j < s.length() && j <= ed; ++j) {
                int cleft = left[s.charAt(j) - 'a'];
                if (cleft < 0) continue;
                if (cleft < st) {
                    ok = false;
                    break;
                }
                ed = Math.max(ed, right[s.charAt(j) - 'a']);
            }
            if (ok) {
                segments.add(new Segment(st, ed, s.substring(st, ed + 1)));
            }
        }
        segments.sort(Comparator.comparingInt(o -> o.R));

        int N = segments.size();
        DpNode[] dp = new DpNode[N];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < i; ++j) {
                if (segments.get(j).R >= segments.get(i).L) {
                    continue;
                }
                DpNode newNode = new DpNode(1 + dp[j].cnt, segments.get(i).len() + dp[j].totLen, i, j);
                if (dp[i] == null || newNode.compareTo(dp[i]) < 0) {
                    dp[i] = newNode;
                }
            }
            if (dp[i] == null) {
                dp[i] = new DpNode(1, segments.get(i).len(), i, -1);
            }
        }
        DpNode bestNode = Collections.min(Arrays.asList(dp));
        List<String> retList = new ArrayList<>();
        while (bestNode != null) {
            retList.add(segments.get(bestNode.curNode).s);
            if (bestNode.preNode >= 0) {
                bestNode = dp[bestNode.preNode];
            } else {
                break;
            }
        }
        return retList;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().maxNumOfSubstrings("adefaddaccc"));
        System.out.println(new Solution().maxNumOfSubstrings("abbaccd"));
        System.out.println(new Solution().maxNumOfSubstrings("abab"));
    }
}
