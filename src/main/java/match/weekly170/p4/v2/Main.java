package match.weekly170.p4.v2;

class Solution {
    public int minInsertions(String s) {
        int N = s.length();
        String r = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[N + 1][N + 1];
        for (int i = 1; i <= N; ++i) {
            for (int j = 1; j <= N; ++j) {
                char c1 = s.charAt(i - 1), c2 = r.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return N - dp[N][N];
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

