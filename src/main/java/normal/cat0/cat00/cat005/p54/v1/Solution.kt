package normal.cat0.cat00.cat005.p54.v1

class Solution {

    private val DIR = arrayOf(0 to 1, 1 to 0, 0 to -1, -1 to 0)
    private val HAS_VALUE = Int.MIN_VALUE

    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        if (matrix.isEmpty() || matrix[0].isEmpty()) {
            return emptyList()
        }
        val ret = ArrayList<Int>()
        var curDir = 0
        var x = 0
        var y = 0

        fun setNext() {
            var xx = x + DIR[curDir].first
            var yy = y + DIR[curDir].second
            if (xx < 0 || yy < 0 || xx >= matrix.size || yy >= matrix[0].size || matrix[xx][yy] == HAS_VALUE) {
                curDir = (curDir + 1) % DIR.size
                xx = x + DIR[curDir].first
                yy = y + DIR[curDir].second
            }
            x = xx
            y = yy
        }

        while (ret.size < matrix.size * matrix[0].size) {
            ret.add(matrix[x][y])
            matrix[x][y] = HAS_VALUE
            setNext()
        }
        return ret
    }
}

fun main() {
    println(Solution().spiralOrder(arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
    )))

    println(Solution().spiralOrder(arrayOf(
            intArrayOf(1, 2, 3, 4),
            intArrayOf(5, 6, 7, 8),
            intArrayOf(9, 10, 11, 12)
    )))

    println(Solution().spiralOrder(arrayOf(
            intArrayOf(2, 5),
            intArrayOf(8, 4),
            intArrayOf(0, -1)
    )))
}