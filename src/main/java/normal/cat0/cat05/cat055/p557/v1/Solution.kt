package normal.cat0.cat05.cat055.p557.v1

/**
 * 反转字符串中的单词 III
 */
class Solution {
    fun reverseWords(s: String): String = s.split(' ').joinToString(" ") { it.reversed() }
}

fun main(args: Array<String>) {
    println(Solution().reverseWords("Let's take LeetCode contest"))
}