package cat001.p16.v1

import java.util.*
import kotlin.math.absoluteValue

/**
 * O(N^2 * log(N))暴力
 */
class Solution {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        val set = TreeSet<Int>()
        var ret = nums.slice(0..2).sum()

        fun update(a: Int, b: Int, c: Int) {
            val sum = a + b + c
            if ((target - sum).absoluteValue < (target - ret).absoluteValue) {
                ret = sum
            }
        }

        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                val find = target - nums[i] - nums[j]
                set.floor(find)?.apply { update(nums[i], nums[j], this) }
                set.ceiling(find)?.apply { update(nums[i], nums[j], this) }
            }
            set += nums[i]
        }

        return ret
    }
}

fun main(args: Array<String>) {
    println(Solution().threeSumClosest(intArrayOf(-1, 2, 1, -4), 1))
    println(Solution().threeSumClosest(intArrayOf(1, 1, 1, 1), 4))
}