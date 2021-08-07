package match.biweekly.biweekly58.p1;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String makeFancyString(String s) {
        List<Character> ret = new ArrayList<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (ret.size() >= 2 && c == ret.get(ret.size() - 1) && c == ret.get(ret.size() - 2)) {
                continue;
            }
            ret.add(c);
        }
        StringBuilder sb = new StringBuilder();
        ret.forEach(sb::append);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().makeFancyString("leeetcode"));
        System.out.println(new Solution().makeFancyString("aaabaaaa"));
        System.out.println(new Solution().makeFancyString("aab"));
    }
}