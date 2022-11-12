package normal.cat0.cat01.cat012.p122.v1

class Solution {
    fun maxProfit(prices: IntArray): Int {
        if (prices.size <= 1) {
            return 0
        }
        var sum = 0
        var min = prices.first()
        var max = prices.first()
        for (i in 1..prices.lastIndex) {
            if (prices[i] < prices[i - 1]) {
                sum += max - min
                min = prices[i]
                max = prices[i]
            } else {
                max = maxOf(max, prices[i])
            }
        }
        sum += max - min
        return sum
    }
}

fun main() {
    println(Solution().maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
    println(Solution().maxProfit(intArrayOf(1, 2, 3, 4, 5)))
    println(Solution().maxProfit(intArrayOf(7, 6, 4, 3, 1)))
}