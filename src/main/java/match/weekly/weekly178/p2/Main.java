package match.weekly.weekly178.p2;

import utils.java.DebugUtils;

import java.util.*;

class Solution {
    public String rankTeams(String[] votes) {
        int cnt = votes[0].length();
        Map<Character, Map<Integer, Integer>> mp = new HashMap<>();
        for (String vote : votes) {
            for (int i = 0; i < vote.length(); ++i) {
                char c = vote.charAt(i);
                if (!mp.containsKey(c)) {
                    mp.put(c, new HashMap<>());
                }
                mp.get(c).put(i, mp.get(c).getOrDefault(i, 0) + 1);
            }
        }

        List<Character> users = new ArrayList<>(mp.keySet());
        users.sort((a, b) -> {
            Map<Integer, Integer> m1 = mp.get(a), m2 = mp.get(b);
            for (int i = 0; i < cnt; ++i) {
                int cmp = m1.getOrDefault(i, 0).compareTo(m2.getOrDefault(i, 0));
                if (cmp != 0) return -cmp;
            }
            return a.compareTo(b);
        });

        StringBuilder sb = new StringBuilder();
        for (Character c : users) {
            sb.append(c);
        }
        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().rankTeams(DebugUtils.parseStrArr1("[\"ABC\",\"ACB\",\"ABC\",\"ACB\",\"ACB\"]")));
        System.out.println(new Solution().rankTeams(DebugUtils.parseStrArr1("[\"WXYZ\",\"XYZW\"]")));
        System.out.println(new Solution().rankTeams(DebugUtils.parseStrArr1("[\"ZMNAGUEDSJYLBOPHRQICWFXTVK\"]")));
        System.out.println(new Solution().rankTeams(DebugUtils.parseStrArr1("[\"BCA\",\"CAB\",\"CBA\",\"ABC\",\"ACB\",\"BAC\"]")));
        System.out.println(new Solution().rankTeams(DebugUtils.parseStrArr1("[\"M\",\"M\",\"M\",\"M\"]")));
    }
}
