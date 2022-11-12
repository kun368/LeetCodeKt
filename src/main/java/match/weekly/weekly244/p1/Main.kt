package match.weekly.weekly244.p1

class Solution {

    fun change(mat: Array<IntArray>): Array<IntArray> {
        val n = mat.size
        val ret = Array(n) { IntArray(n) { 0 } }
        for (i in 0 until n) {
            for (j in 0 until n) {
                val ti = n - j - 1
                val tj = i
                ret[ti][tj] = mat[i][j]
            }
        }
        return ret
    }

    fun findRotation(mat: Array<IntArray>, target: Array<IntArray>): Boolean {
        var cur = mat
        for (i in 0..4) {
            if (cur.contentDeepToString() == target.contentDeepToString()) return true
            cur = change(cur)
        }
        return false
    }
}

fun main() {
    println(
        Solution().findRotation(
            arrayOf(
                intArrayOf(0, 0, 0),
                intArrayOf(0, 1, 0),
                intArrayOf(1, 1, 1)
            ), arrayOf(
                intArrayOf(1, 1, 1),
                intArrayOf(0, 1, 0),
                intArrayOf(0, 0, 0)
            )
        )
    )
}
