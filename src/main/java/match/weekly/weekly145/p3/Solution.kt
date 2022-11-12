package match.weekly.weekly145.p3

class Solution {
    fun longestWPI(hours: IntArray): Int {
        val arr = IntArray(hours.size + 1) { 0 }
        var sum = 0
        for (i in hours.indices) {
            sum += if (hours[i] > 8) 1 else -1
            arr[i + 1] = sum
        }
        // println(arr.toList())
        var best = 0
        for (i in 1 until arr.size) {
            for (j in 1..i) {
                if (arr[i] - arr[j - 1] > 0) {
                    best = maxOf(best, i - j + 1)
                }
            }
        }
        return best
    }
}

fun main() {
    println(Solution().longestWPI(intArrayOf(9, 9, 6, 0, 6, 6, 9)))
    println(Solution().longestWPI(intArrayOf(1)))
    println(Solution().longestWPI(intArrayOf(9)))
}