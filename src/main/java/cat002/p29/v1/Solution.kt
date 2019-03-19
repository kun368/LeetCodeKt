package cat002.p29.v1

import kotlin.math.abs

class Solution {

    val L = -(1L.shl(31))
    val R = 1L.shl(31) - 1

    fun divide(dividend: Int, divisor: Int): Int {
        var a = abs(dividend.toLong())
        val b = abs(divisor.toLong())
        var cnt = 0.toLong()
        while (a >= b) {
            cnt += 1
            a -= b
        }
        val ret = if ((dividend >= 0 && divisor >= 0) || (dividend < 0 && divisor < 0)) { cnt } else { -cnt }
        return if (ret < L || ret > R) return R.toInt() else ret.toInt()
    }
}

fun main(args: Array<String>) {
    println(Solution().divide(10, 3))
    println(Solution().divide(7, -3))
}