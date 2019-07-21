package match.weekly146.p4.v1

/**
 * 绝对值表达式的最大值
 */
class Solution {
    fun maxAbsValExpr(arr1: IntArray, arr2: IntArray): Int {
        var ans = 0
        for (type in arrayOf(-1 to -1, -1 to 1, 1 to -1, 1 to 1)) {
            var preMin = Int.MAX_VALUE / 2
            for (i in arr1.indices) {
                val cur = type.first * arr1[i] + type.second * arr2[i] + i
                ans = maxOf(ans, cur - preMin)
                preMin = minOf(preMin, cur)
            }
        }
        return ans
    }
}

fun main(args: Array<String>) {
    println(Solution().maxAbsValExpr(
            intArrayOf(1, 2, 3, 4),
            intArrayOf(-1, 4, 5, 6)
    ))
    println(Solution().maxAbsValExpr(
            intArrayOf(1, -2, -5, 0, 10),
            intArrayOf(0, -2, -1, -7, -4)
    ))
}