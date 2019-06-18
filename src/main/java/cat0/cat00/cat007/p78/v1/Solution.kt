package cat0.cat00.cat007.p78.v1

class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        return (0 until 1.shl(nums.size)).map { i -> nums.filterIndexed { idx, _ -> i.and(1.shl(idx)) != 0 } }
    }
}

fun main(args: Array<String>) {
    println(Solution().subsets(intArrayOf(1, 2, 3)))
}