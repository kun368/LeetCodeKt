package cat012.p121.v1

class Solution {
    fun maxProfit(prices: IntArray): Int {
        if (prices.size <= 1) {
            return 0
        }
        var best = 0
        var min = prices.first()
        for (i in 1..prices.lastIndex) {
            best = maxOf(best, prices[i] - min)
            min = minOf(min, prices[i])
        }
        return best
    }
}

fun main(args: Array<String>) {
    println(Solution().maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
    println(Solution().maxProfit(intArrayOf(7, 6, 4, 3, 1)))
}