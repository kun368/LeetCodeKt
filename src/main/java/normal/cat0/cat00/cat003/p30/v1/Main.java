package normal.cat0.cat00.cat003.p30.v1;

import java.util.*;

import static utils.java.ArrayInputUtils.parseStrArr1;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        if (s.length() == 0 || words.length == 0) {
            return Collections.emptyList();
        }
        int N = words.length, M = words[0].length();
        Map<String, Integer> cnt = new HashMap<>();
        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < M; ++i) {
            Queue<String> qu = new ArrayDeque<>();
            HashMap<String, Integer> curCnt = new HashMap<>();
            for (int j = i; j + M <= s.length(); j += M) {
                String s1 = s.substring(j, j + M);
                qu.add(s1);
                curCnt.put(s1, curCnt.getOrDefault(s1, 0) + 1);
                if (qu.size() > N) {
                    String top = qu.poll();
                    Integer preCnt = curCnt.get(top);
                    if (preCnt == 1) {
                        curCnt.remove(top);
                    } else {
                        curCnt.put(top, preCnt - 1);
                    }
                }
                if (qu.size() == N && curCnt.equals(cnt)) {
                    ret.add(j + M - N * M);
                }
            }
        }
        return ret;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().findSubstring("barfoothefoobarman",
                parseStrArr1("[\"foo\",\"bar\"]")));
        System.out.println(new Solution().findSubstring("wordgoodgoodgoodbestword",
                parseStrArr1("[\"word\",\"good\",\"best\",\"word\"]")));
        System.out.println(new Solution().findSubstring("barfoofoobarthefoobarman",
                parseStrArr1("[\"bar\",\"foo\",\"the\"]")));
        System.out.println(new Solution().findSubstring("wordgoodgoodgoodbestword",
                parseStrArr1("[\"word\",\"good\",\"best\",\"good\"]")));
    }
}
