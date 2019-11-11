package cat1.cat12.cat125.p1255;


class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] cnt = new int[27];
        for (char c : letters) {
            cnt[c - 'a'] += 1;
        }
        int[] wordScore = new int[words.length];
        for (int i = 0; i < words.length; ++i) {
            wordScore[i] = words[i].chars().map(it -> score[it - 'a']).sum();
        }
        int ret = 0;
        for (int s = 0; s < (1 << words.length); ++s) {
            int[] use = new int[27];
            int sum = 0;
            for (int i = 0; i < words.length; ++i) {
                if ((s & (1 << i)) > 0) {
                    words[i].chars().forEach(it -> ++use[it - 'a']);
                    sum += wordScore[i];
                }
            }
            boolean ok = true;
            for (int i = 0; i < use.length; ++i) {
                if (use[i] > cnt[i]) {
                    ok = false;
                    break;
                }
            }
            if (ok) ret = Math.max(ret, sum);
        }
        return ret;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().maxScoreWords(
                new String[]{"dog", "cat", "dad", "good"},
                new char[]{'a', 'a', 'c', 'd', 'd', 'd', 'g', 'o', 'o'},
                new int[]{1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        ));
        System.out.println(new Solution().maxScoreWords(
                new String[]{"xxxz", "ax", "bx", "cx"},
                new char[]{'z', 'a', 'b', 'c', 'x', 'x', 'x'},
                new int[]{4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 10}
        ));
        System.out.println(new Solution().maxScoreWords(
                new String[]{"leetcode"},
                new char[]{'l', 'e', 't', 'c', 'o', 'd'},
                new int[]{0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0}
        ));
    }
}
