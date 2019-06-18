package cat0.cat01.cat013.p136.v1

class Solution {
    fun singleNumber(nums: IntArray): Int = nums.reduce { a, i -> a.xor(i) }
}

fun main(args: Array<String>) {
    println(Solution().singleNumber(intArrayOf(2, 2, 1)))
    println(Solution().singleNumber(intArrayOf(4, 1, 2, 1, 2)))
}