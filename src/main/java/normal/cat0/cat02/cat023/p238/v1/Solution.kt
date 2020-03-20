package normal.cat0.cat02.cat023.p238.v1

class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val ret = IntArray(nums.size) { 1 }
        for (i in 1 until nums.size) {
            ret[i] = ret[i - 1] * nums[i - 1]
        }
        var mul = 1
        for (i in nums.lastIndex downTo 0) {
            ret[i] *= mul
            mul *= nums[i]
        }
        return ret
    }
}

fun main(args: Array<String>) {
    println(Solution().productExceptSelf(intArrayOf(1, 2, 3, 4)).toList())
}