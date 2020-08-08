package match.biweekly.biweekly32.p1;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    public int findKthPositive(int[] arr, int k) {
        Set<Integer> set = Arrays.stream(arr).boxed().collect(Collectors.toSet());
        int t = 0;
        for (int i = 1; ; ++i) {
            if (set.contains(i)) continue;
            if (++t == k) {
                return i;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
