package normal.cat0.cat02.cat020.p207.v2;


import utils.java.DebugUtils;

import java.util.*;
import java.util.stream.IntStream;

class Solution {

    private List<List<Integer>> G;
    private int[] in;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        G = new ArrayList<>();
        in = new int[numCourses];
        IntStream.range(0, numCourses).forEach(it -> G.add(new ArrayList<>()));
        for (int[] prerequisite : prerequisites) {
            G.get(prerequisite[0]).add(prerequisite[1]);
            in[prerequisite[1]] += 1;
        }
        Queue<Integer> qu = new ArrayDeque<>();
        for (int i = 0; i < in.length; ++i) {
            if (in[i] == 0) qu.add(i);
        }
        int visit = 0;
        while (!qu.isEmpty()) {
            int top = qu.poll();
            visit += 1;
            for (int next : G.get(top)) {
                if (--in[next] == 0) {
                    qu.add(next);
                }
            }
        }
        return visit == numCourses;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().canFinish(2, DebugUtils.parseIntArr2("[[1,0]]")));
        System.out.println(new Solution().canFinish(2, DebugUtils.parseIntArr2("[[1,0],[0,1]]")));
    }
}
