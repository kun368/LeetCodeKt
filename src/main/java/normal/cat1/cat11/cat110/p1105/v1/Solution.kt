package normal.cat1.cat11.cat110.p1105.v1

class Solution {
    fun minHeightShelves(books: Array<IntArray>, shelf_width: Int): Int {
        val dp = Array(books.size) { Int.MAX_VALUE / 2 }
        dp[0] = books[0][1]
        for (i in 1 until books.size) {
            var kuan = 0
            var maxh = 0
            for (j in i downTo 0) {
                kuan += books[j][0]
                if (kuan > shelf_width) {
                    break
                }
                maxh = maxOf(maxh, books[j][1])
                dp[i] = minOf(dp[i], dp.getOrElse(j - 1) { 0 } + maxh)
            }
        }
        return dp.last()
    }
}

fun main() {
    println(Solution().minHeightShelves(arrayOf(
            intArrayOf(1, 1),
            intArrayOf(2, 3),
            intArrayOf(2, 3),
            intArrayOf(1, 1),
            intArrayOf(1, 1),
            intArrayOf(1, 1),
            intArrayOf(1, 2)
    ), 4))
    println(Solution().minHeightShelves(arrayOf(
            intArrayOf(1, 1)
    ), 1))
}