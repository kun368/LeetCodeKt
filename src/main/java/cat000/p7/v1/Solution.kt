package cat000.p7.v1

import kotlin.math.sign

// 一行搞定🤭
class Solution {
    fun reverse(x: Int): Int {
        return (x.toLong().times(x.sign).toString().reversed().toLong() * x.sign).run { if (toLong() in -2147483648..2147483647) toInt() else 0 }
    }
}

fun main(args: Array<String>) {
    println(Solution().reverse(123))
    println(Solution().reverse(-123))
    println(Solution().reverse(120))
    println(Solution().reverse(0))
    println(Solution().reverse(1534236469))
}