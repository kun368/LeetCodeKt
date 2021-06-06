package match.weekly.weekly244.p2

class Solution {
    fun reductionOperations(nums: IntArray): Int {
        nums.sortDescending()
        var ans = 0
        for (i in nums.indices) {
            if (i == 0 || nums[i] == nums[i - 1]) continue
            ans += i
        }
        return ans
    }
}

fun main(args: Array<String>) {
    println(Solution().reductionOperations(intArrayOf(5, 1, 3)))
    println(Solution().reductionOperations(intArrayOf(1, 1, 1)))
    println(Solution().reductionOperations(intArrayOf(1, 1, 2, 2, 3)))
}