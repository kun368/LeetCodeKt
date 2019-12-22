package match.weekly168.p4;

import utils.java.ArrayInputUtils;

import java.util.*;

class Solution {

    class Node {
        int candies;
        boolean isGet;
        boolean isOpen;

        boolean getAndOpen() {
            return isGet && isOpen;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "candies=" + candies +
                    ", isGet=" + isGet +
                    ", isOpen=" + isOpen +
                    '}';
        }
    }

    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int N = status.length;
        Set<Integer> initSet = new HashSet<>();
        for (int i : initialBoxes) initSet.add(i);

        Node[] nodes = new Node[N];
        Set<Integer> update = new HashSet<>();
        Set<Integer> vis = new HashSet<>();
        for (int i = 0; i < N; ++i) {
            nodes[i] = new Node();
            nodes[i].candies = candies[i];
            nodes[i].isGet = initSet.contains(i);
            nodes[i].isOpen = status[i] == 1;
            if (nodes[i].getAndOpen()) {
                update.add(i);
            }
        }

        while (!update.isEmpty()) {
            // System.out.println(Arrays.toString(nodes) + ", up = " + update);
            vis.addAll(update);
            Set<Integer> next = new HashSet<>();
            for (Integer i : update) {
                for (int j : containedBoxes[i]) {
                    nodes[j].isGet = true;
                }
                for (int j : keys[i]) {
                    nodes[j].isOpen = true;
                    if (!vis.contains(j) && nodes[j].getAndOpen()) next.add(j);
                }
                for (int j : containedBoxes[i]) {
                    if (!vis.contains(j) && nodes[j].getAndOpen()) next.add(j);
                }
            }
            update = next;
        }

        int ans = 0;
        for (int i = 0; i < N; ++i) {
            if (nodes[i].getAndOpen()) ans += nodes[i].candies;
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().maxCandies(
                ArrayInputUtils.parseIntArr1("[1,0,1,0]"),
                ArrayInputUtils.parseIntArr1("[7,5,4,100]"),
                ArrayInputUtils.parseIntArr2("[[],[],[1],[]]"),
                ArrayInputUtils.parseIntArr2("[[1,2],[3],[],[]]"),
                ArrayInputUtils.parseIntArr1("[0]")
        ));
        System.out.println(new Solution().maxCandies(
                ArrayInputUtils.parseIntArr1("[1,0,0,0,0,0]"),
                ArrayInputUtils.parseIntArr1("[1,1,1,1,1,1]"),
                ArrayInputUtils.parseIntArr2("[[1,2,3,4,5],[],[],[],[],[]]"),
                ArrayInputUtils.parseIntArr2("[[1,2,3,4,5],[],[],[],[],[]]"),
                ArrayInputUtils.parseIntArr1("[0]")
        ));
        System.out.println(new Solution().maxCandies(
                ArrayInputUtils.parseIntArr1("[1,1,1]"),
                ArrayInputUtils.parseIntArr1("[100,1,100]"),
                ArrayInputUtils.parseIntArr2("[[],[0,2],[]]"),
                ArrayInputUtils.parseIntArr2("[[],[],[]]"),
                ArrayInputUtils.parseIntArr1("[1]")
        ));
        System.out.println(new Solution().maxCandies(
                ArrayInputUtils.parseIntArr1("[1]"),
                ArrayInputUtils.parseIntArr1("[100]"),
                ArrayInputUtils.parseIntArr2("[[]]"),
                ArrayInputUtils.parseIntArr2("[[]]"),
                ArrayInputUtils.parseIntArr1("[]")
        ));
        System.out.println(new Solution().maxCandies(
                ArrayInputUtils.parseIntArr1("[1,1,1]"),
                ArrayInputUtils.parseIntArr1("[2,3,2]"),
                ArrayInputUtils.parseIntArr2("[[],[],[]]"),
                ArrayInputUtils.parseIntArr2("[[],[],[]]"),
                ArrayInputUtils.parseIntArr1("[2,1,0]")
        ));
        System.out.println(new Solution().maxCandies(
                ArrayInputUtils.parseIntArr1("[1,1,0,1,1,0,0,1,0,0,1,1,0,0,0,0,1,0,1,1,0,0,0,0,1,0,0,0,1,0,0,1,1,1,1,1,0,1,1,0,1,1,1,1,0,0,1,0,0]"),
                ArrayInputUtils.parseIntArr1("[732,320,543,300,814,568,947,685,142,111,805,233,813,306,55,1,290,944,36,592,150,596,372,299,644,445,605,202,64,807,753,731,552,766,119,862,453,136,43,572,801,518,936,408,515,215,492,738,154]\n"),
                ArrayInputUtils.parseIntArr2("[[42,2,24,8,39,16,46],[20,39,46,21,32,31,43,16,12,23,3],[21,14,30,2,11,13,27,37,4,48],[16,17,15,6],[31,14,3,32,35,19,42,43,44,29,25,41],[7,39,2,3,40,28,37,35,43,22,6,23,48,10,21,11],[27,1,37,3,45,32,30,26,16,2,35,19,31,47,5,14],[28,35,23,17,6],[6,39,34,22],[44,29,36,31,40,22,9,11,17,25,1,14,41],[39,37,11,36,17,42,13,12,7,9,43,41],[23,16,32,37],[36,39,21,41],[15,27,5,42],[11,5,18,48,25,47,17,0,41,26,9,29],[18,36,40,35,12,33,11,5,44,14,46,7],[48,22,11,33,14],[44,12,3,31,25,15,18,28,42,43],[36,9,0,42],[1,22,3,24,9,11,43,8,35,5,41,29,40],[15,47,32,28,33,31,4,43],[1,11,6,37,28],[46,20,47,32,26,15,11,40],[33,45,26,40,12,3,16,18,10,28,5],[14,6,4,46,34,9,33,24,30,12,37],[45,24,18,31,32,39,26,27],[29,0,32,15,7,48,36,26,33,31,18,39,23,34,44],[25,16,42,31,41,35,26,10,3,1,4,29],[8,11,5,40,9,18,10,16,26,30,19,2,14,4],[],[0,20,17,47,41,36,23,42,15,13,27],[7,15,44,38,41,42,26,19,5,47],[],[37,22],[21,24,15,48,33,6,39,11],[23,7,3,29,10,40,1,16,6,8,27],[27,29,25,26,46,15,16],[33,40,10,38,13,19,17,23,32,39,7],[35,3,39,18],[47,11,27,23,35,26,43,4,22,38,44,31,1,0],[],[18,43,46,9,15,3,42,31,13,4,12,39,22],[42,45,47,18,26,41,38,9,0,35,8,16,29,36,31],[3,20,29,12,46,41,23,4,9,27],[19,33],[32,18],[17,28,7,35,6,22,4,43],[41,31,20,28,35,32,24,23,0,33,18,39,29,30,16],[43,47,46]]\n"),
                ArrayInputUtils.parseIntArr2("[[14],[],[26],[4,47],[],[6],[39,43,46],[30],[],[],[0,3],[],[],[],[],[27],[],[],[],[],[12],[],[],[41],[],[31],[20,29],[13,35],[18],[10,40],[],[38],[],[],[19],[5],[],[],[11],[1],[15],[],[],[],[24],[],[],[],[]]\n"),
                ArrayInputUtils.parseIntArr1("[2,7,8,9,16,17,21,22,23,25,28,32,33,34,36,37,42,44,45,48]")
        ));
    }
}
