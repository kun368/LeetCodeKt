package normal.cat1.cat19.cat199.p1991

class Solution {
    fun findMiddleIndex(nums: IntArray): Int {
        val sum = nums.sum()
        var left = 0
        for (i in nums.indices) {
            if (left == sum - left - nums[i]) {
                return i
            }
            left += nums[i]
        }
        return -1
    }
}

fun main() {
    println(Solution().findMiddleIndex(intArrayOf(2, 3, -1, 8, 4)))
    println(Solution().findMiddleIndex(intArrayOf(1, -1, 4)))
    println(Solution().findMiddleIndex(intArrayOf(2, 5)))
    println(Solution().findMiddleIndex(intArrayOf(1)))
}
