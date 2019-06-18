package cat0.cat00.cat001.p14.v1

/**
 * 一行AC系列
 */
class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        return (if (strs.isEmpty()) arrayOf("") else strs).reduce { acc, s -> acc.commonPrefixWith(s) }
    }
}

fun main(args: Array<String>) {
    println(Solution().longestCommonPrefix(arrayOf()))
    println(Solution().longestCommonPrefix(arrayOf("")))
    println(Solution().longestCommonPrefix(arrayOf("flower", "flow", "flight")))
    println(Solution().longestCommonPrefix(arrayOf("dog", "racecar", "car")))
}