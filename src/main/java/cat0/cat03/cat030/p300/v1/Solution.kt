package cat0.cat03.cat030.p300.v1

import java.util.*

/**
 * 最长上升子序列
 * O(n*logn)实现
 */
class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        val st = TreeSet<Int>()
        var best = 0
        nums.forEach {
            val ceiling = st.ceiling(it)
            if (ceiling != null) {
                st.remove(ceiling)
            }
            st.add(it)
            best = maxOf(best, st.size)
        }
        return best
    }
}

fun main(args: Array<String>) {
    println(Solution().lengthOfLIS(intArrayOf(10, 9, 2, 5, 3, 7, 101, 18)))
}