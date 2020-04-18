package match.biweekly.biweekly21.p1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Solution {
    public String sortString(String s) {
        StringBuilder sb = new StringBuilder();

        Map<Character, Integer> mp = new TreeMap<>();
        for (int i = 0; i < s.length(); ++i) {
            mp.put(s.charAt(i), mp.getOrDefault(s.charAt(i), 0) + 1);
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(mp.entrySet());

        int p = 0;
        for (int i = 0; i < 512; ++i) {
            for (int j = 0; j < list.size(); ++j) {
                if (list.get(j).getValue() > p) {
                    sb.append(list.get(j).getKey());
                }
            }
            p += 1;
            for (int j = list.size() - 1; j >= 0; --j) {
                if (list.get(j).getValue() > p) {
                    sb.append(list.get(j).getKey());
                }
            }
            p += 1;
        }
        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().sortString("aaaabbbbcccc"));
        System.out.println(new Solution().sortString("rat"));
        System.out.println(new Solution().sortString("leetcode"));
        System.out.println(new Solution().sortString("ggggggg"));
        System.out.println(new Solution().sortString("spo"));
    }
}
