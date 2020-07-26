package match.biweekly.biweekly.p4;

import lombok.ToString;

import java.util.*;

class Solution {

    @ToString
    static class Span {
        int start, end;

        public Span(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int minNumberOperations(int[] target) {
        Map<Integer, TreeSet<Integer>> idxMap = new HashMap<>();
        for (int i = 0; i < target.length; ++i) {
            idxMap.computeIfAbsent(target[i], it -> new TreeSet<>());
            idxMap.get(target[i]).add(i);
        }
        Queue<Span> qu = new ArrayDeque<>();
        qu.add(new Span(0, target.length - 1));


        return 0;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().minNumberOperations(new int[]{1, 2, 3, 2, 1}));
        System.out.println(new Solution().minNumberOperations(new int[]{3, 1, 1, 2}));
        System.out.println(new Solution().minNumberOperations(new int[]{3, 1, 5, 4, 2}));
        System.out.println(new Solution().minNumberOperations(new int[]{1, 1, 1, 1}));
    }
}
