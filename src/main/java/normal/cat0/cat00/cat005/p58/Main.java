package normal.cat0.cat00.cat005.p58;

class Solution {
    public int lengthOfLastWord(String s) {
        int letter = -1;
        for (int i = s.length() - 1; i >= 0; --i) {
            if (letter > 0 && s.charAt(i) == ' ') {
                return letter - i;
            }
            if (letter < 0 && Character.isLetter(s.charAt(i))) {
                letter = i;
            }
        }
        return letter + 1;
    }
}


public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLastWord(""));
        System.out.println(new Solution().lengthOfLastWord("a"));
        System.out.println(new Solution().lengthOfLastWord("a "));
//        System.out.println(new Solution().lengthOfLastWord("abc"));
//        System.out.println(new Solution().lengthOfLastWord("a b ccc"));
    }
}
