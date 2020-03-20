package normal.cat1.cat10.cat109.p1094.v2

class Solution {
    fun carPooling(trips: Array<IntArray>, capacity: Int): Boolean {
        IntArray(1024) { 0 }
                .apply { trips.forEach { this[it[1]] += it[0]; this[it[2]] -= it[0] } }
                .reduce { acc, i -> if (acc + i > capacity) return false else acc + i }
        return true
    }
}

fun main(args: Array<String>) {
    println(Solution().carPooling(arrayOf(
            intArrayOf(2, 1, 5),
            intArrayOf(3, 3, 7)
    ), 4))
    println(Solution().carPooling(arrayOf(
            intArrayOf(2, 1, 5),
            intArrayOf(3, 3, 7)
    ), 5))
    println(Solution().carPooling(arrayOf(
            intArrayOf(2, 1, 5),
            intArrayOf(3, 5, 7)
    ), 3))
    println(Solution().carPooling(arrayOf(
            intArrayOf(3, 2, 7),
            intArrayOf(3, 7, 9),
            intArrayOf(8, 3, 9)
    ), 11))
}