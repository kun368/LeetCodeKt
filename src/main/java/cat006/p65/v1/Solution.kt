package cat006.p65.v1

class Solution {
    fun isNumber(s: String): Boolean {
        return s.trim().toBigDecimalOrNull() != null
    }
}

fun main(args: Array<String>) {
    println(Solution().isNumber("0"))
    println(Solution().isNumber(" 0.1"))
    println(Solution().isNumber("abc"))
    println(Solution().isNumber("1a"))
    println(Solution().isNumber("2e10"))
    println(Solution().isNumber("e100"))
    println(Solution().isNumber("1e10"))
    println(Solution().isNumber(".1"))
    println(Solution().isNumber("1.1.1"))
    println(Solution().isNumber("."))
    println(Solution().isNumber("+.8"))
    println(Solution().isNumber("959440.94f"))
}