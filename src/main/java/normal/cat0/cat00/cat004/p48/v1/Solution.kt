package normal.cat0.cat00.cat004.p48.v1

class Solution {
    fun rotate(matrix: Array<IntArray>) {
        val sz = matrix.size

        fun swap(x: Int, y: Int) {
            val A = x to y
            val B = y to sz - 1 - x
            val C = sz - 1 - x to sz - 1 - y
            val D = sz - 1 - y to x
            val a = matrix[A.first][A.second]
            val b = matrix[B.first][B.second]
            val c = matrix[C.first][C.second]
            val d = matrix[D.first][D.second]
            matrix[A.first][A.second] = d
            matrix[B.first][B.second] = a
            matrix[C.first][C.second] = b
            matrix[D.first][D.second] = c
        }

        for (i in 0 until sz / 2) {
            for (j in i until sz - i - 1) {
                swap(i, j)
            }
        }
    }
}

fun main() {
    var arr = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
    )
    Solution().rotate(arr)
    println(arr.map { it.toList() }.toList())


    arr = arrayOf(
            intArrayOf(5, 1, 9, 11),
            intArrayOf(2, 4, 8, 10),
            intArrayOf(13, 3, 6, 7),
            intArrayOf(15, 14, 12, 16)
    )
    Solution().rotate(arr)
    println(arr.map { it.toList() }.toList())
}