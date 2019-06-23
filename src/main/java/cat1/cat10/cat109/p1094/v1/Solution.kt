package cat1.cat10.cat109.p1094.v1

class Solution {
    fun carPooling(trips: Array<IntArray>, capacity: Int): Boolean {
        trips.sortBy { it[1] }
        var cur = 0
        var pre = 0
        val down = IntArray(1024) { 0 }
        for (i in trips) {
            for (j in pre..i[1]) {
                cur -= down[j]
                down[j] = 0
            }
            cur += i[0]
            if (cur > capacity) {
                return false
            }
            down[i[2]] += i[0]
            pre = i[1] + 1
        }
        return true
    }
}

fun main() {
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