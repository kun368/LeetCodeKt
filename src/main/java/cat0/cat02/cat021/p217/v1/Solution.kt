package cat0.cat02.cat021.p217.v1

class Solution {
    fun containsDuplicate(nums: IntArray): Boolean = nums.groupBy { it }.any { it.value.size > 1 }
}

fun main(args: Array<String>) {
    println(Solution().containsDuplicate(intArrayOf(1, 2, 3, 1)))
    println(Solution().containsDuplicate(intArrayOf(1, 2, 3, 4)))
    println(Solution().containsDuplicate(intArrayOf(1, 1, 1, 3, 3, 4, 3, 2, 4, 2)))
}
