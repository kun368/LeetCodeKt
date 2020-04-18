package match.weekly.weekly169.p4;

import utils.java.ArrayInputUtils;

import java.util.*;

class Solution {

    private String[] words;
    private String result;
    private List<Character> chars;
    private int[] mps;
    private boolean ret;

    private List<Character> getChars() {
        Set<Character> cSet = new TreeSet<>();
        for (String s : words) {
            for (int i = 0; i < s.length(); ++i) {
                cSet.add(s.charAt(i));
            }
        }
        for (int i = 0; i < result.length(); ++i) {
            cSet.add(result.charAt(i));
        }
        return new ArrayList<>(cSet);
    }

    boolean check() {
        if (mps[result.charAt(0)] <= 0) {
            return false;
        }
        for (String s : words) {
            if (mps[s.charAt(0)] <= 0) {
                return false;
            }
        }

        int total = 0;
        for (int i = 0; i < result.length(); ++i) {
            int val = mps[result.charAt(i)];
            total = total * 10 + val;
        }
        for (String s : words) {
            int cur = 0;
            for (int i = 0; i < s.length(); ++i) {
                int val = mps[s.charAt(i)];
                cur = cur * 10 + val;
            }
            total -= cur;
            if (total < 0) return false;
        }
        return total == 0;
    }

    private void dfs(int current, boolean[] mpVis) {
        if (ret) return;
        if (current == chars.size()) {
            if (check()) ret = true;
            return;
        }
        for (int i = 0; i <= 9; ++i) {
            if (mpVis[i]) {
                continue;
            }
            mpVis[i] = true;
            mps[chars.get(current)] = i;
            dfs(current + 1, mpVis);
            mpVis[i] = false;
        }
    }

    public boolean isSolvable(String[] words, String result) {
        this.words = words;
        this.result = result;
        this.ret = false;
        chars = getChars();
        mps = new int[300];
        boolean[] mpVis = new boolean[10];
        dfs(0, mpVis);
        return ret;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().isSolvable(
                ArrayInputUtils.parseStrArr1("[\"SEND\",\"MORE\"]"), "MONEY"));
        System.out.println(new Solution().isSolvable(
                ArrayInputUtils.parseStrArr1("[\"SIX\",\"SEVEN\",\"SEVEN\"]"), "TWENTY"));
        System.out.println(new Solution().isSolvable(
                ArrayInputUtils.parseStrArr1("[\"THIS\",\"IS\",\"TOO\"]"), "FUNNY"));
        System.out.println(new Solution().isSolvable(
                ArrayInputUtils.parseStrArr1("[\"LEET\",\"CODE\"]"), "POINT"));
        System.out.println(new Solution().isSolvable(
                ArrayInputUtils.parseStrArr1("[\"SEIS\",\"CATORCE\",\"SETENTA\"]"), "NOVENTA"));
    }
}
