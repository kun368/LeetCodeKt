package match.weekly.weekly188.p1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    public List<String> buildArray(int[] target, int n) {
        Set<Integer> set = Arrays.stream(target).boxed().collect(Collectors.toSet());
        List<String> ret = new ArrayList<>();
        for (int i = 1; i <= target[target.length - 1]; ++i) {
            if (set.contains(i)) {
                ret.add("Push");
            } else {
                ret.add("Push");
                ret.add("Pop");
            }
        }
        return ret;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().buildArray(new int[]{1, 3}, 3));
        System.out.println(new Solution().buildArray(new int[]{1,2, 3}, 3));
        System.out.println(new Solution().buildArray(new int[]{1, 2}, 4));
        System.out.println(new Solution().buildArray(new int[]{2, 3, 4}, 4));
    }
}
