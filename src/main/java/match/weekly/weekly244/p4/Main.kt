package match.weekly.weekly244.p4

class Solution {

    private val mod: Long = 1000000007

    fun minWastedSpace(packages: IntArray, boxes: Array<IntArray>): Int {

        return 0
    }
}

fun main(args: Array<String>) {
    println(
        Solution().minWastedSpace(
            intArrayOf(2, 3, 5),
            arrayOf(
                intArrayOf(4, 8),
                intArrayOf(2, 8)
            )
        )
    )
    println(
        Solution().minWastedSpace(
            intArrayOf(2, 3, 5),
            arrayOf(
                intArrayOf(1, 4),
                intArrayOf(2, 3),
                intArrayOf(3, 4)
            )
        )
    )
    println(
        Solution().minWastedSpace(
            intArrayOf(3, 5, 8, 10, 11, 12),
            arrayOf(
                intArrayOf(12),
                intArrayOf(11, 9),
                intArrayOf(10, 5, 14)
            )
        )
    )
}