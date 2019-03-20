package cat003.p31.v1

import java.util.*

class Solution {
    fun nextPermutation(nums: IntArray) {
        if (nums.size <= 1) {
            return
        }
        if ((1..nums.lastIndex).all { nums[it] <= nums[it - 1] }) {
            nums.reverse()
            return
        }
        val set = TreeMap<Int, Int>()
        for (i in nums.lastIndex downTo 0) {
            set += nums[i] to i
            val bigger = set.higherEntry(nums[i])
            if (bigger != null) {
                nums[bigger.value] = nums[i]
                nums[i] = bigger.key
                nums.sort(i + 1, nums.size)
                break
            }
        }
    }
}

fun main(args: Array<String>) {
    arrayOf(intArrayOf(1, 2, 3),
            intArrayOf(3, 2, 1),
            intArrayOf(1, 1, 5),
            intArrayOf(5, 2, 1, 2)
    ).forEach {
        Solution().nextPermutation(it)
        println(it.toList())
    }
}