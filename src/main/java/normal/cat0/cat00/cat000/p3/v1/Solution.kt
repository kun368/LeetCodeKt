package normal.cat0.cat00.cat000.p3.v1

import kotlin.math.max

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var start = -1
        var maxLen = 0
        val prev = hashMapOf<Char, Int>()
        s.forEachIndexed { id, c ->
            start = max(start, prev[c] ?: -1)
            maxLen = max(maxLen, id - start)
            prev[c] = id
        }
        return maxLen
    }
}

fun main() {
    println(Solution().lengthOfLongestSubstring("abcabcbb"))
    println(Solution().lengthOfLongestSubstring("bbbbb"))
    println(Solution().lengthOfLongestSubstring("pwwkew"))
}