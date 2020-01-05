package match.weekly170.p3;

import utils.java.ArrayInputUtils;

import java.util.*;

class Solution {

    static class Node {

        int idx, level;

        public Node(int idx, int level) {
            this.idx = idx;
            this.level = level;
        }
    }

    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos,
                                               int[][] friends, int id, int level) {
        int N = watchedVideos.size();
        boolean[] vis = new boolean[N];
        Queue<Node> qu = new LinkedList<>();
        Map<String, Integer> cntMap = new HashMap<>();

        qu.add(new Node(id, 0));
        vis[id] = true;
        while (!qu.isEmpty()) {
            Node top = qu.poll();
            if (top.level >= level) {
                for (String s : watchedVideos.get(top.idx)) {
                    cntMap.put(s, cntMap.getOrDefault(s, 0) + 1);
                }
                continue;
            }
            for (int next : friends[top.idx]) {
                if (!vis[next]) {
                    qu.add(new Node(next, top.level + 1));
                    vis[next] = true;
                }
            }
        }
        List<String> ret = new ArrayList<>(cntMap.keySet());
        ret.sort((o1, o2) -> {
            Integer t1 = cntMap.get(o1), t2 = cntMap.get(o2);
            return t1.equals(t2) ? o1.compareTo(o2) : t1.compareTo(t2);
        });
        return ret;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().watchedVideosByFriends(
                ArrayInputUtils.parseStrList2("[[\"A\",\"B\"],[\"C\"],[\"B\",\"C\"],[\"D\"]]"),
                ArrayInputUtils.parseIntArr2("[[1,2],[0,3],[0,3],[1,2]]"),
                0, 1
        ));
        System.out.println(new Solution().watchedVideosByFriends(
                ArrayInputUtils.parseStrList2("[[\"A\",\"B\"],[\"C\"],[\"B\",\"C\"],[\"D\"]]"),
                ArrayInputUtils.parseIntArr2("[[1,2],[0,3],[0,3],[1,2]]"),
                0, 2
        ));
    }
}
