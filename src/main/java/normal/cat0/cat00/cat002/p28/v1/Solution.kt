package normal.cat0.cat00.cat002.p28.v1

class Solution {
    fun strStr(haystack: String, needle: String): Int {
        return haystack.indexOf(needle)
    }
}

fun main() {
    println(Solution().strStr("hello", "ll"))
    println(Solution().strStr("aaaaa", "bba"))
}