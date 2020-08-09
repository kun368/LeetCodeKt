package normal.cat0.cat00.cat009.p93;

import utils.java.fastcode.KunDeque;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;


class Solution {

    private List<String> retIp = new ArrayList<>();

    private void dfs(String s, int i, KunDeque<String> list) {
        if (list.size() == 4) {
            if (i == s.length()) {
                StringJoiner sj = new StringJoiner(".");
                for (int k = 0; k < list.size(); ++k) {
                    sj.add(list.get(k));
                }
                retIp.add(sj.toString());
            }
            return;
        }
        for (int j = i + 1; j <= i + 3 && j <= s.length(); ++j) {
            String cur = s.substring(i, j);
            int val = Integer.parseInt(cur);
            if (val > 255) continue;
            if (!cur.equals(String.valueOf(val))) continue;
            list.pushBack(cur);
            dfs(s, j, list);
            list.popBack(true);
        }
    }

    public List<String> restoreIpAddresses(String s) {
        dfs(s, 0, new KunDeque<>());
        return retIp;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().restoreIpAddresses("25525511135"));
        System.out.println(new Solution().restoreIpAddresses("010010"));
    }
}
