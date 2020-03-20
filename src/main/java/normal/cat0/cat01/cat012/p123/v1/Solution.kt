package normal.cat0.cat01.cat012.p123.v1

/**
 * O(N)
 * 将最优解分为两个区间的最优解之和
 * 以左区间为例：dp[i] = max(dp[i-1], 当天卖出最大获利)
 */
class Solution {
    fun maxProfit(prices: IntArray): Int {
        if (prices.isEmpty()) {
            return 0
        }
        val ldp = Array(prices.size) { 0 }
        val rdp = Array(prices.size) { 0 }
        var min = prices.first()
        for (i in 1..prices.lastIndex) {
            val cur = prices[i] - min
            ldp[i] = maxOf(ldp[i - 1], cur)
            min = minOf(min, prices[i])
        }
        var max = prices.last()
        for (i in prices.lastIndex - 1 downTo 0) {
            val cur = max - prices[i]
            rdp[i] = maxOf(rdp[i + 1], cur)
            max = maxOf(max, prices[i])
        }
        var best = 0
        for (i in 0..prices.lastIndex) {
            best = maxOf(best, ldp[i] + rdp.getOrElse(i + 1) { 0 })
        }
        return best
    }
}


fun main(args: Array<String>) {
    println(Solution().maxProfit(intArrayOf(3, 3, 5, 0, 0, 3, 1, 4)))
    println(Solution().maxProfit(intArrayOf(1, 2, 3, 4, 5)))
    println(Solution().maxProfit(intArrayOf(7, 6, 4, 3, 1)))
    println(Solution().maxProfit(intArrayOf(100)))
}