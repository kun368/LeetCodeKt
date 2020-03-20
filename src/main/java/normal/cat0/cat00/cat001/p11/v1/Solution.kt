package normal.cat0.cat00.cat001.p11.v1

import kotlin.math.absoluteValue

/**
 * O(N*log(N))解法
 */
class Solution {
    fun maxArea(height: IntArray): Int {
        val idxs = height.indices.toSortedSet()
        var maxSize = 0
        height.withIndex().sortedBy { it.value } .forEach {
            idxs.remove(it.index)
            if (idxs.isNotEmpty()) {
                val size1 = (idxs.first() - it.index).absoluteValue * it.value
                val size2 = (idxs.last() - it.index).absoluteValue * it.value
                maxSize = maxOf(maxSize, size1, size2)
            }
        }
        return maxSize
    }
}

fun main(args: Array<String>) {
    println(Solution().maxArea(intArrayOf(1,8,6,2,5,4,8,3,7)))
}