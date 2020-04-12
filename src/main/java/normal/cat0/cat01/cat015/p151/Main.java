package normal.cat0.cat01.cat015.p151;

/**
 * 151. 翻转字符串里的单词
 * <p>
 * string 转 char[] 和 char[] 转 string 只是为了模拟C语言，排除这两个损耗外
 * 整体空间复杂度O(1) 时间复杂度为2N
 */
class Solution {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        reverseRange(arr, 0, arr.length);
        int pos = 0, len = 0;
        while (true) {
            while (pos < arr.length && arr[pos] == ' ') {
                pos++;
            }
            int tmp = len;
            while (pos < arr.length && arr[pos] != ' ') {
                if (tmp == len && len > 0) {
                    arr[len++] = ' ';
                    tmp += 1;
                }
                arr[len++] = arr[pos++];
            }
            reverseRange(arr, tmp, len);
            if (pos >= arr.length) {
                break;
            }
        }
        return new String(arr, 0, len);
    }

    private void reverseRange(char[] arr, int from, int to) {
        for (int i = 0, sz = (to - from) / 2; i < sz; ++i) {
            char t = arr[from + i];
            arr[from + i] = arr[to - i - 1];
            arr[to - i - 1] = t;
        }
    }
}


public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().reverseWords("the sky is blue"));
        System.out.println(new Solution().reverseWords("  hello world!  "));
        System.out.println(new Solution().reverseWords("a good   example"));
    }
}
