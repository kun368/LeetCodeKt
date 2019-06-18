package cat1.cat10.cat102.p1031.v1

class Solution {
    fun maxSumTwoNoOverlap(A: IntArray, L: Int, M: Int): Int {
        val sum = arrayListOf<Int>()
        A.forEach { sum += if (sum.isEmpty()) it else sum.last() + it }
        fun sumOf(l: Int, r: Int): Int = sum.getOrElse(r - 1) { 0 } - sum.getOrElse(l - 1) { 0 }

        fun fuck(L: Int, M: Int): Int {
            var lsumMax = 0
            var best = 0
            for (i in L..A.size - M) {
                val rsum = sumOf(i, i + M)
                lsumMax = maxOf(lsumMax, sumOf(i - L, i))
                best = maxOf(best, rsum + lsumMax)
            }
            return best
        }
        return maxOf(fuck(L, M), fuck(M, L))
    }
}

fun main() {
    println(Solution().maxSumTwoNoOverlap(intArrayOf(0, 6, 5, 2, 2, 5, 1, 9, 4), 1, 2))
    println(Solution().maxSumTwoNoOverlap(intArrayOf(3, 8, 1, 3, 2, 1, 8, 9, 0), 3, 2))
    println(Solution().maxSumTwoNoOverlap(intArrayOf(2, 1, 5, 6, 0, 9, 5, 0, 3, 8), 4, 3))

}