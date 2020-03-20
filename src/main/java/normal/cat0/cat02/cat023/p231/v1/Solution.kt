package normal.cat0.cat02.cat023.p231.v1

class Solution {
    fun isPowerOfTwo(n: Int): Boolean = n >= 0 && Integer.bitCount(n) == 1
}

fun main(args: Array<String>) {
    println(Integer.toBinaryString(-2147483648))
}