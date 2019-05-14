package cat104.p1041.v1

class Solution {

    private val DIR = arrayOf(0 to 1, -1 to 0, 0 to -1, 1 to 0)

    fun isRobotBounded(s: String): Boolean {
        var x = 0
        var y = 0
        var dir = 0
        for (it in 0 until 4) {
            s.forEach {
                when (it) {
                    'L' -> dir = (dir + 1) % 4
                    'R' -> dir = (dir + 3) % 4
                    'G' -> {
                        x += DIR[dir].first
                        y += DIR[dir].second
                    }
                }
            }
        }
        return x == 0 && y == 0
    }
}

fun main(args: Array<String>) {
    println(Solution().isRobotBounded("GGLLGG"))
    println(Solution().isRobotBounded("GG"))
    println(Solution().isRobotBounded("GL"))
}