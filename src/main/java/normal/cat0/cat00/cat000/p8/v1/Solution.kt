package normal.cat0.cat00.cat000.p8.v1


class Solution {
    fun myAtoi(str: String): Int {
        val cur = StringBuilder()
        for (it in str.trimStart()) {
            if ((it == '+' || it == '-') && cur.isEmpty()) {
                cur.append(it)
            } else if (it.isDigit()) {
                cur.append(it)
            } else break
        }
        if (!cur.matches("^[+-]?\\d+$".toRegex())) {
            return 0
        }
        val curVal = cur.toString().toBigInteger()
        return when {
            curVal < Int.MIN_VALUE.toBigInteger() -> Int.MIN_VALUE
            curVal > Int.MAX_VALUE.toBigInteger() -> Int.MAX_VALUE
            else -> curVal.toInt()
        }
    }
}

fun main() {
    println(Solution().myAtoi("42"))
    println(Solution().myAtoi("   -42"))
    println(Solution().myAtoi("4193 with words"))
    println(Solution().myAtoi("words and 987"))
    println(Solution().myAtoi("-91283472332"))
}