package match.weekly.weekly202.p3;

import java.util.Arrays;
import java.util.TreeSet;
import java.util.stream.Collectors;

class Solution {

    private boolean check(TreeSet<Integer> posSet, int m, int dis) {
        Integer cur = posSet.first() - 1;
        for (int i = 1; i <= m; ++i) {
            cur = posSet.higher(cur);
            if (cur == null) {
                return false;
            }
            cur += dis - 1;
        }
        return true;
    }

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int L = 1, R = position[position.length - 1] - position[0] + 5, ok = 1;
        TreeSet<Integer> posSet = Arrays.stream(position).boxed().collect(Collectors.toCollection(TreeSet::new));
        while (L < R) {
            int mid = (L + R) / 2;
            boolean check = check(posSet, m, mid);
            if (check) {
                ok = mid;
                L = mid + 1;
            } else {
                R = mid;
            }
        }
        return ok;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().maxDistance(new int[]{1, 2, 3, 4, 7}, 3));
        System.out.println(new Solution().maxDistance(new int[]{5, 4, 3, 2, 1, 1000000000}, 2));
    }
}
