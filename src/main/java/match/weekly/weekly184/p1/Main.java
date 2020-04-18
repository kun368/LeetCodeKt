package match.weekly.weekly184.p1;

import utils.java.DebugUtils;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> ret = new ArrayList<>();
        for (String i : words) {
            for (String j : words) {
                if (!i.equals(j) && j.contains(i)) {
                    ret.add(i);
                    break;
                }
            }
        }
        return ret;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().stringMatching(DebugUtils.parseStrArr1("[\"mass\",\"as\",\"hero\",\"superhero\"]")));
        System.out.println(new Solution().stringMatching(DebugUtils.parseStrArr1("[\"leetcode\",\"et\",\"code\"]")));
        System.out.println(new Solution().stringMatching(DebugUtils.parseStrArr1("[\"blue\",\"green\",\"bu\"]")));
    }
}
