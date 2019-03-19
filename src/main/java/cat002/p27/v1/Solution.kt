package cat002.p27.v1

class Solution {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var count = 0
        for (i in nums.indices) {
            if (nums[i] != `val`) {
                nums[count++] = nums[i]
            }
        }
        return count
    }
}

fun main(args: Array<String>) {
    println(Solution().removeElement(intArrayOf(3, 2, 2, 3), 3))
    println(Solution().removeElement(intArrayOf(0, 1, 2, 2, 3, 0, 4, 2), 2))
}