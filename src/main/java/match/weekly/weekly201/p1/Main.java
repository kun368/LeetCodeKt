package match.weekly.weekly201.p1;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

class Solution {
    public String makeGood(String s) {
        List<Integer> list = s.chars().boxed().collect(Collectors.toList());
        while (true) {
            boolean ok = true;
            for (int i = 0; i < list.size() - 1; ++i) {
                int a = list.get(i), b = list.get(i + 1);
                if (a != b && (Character.toLowerCase(a) == b || Character.toLowerCase(b) == a)) {
                    list.remove(i + 1);
                    list.remove(i);
                    ok = false;
                    break;
                }
            }
            if (ok) break;
        }
        StringJoiner sj = new StringJoiner("");
        for (int i : list) {
            char c = (char) i;
            sj.add(String.valueOf(c));
        }
        return sj.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().makeGood("leEeetcode"));
        System.out.println(new Solution().makeGood("abBAcC"));
        System.out.println(new Solution().makeGood("s"));
    }
}
