package cat0.cat03.cat034.p344.v1

class Solution {
    fun reverseString(s: CharArray) {
        for (i in 0 until s.size / 2) {
            val t = s[i]
            s[i] = s[s.size - 1 - i]
            s[s.size - 1 - i] = t
        }
    }
}

fun main(args: Array<String>) {
    val arr = charArrayOf('1', '2', '3', '4')
    Solution().reverseString(arr)
    println(arr.contentToString())
}