package cat0.cat00.cat001.p16.v2

import kotlin.math.abs

/**
 * 双指针 O(N^2)
 */
class Solution {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        nums.sort()
        var best = nums[0] + nums[1] + nums[2]
        for (idx in nums.indices) {
            val v = nums[idx]
            var l = idx + 1
            var r = nums.lastIndex
            while (l < r) {
                val curSum = v + nums[l] + nums[r]
                if (abs(target - curSum) < abs(target - best)) {
                    best = curSum
                }
                if (curSum < target) ++l else --r
            }
        }
        return best
    }
}

fun main(args: Array<String>) {
    println(Solution().threeSumClosest(intArrayOf(-1, 2, 1, -4), 1))
    println(Solution().threeSumClosest(intArrayOf(1, 1, 1, 1), 4))
    println(Solution().threeSumClosest(intArrayOf(0, 1, 2), 0))
    println(Solution().threeSumClosest(intArrayOf(1, 1, 1, 0), -100))
}