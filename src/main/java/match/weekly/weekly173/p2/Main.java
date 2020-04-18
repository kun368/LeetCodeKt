package match.weekly.weekly173.p2;

import utils.java.DebugUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Solution {

    private class Node {
        public int id, rating, veganFriendly, price, distance;
    }

    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<Node> list = new ArrayList<>();
        for (int[] r : restaurants) {
            Node cur = new Node();
            cur.id = r[0];
            cur.rating = r[1];
            cur.veganFriendly = r[2];
            cur.price = r[3];
            cur.distance = r[4];
            if (veganFriendly == 1 && cur.veganFriendly == 0) {
                continue;
            }
            if (cur.distance > maxDistance) {
                continue;
            }
            if (cur.price > maxPrice) {
                continue;
            }
            list.add(cur);
        }
        list.sort((o1, o2) -> {
            int t = Integer.compare(o2.rating, o1.rating);
            return t != 0 ? t : Integer.compare(o2.id, o1.id);
        });
        return list.stream().map(it -> it.id).collect(Collectors.toList());
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().filterRestaurants(
                DebugUtils.parseIntArr2("[[1,4,1,40,10],[2,8,0,50,5],[3,8,1,30,4],[4,10,0,10,3],[5,1,1,15,1]]"), 1, 50, 10));

        System.out.println(new Solution().filterRestaurants(
                DebugUtils.parseIntArr2("[[1,4,1,40,10],[2,8,0,50,5],[3,8,1,30,4],[4,10,0,10,3],[5,1,1,15,1]]"), 0, 50, 10));

        System.out.println(new Solution().filterRestaurants(
                DebugUtils.parseIntArr2("[[1,4,1,40,10],[2,8,0,50,5],[3,8,1,30,4],[4,10,0,10,3],[5,1,1,15,1]]"), 0, 30, 3));


    }
}
