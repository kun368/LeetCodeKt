package normal.cat0.cat00.cat008.p89.v1

/**
 * 格雷编码
 * 直接用公式
 */
class Solution {
    fun grayCode(n: Int) = (0 until 1.shl(n)).map { it.xor(it.shr(1)) }
}

fun main() {
    println(Solution().grayCode(2))
}