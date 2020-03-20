package normal.cat0.cat00.cat002.p26.v1

class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var count = 0
        for (i in nums.indices) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                nums[count++] = nums[i]
            }
        }
        return count
    }
}

fun main(args: Array<String>) {
    println(Solution().removeDuplicates(intArrayOf(1, 1, 2)))
    println(Solution().removeDuplicates(intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)))
}