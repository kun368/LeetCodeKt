package cat0.cat00.cat000.p4.v1

// O(M+N)
class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val all = arrayListOf<Int>()
        var id1 = 0
        var id2 = 0
        while (id1 < nums1.size || id2 < nums2.size) {
            if (id2 >= nums2.size || (id1 < nums1.size && nums1[id1] <= nums2[id2])) {
                all.add(nums1[id1++])
            } else {
                all.add(nums2[id2++])
            }
        }
        return (all[all.size / 2] + all[(all.size - 1) / 2]) / 2.0
    }
}

fun main(args: Array<String>) {
    println(Solution().findMedianSortedArrays(intArrayOf(1, 3), intArrayOf(2)))
    println(Solution().findMedianSortedArrays(intArrayOf(1, 2), intArrayOf(3, 4)))
}