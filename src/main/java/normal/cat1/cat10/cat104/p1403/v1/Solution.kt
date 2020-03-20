package normal.cat1.cat10.cat104.p1403.v1

/**
 * 分隔数组以得到最大和
 */
class Solution {
    fun maxSumAfterPartitioning(A: IntArray, K: Int): Int {
        val dp = Array(A.size) { 0 }
        for (i in A.indices) {
            var curMax = 0
            for (j in 1..minOf(K, i + 1)) {
                curMax = maxOf(curMax, A[i - j + 1])
                dp[i] = maxOf(dp[i], dp.getOrElse(i - j) { 0 } + curMax * j)
            }
        }
        return dp.last()
    }
}

fun main(args: Array<String>) {
    println(Solution().maxSumAfterPartitioning(intArrayOf(1, 15, 7, 9, 2, 5, 10), 3)) //84
}