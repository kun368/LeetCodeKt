package match.weekly.weekly199.p1;

class Solution {
    public String restoreString(String s, int[] indices) {
        char[] cs = new char[s.length()];
        for (int i = 0; i < s.length(); ++i) {
            cs[indices[i]] = s.charAt(i);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : cs) {
            sb.append(c);
        }
        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
