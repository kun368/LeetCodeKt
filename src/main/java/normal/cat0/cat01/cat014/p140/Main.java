package normal.cat0.cat01.cat014.p140;


import java.util.*;

/**
 * 140. 单词拆分 II
 * <p>
 * 字典树 + 记忆化搜索
 */
class Solution {

    static class TrieNode {
        int value = -1;
        HashMap<Character, TrieNode> son = new HashMap<>();
    }

    TrieNode root;
    private List<List<Integer>>[] dp;

    public List<String> wordBreak(String s, List<String> wordDict) {
        root = new TrieNode();
        dp = new List[s.length()];
        for (int t = 0; t < wordDict.size(); ++t) {
            String word = wordDict.get(t);
            TrieNode cur = root;
            for (int i = 0; i < word.length(); ++i) {
                char c = word.charAt(i);
                cur = cur.son.computeIfAbsent(c, x -> new TrieNode());
            }
            cur.value = t;
        }
        List<List<Integer>> ok = dfs(s, 0);
        List<String> ret = new ArrayList<>();
        for (List<Integer> i : ok) {
            StringJoiner sj = new StringJoiner(" ");
            i.forEach(it -> sj.add(wordDict.get(it)));
            ret.add(sj.toString());
        }
        return ret;
    }

    private List<List<Integer>> dfs(String s, int st) {
        if (st >= s.length()) {
            return new ArrayList<>();
        }
        if (dp[st] != null) {
            return dp[st];
        }
        List<List<Integer>> ret = new ArrayList<>();
        TrieNode cur = root;
        for (int i = st; i < s.length(); ++i) {
            char c = s.charAt(i);
            cur = cur.son.get(c);
            if (cur == null) {
                break;
            }
            if (cur.value >= 0) {
                if (i == s.length() - 1) {
                    ret.add(Collections.singletonList(cur.value));
                }
                for (List<Integer> right : dfs(s, i + 1)) {
                    List<Integer> tmp = new ArrayList<>(right.size() + 1);
                    tmp.add(cur.value);
                    tmp.addAll(right);
                    ret.add(tmp);
                }
            }
        }
        dp[st] = ret;
        return ret;
    }
}


public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().wordBreak("catsanddog",
                Arrays.asList("cat", "cats", "and", "sand", "dog")));
        System.out.println(new Solution().wordBreak("pineapplepenapple",
                Arrays.asList("apple", "pen", "applepen", "pine", "pineapple")));
        System.out.println(new Solution().wordBreak("catsandog",
                Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }
}
