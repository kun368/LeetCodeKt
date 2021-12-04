package normal.cat2.cat20.cat209.p2092;

import java.util.*;

class UnionSet {

    private final Map<Integer, Integer> par = new HashMap<>(1);

    void add(int x) {
        par.putIfAbsent(x, x);
    }

    int find(int n) {
        if (par.get(n) == n) return n;
        int t = find(par.get(n));
        par.put(n, t);
        return t;
    }

    void merge(int x, int y) {
        par.put(find(x), find(y));
    }

    void sets(Map<Integer, List<Integer>> ret) {
        ret.clear();
        for (Integer i : new ArrayList<>(par.keySet())) {
            ret.putIfAbsent(find(i), new ArrayList<>());
            ret.get(find(i)).add(i);
        }
    }
}

public class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Map<Integer, UnionSet> timeMap = new TreeMap<>();
        for (int[] meeting : meetings) {
            int time = meeting[2];
            timeMap.putIfAbsent(time, new UnionSet());
            UnionSet cur = timeMap.get(time);
            cur.add(meeting[0]);
            cur.add(meeting[1]);
            cur.merge(meeting[0], meeting[1]);
        }

        Map<Integer, List<Integer>> curSets = new HashMap<>();
        Set<Integer> know = new HashSet<>();
        know.add(0);
        know.add(firstPerson);
        for (UnionSet unionSet : timeMap.values()) {
            unionSet.sets(curSets);
            for (List<Integer> i : curSets.values()) {
                boolean ok = false;
                for (Integer j : i) {
                    if (know.contains(j)) {
                        ok = true;
                        break;
                    }
                }
                if (ok) know.addAll(i);
            }
        }
        return new ArrayList<>(know);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findAllPeople(6, new int[][]{{1, 2, 5}, {2, 3, 8}, {1, 5, 10}}, 1));
        System.out.println(new Solution().findAllPeople(4, new int[][]{{3, 1, 3}, {1, 2, 2}, {0, 3, 3}}, 3));
        System.out.println(new Solution().findAllPeople(5, new int[][]{{3, 4, 2}, {1, 2, 1}, {2, 3, 1}}, 1));
        System.out.println(new Solution().findAllPeople(6, new int[][]{{0, 2, 1}, {1, 3, 1}, {4, 5, 1}}, 1));
    }
}
