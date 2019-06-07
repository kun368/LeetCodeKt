package cat008.p89.v1

/**
 * 格雷编码
 * 直接用公式
 */
class Solution {
    fun grayCode(n: Int) = (0 until 1.shl(n)).map { it.xor(it.shr(1)) }
}

fun main(args: Array<String>) {
    println(Solution().grayCode(2))
}