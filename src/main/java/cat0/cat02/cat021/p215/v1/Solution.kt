package cat0.cat02.cat021.p215.v1

/**
 * 数组中的第K个最大元素
 */
class Solution {

    private fun IntArray.swap(x: Int, y: Int) {
        val t = this[x]
        this[x] = this[y]
        this[y] = t
    }

    private fun dfs(nums: IntArray, k: Int, st: Int, ed: Int): Int {
        // println("nums = ${nums.toList().subList(st, ed)}, k = $k")
        if (ed - st < 1) {
            return nums[st]
        }
        var pos = st
        for (i in st until ed) if (nums[i] < nums[ed - 1]) nums.swap(pos++, i)
        nums.swap(pos, ed - 1)

        val rlen = ed - pos
        return when {
            k == rlen -> nums[pos]
            k < rlen -> dfs(nums, k, pos + 1, ed)
            else -> dfs(nums, k - rlen, st, pos)
        }
    }

    fun findKthLargest(nums: IntArray, k: Int): Int {
        return dfs(nums, k, 0, nums.size)
    }
}

fun main(args: Array<String>) {
    println(Solution().findKthLargest(intArrayOf(3, 2, 1, 5, 6, 4), 2))
    println(Solution().findKthLargest(intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6), 4))
}