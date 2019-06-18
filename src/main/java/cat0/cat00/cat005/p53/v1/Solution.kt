package cat0.cat00.cat005.p53.v1

class Solution {
    fun maxSubArray(nums: IntArray): Int {
        if (nums.size <= 1) {
            return nums.sum()
        }
        var minSum = 0
        var sum = 0
        var best = nums[0]
        for ((i, v) in nums.withIndex()) {
            sum += v
            best = maxOf(best, sum - minSum)
            minSum = minOf(minSum, sum)
        }
        return best
    }
}

fun main(args: Array<String>) {
    println(Solution().maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
    println(Solution().maxSubArray(intArrayOf(-1)))
    println(Solution().maxSubArray(intArrayOf(-2, -1)))
}