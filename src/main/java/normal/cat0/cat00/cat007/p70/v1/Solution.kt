package normal.cat0.cat00.cat007.p70.v1

class Solution {
    fun climbStairs(n: Int): Int {
        if (n == 1) return 1
        if (n == 2) return 2
        var x = 1
        var y = 2
        for (i in 1..n - 2) {
            val cur = x + y
            x = y
            y = cur
        }
        return y
    }
}

fun main() {
    for (i in 1..90) {
        println(Solution().climbStairs(i).toString() + ",")
    }
}
