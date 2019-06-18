package cat0.cat00.cat002.p29.v3

class Solution {

    private val L = -(1L.shl(31))
    private val R = 1L.shl(31) - 1

    fun divide(dividend: Int, divisor: Int): Int {
        var a = dividend.toBigInteger().abs()
        val b = divisor.toBigInteger().abs()
        var ret: Long = 0
        for (i in 36 downTo 0) {
            if (a >= b.shl(i)) {
                a -= b.shl(i)
                ret += 1L.shl(i)
            }
        }
        ret = if ((dividend >= 0 && divisor >= 0) || (dividend < 0 && divisor < 0)) {
            ret
        } else {
            -ret
        }
        return if (ret < L || ret > R) R.toInt() else ret.toInt()
    }
}

fun main(args: Array<String>) {
    println(Solution().divide(10, 3))
    println(Solution().divide(7, -3))
    println(Solution().divide(-2147483648, -1))
}