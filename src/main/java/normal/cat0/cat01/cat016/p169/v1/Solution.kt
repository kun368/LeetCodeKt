package normal.cat0.cat01.cat016.p169.v1

class Solution {
    fun majorityElement(nums: IntArray): Int = nums.sorted()[nums.size / 2]
}

fun main() {
    println(Solution().majorityElement(intArrayOf(3, 2, 3)))
    println(Solution().majorityElement(intArrayOf(2, 2, 1, 1, 1, 2, 2)))
    println(Solution().majorityElement(intArrayOf(2)))
}