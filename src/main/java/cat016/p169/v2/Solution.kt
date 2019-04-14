package cat016.p169.v2

class Solution {
    fun majorityElement(nums: IntArray): Int {
        var best = nums[0]
        var count = 1
        for (i in 1 until nums.size) {
            if (nums[i] == best) {
                count += 1
            } else {
                count -= 1
            }
            if (count == 0) {
                best = nums[i]
                count = 1
            }
        }
        return best
    }
}

fun main(args: Array<String>) {
    println(Solution().majorityElement(intArrayOf(3, 2, 3)))
    println(Solution().majorityElement(intArrayOf(2, 2, 1, 1, 1, 2, 2)))
    println(Solution().majorityElement(intArrayOf(2)))
}