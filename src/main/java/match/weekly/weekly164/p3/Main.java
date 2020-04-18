package match.weekly.weekly164.p3;

import java.util.*;

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<String> set = Arrays.asList(products);
        Collections.sort(set);
        List<List<String>> ret = new ArrayList<>();
        for (int i = 0; i < searchWord.length(); ++i) {
            char cur = searchWord.charAt(i);
            List<String> next = new ArrayList<>();
            for (String s : set) {
                if (s.length() >= i + 1 && s.charAt(i) == cur) {
                    next.add(s);
                }
            }
            ret.add(next.subList(0, Math.min(3, next.size())));
            set = next;
        }
        return ret;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().suggestedProducts(new String[]{
                "mobile", "mouse", "moneypot", "monitor", "mousepad"
        }, "mouse"));
        System.out.println(new Solution().suggestedProducts(new String[]{
                "havana",
        }, "havana"));
        System.out.println(new Solution().suggestedProducts(new String[]{
                "bags", "baggage", "banner", "box", "cloths"
        }, "bags"));
        System.out.println(new Solution().suggestedProducts(new String[]{
                "havana"
        }, "tatiana"));
    }
}
