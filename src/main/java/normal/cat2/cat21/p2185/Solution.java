package normal.cat2.cat21.p2185;

import java.util.Arrays;

class Solution {
    public int prefixCount(String[] words, String pref) {
        return (int) Arrays.stream(words).filter(it -> it.startsWith(pref)).count();
    }
}