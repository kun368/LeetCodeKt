package match.biweekly.biweekly27.p1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        List<Integer> s1 = Arrays.stream(target).boxed().sorted().collect(Collectors.toList());
        List<Integer> s2 = Arrays.stream(arr).boxed().sorted().collect(Collectors.toList());
        return s1.equals(s2);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("1");
    }
}
