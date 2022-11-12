package match.weekly.weekly256.p1

class Solution {
    fun minimumDifference(nums: IntArray, k: Int): Int =
        nums.sort().let { (k..nums.size).map { nums[it - 1] - nums[it - k] }.min() }
}

fun main() {
    println(Solution().minimumDifference(intArrayOf(90), 1))
    println(Solution().minimumDifference(intArrayOf(9, 4, 1, 7), 2))
}
