package match.weekly.weekly189.p2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

class Solution {
    public String arrangeWords(String text) {
        String ret = Arrays.stream(text.toLowerCase().split("\\s"))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.joining(" "));
        return ret.substring(0, 1).toUpperCase() + ret.substring(1);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().arrangeWords("Leetcode is cool"));
        System.out.println(new Solution().arrangeWords("Keep calm and code on"));
        System.out.println(new Solution().arrangeWords("To be or not to be"));
        System.out.println(new Solution().arrangeWords("A"));
    }
}
