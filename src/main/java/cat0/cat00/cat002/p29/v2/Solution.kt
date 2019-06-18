package cat0.cat00.cat002.p29.v2

class Solution {

    val L = -(1L.shl(31))
    val R = 1L.shl(31) - 1

    fun divide(dividend: Int, divisor: Int): Int {
        return dividend.toLong().div(divisor).let {
            if (it < L || it > R) return R.toInt() else it.toInt()
        }
    }
}