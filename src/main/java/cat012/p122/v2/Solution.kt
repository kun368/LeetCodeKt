package cat012.p122.v2

class Solution {
    fun maxProfit(prices: IntArray) = prices.mapIndexed { idx, i -> if (idx == 0) 0 else maxOf(0, i - prices[idx - 1]) }.sum()
}


fun main(args: Array<String>) {
    println(Solution().maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
    println(Solution().maxProfit(intArrayOf(1, 2, 3, 4, 5)))
    println(Solution().maxProfit(intArrayOf(7, 6, 4, 3, 1)))
}