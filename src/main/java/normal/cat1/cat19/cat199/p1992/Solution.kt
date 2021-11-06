package normal.cat1.cat19.cat199.p1992

class Solution {

    fun findOne(land: Array<IntArray>, x: Int, y: Int): Pair<Int, Int> {
        var szx = 0
        var szy = 0
        for (i in x until land.size) {
            if (land[i][y] == 1) szx += 1
            else break
        }
        for (j in y until land[0].size) {
            if (land[x][j] == 1) szy += 1
            else break
        }
        for (i in x until (x + szx)) {
            for (j in y until (y + szy))
                land[i][j] = -1
        }
        return Pair(x + szx - 1, y + szy - 1)
    }

    fun findFarmland(land: Array<IntArray>): Array<IntArray> {
        val N = land.size
        val M = land[0].size
        val ret = arrayListOf<IntArray>()

        for (i in 0 until N) {
            for (j in 0 until M) {
                if (land[i][j] != 1)
                    continue
                val one = findOne(land, i, j)
                ret.add(intArrayOf(i, j, one.first, one.second))
            }
        }
        return ret.toTypedArray()
    }
}

fun main() {

}
