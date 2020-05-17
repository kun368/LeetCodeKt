package match.weekly.weekly189.p3;


import utils.java.DebugUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {

    boolean containAll(Set<String> set, List<String> list) {
        for (String s : list) {
            if (!set.contains(s)) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Integer> ans = new ArrayList<>();
        List<Set<String>> list = favoriteCompanies.stream().map(HashSet::new).collect(Collectors.toList());
        for (int i = 0; i < favoriteCompanies.size(); ++i) {
            List<String> cur = favoriteCompanies.get(i);
            boolean found = false;
            for (int j = 0; j < list.size(); ++j) {
                if (i != j && containAll(list.get(j), cur)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                ans.add(i);
            }
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().peopleIndexes(DebugUtils.parseStrList2(
                "[[\"leetcode\",\"google\",\"facebook\"],[\"google\",\"microsoft\"],[\"google\",\"facebook\"],[\"google\"],[\"amazon\"]]")));
        System.out.println(new Solution().peopleIndexes(DebugUtils.parseStrList2(
                "[[\"leetcode\",\"google\",\"facebook\"],[\"leetcode\",\"amazon\"],[\"facebook\",\"google\"]]")));
        System.out.println(new Solution().peopleIndexes(DebugUtils.parseStrList2(
                "[[\"leetcode\"],[\"google\"],[\"facebook\"],[\"amazon\"]]")));

    }
}
