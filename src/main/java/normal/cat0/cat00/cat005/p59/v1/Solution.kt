package normal.cat0.cat00.cat005.p59.v1

class Solution {

    private val DIR = arrayOf(0 to 1, 1 to 0, 0 to -1, -1 to 0)
    private val HAS_VALUE = Int.MIN_VALUE

    fun generateMatrix(n: Int): Array<IntArray> {
        val ret = Array(n) { IntArray(n) { HAS_VALUE } }
        var curDir = 0
        var x = 0
        var y = 0

        fun setNext() {
            var xx = x + DIR[curDir].first
            var yy = y + DIR[curDir].second
            if (xx < 0 || yy < 0 || xx >= n || yy >= n || ret[xx][yy] != HAS_VALUE) {
                curDir = (curDir + 1) % DIR.size
                xx = x + DIR[curDir].first
                yy = y + DIR[curDir].second
            }
            x = xx
            y = yy
        }

        for (i in 1..n * n) {
            ret[x][y] = i
            setNext()
        }
        return ret
    }
}

fun main() {
    println(Solution().generateMatrix(3).map { it.toList() }.toList())
}