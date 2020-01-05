package match.weekly170.p4;

class Solution {

    private int[][] dp;

    private int calc(String s, int ax, int ay, int bx, int by) {
        int N = ay - ax, M = by - bx;
        for (int i = 0; i <= N; ++i) {
            for (int j = 0; j <= M; ++j) {
                if (i == 0 || j == 0)  {
                    dp[i][j] = Math.max(i, j);
                    continue;
                }
                int c1 = s.charAt(ay - i), c2 = s.charAt(bx + j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j - 1] + 2));
                }
            }
        }
        return dp[N][M];
    }

    public int minInsertions(String s) {
        if (s.length() <= 1) {
            return 0;
        }
        dp = new int[s.length() + 1][s.length() + 1];
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); ++i) {
            ans = Math.min(ans, calc(s, 0, i, i + 1, s.length()));
            ans = Math.min(ans, calc(s, 0, i, i, s.length()));
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().minInsertions("zzazz"));
        System.out.println(new Solution().minInsertions("mbadm"));
        System.out.println(new Solution().minInsertions("leetcode"));
        System.out.println(new Solution().minInsertions("g"));
        System.out.println(new Solution().minInsertions("no"));
        System.out.println(new Solution().minInsertions("zjveiiwvc"));
        System.out.println(new Solution().minInsertions("jqmowntvxbbtyxtzpulsbzxwwlzbtkglzagtpkxrgpyvljtojqasfdimmjdjcmcpfrpmmkwiinxgedbsdaokfzsvxslsqiqvjqighhkvekpaiehmdacxvuckvfaecbdxlolcaxeklqnfpvphuoefxdypuxblwbvtzhctnojwkvkeknpijznnmqalqhmvumckefrbqxjeheamomttfunnrwasfczbcjgfprwogiswjitjiqlzalduxhccwklkcdylppstmtmkbviaxxjomkimzinrufwpraftmtprkaoybeablqubeovrvimojdhpttrhilnhvvtvnabdmkykwirbxmlqsatkydynxatbtezynlkvfjqahoezamptrizjsypggmewaconvrdzddftsbzrxarwymzujynabiozezbstejglqdcxiymqzsdebdtdweebfsbkcxdunaxgaymzmvoyukaqctdjggyebfxduwhpzctzylkyprb"));
        System.out.println(new Solution().minInsertions("plkofzuofubstkjvmqpqnteukadjglraioqglvnhcjqwejdsmspzhvdsaopousfcbvmqtcndttciosvvkgvrfilkmnjkdeothndujhffchoalbtaltwwwtlatblaohcffhjudnhtoedkjnmklifrvgkvvsoicttdnctqmvbcfsuopoasdvhzpsmsdjewqjchnvlgqoiarlgjdakuetnqpqmvjktsbufouzfoklp"));


    }
}
