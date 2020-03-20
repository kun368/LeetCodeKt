package normal.cat1.cat10.cat107.p1071.v1

/**
 * 字符串的最大公因子
 */
class Solution {
    fun gcdOfStrings(str1: String, str2: String): String {
        val maxLen = Math.min(str1.length, str2.length)
        for (len in maxLen.downTo(1)) {
            if (str1.length.rem(len) != 0) continue
            if (str2.length.rem(len) != 0) continue
            val match = str1.substring(0, len)
            var i = 0
            var ok = true
            while (i < maxLen) {
                if (match != str1.substring(i, i + len) || match != str2.substring(i, i + len)) {
                    ok = false
                    break
                }
                i += len
            }
            if (ok) return match
        }
        return ""
    }
}


fun main(args: Array<String>) {
    println(Solution().gcdOfStrings("ABCABC", "ABC"))
    println(Solution().gcdOfStrings("ABABAB", "ABAB"))
    println(Solution().gcdOfStrings("AA", "A"))
    println(Solution().gcdOfStrings("LEET", "CODE"))

}