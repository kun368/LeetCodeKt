package match.weekly.weekly200.p2;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int getWinner(int[] arr, int k) {
        k = Math.min(k, arr.length + 5);
        Deque<Integer> list = new LinkedList<>();
        for (int i : arr) {
            list.add(i);
        }
        int current = 0, cnt = 0;
        while (true) {
            int a = list.removeFirst(), b = list.removeFirst();
            int max = Math.max(a, b), min = Math.min(a, b);
            if (max != current) {
                current = max;
                cnt = 1;
            } else {
                cnt += 1;
            }
            if (cnt >= k) {
                return current;
            }
            list.addFirst(max);
            list.addLast(min);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().getWinner(new int[]{2, 1, 3, 5, 4, 6, 7}, 2));
        System.out.println(new Solution().getWinner(new int[]{3, 2, 1}, 10));
        System.out.println(new Solution().getWinner(new int[]{1, 9, 8, 2, 3, 7, 6, 4, 5}, 7));
        System.out.println(new Solution().getWinner(new int[]{1, 11, 22, 33, 44, 55, 66, 77, 88, 99}, 1000000000));
    }
}
