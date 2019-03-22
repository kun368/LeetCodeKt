package cat003.p37.v1

class Solution {

    private fun Int.clear(idx: Int) = this.or(1.shl(idx)).xor(1.shl(idx))
    private fun Int.set(idx: Int) = this.or(1.shl(idx))

    private fun fuckInx(a: Int, b: Int) = (a / 3) * 3 + (b / 3)
    private fun nextInx(a: Int, b: Int) = if (b == 8) a + 1 to 0 else a to b + 1

    fun solveSudoku(board: Array<CharArray>) {
        val rowSet = Array(9) { 1.shl(9) - 1 }
        val colSet = Array(9) { 1.shl(9) - 1 }
        val fuckSet = Array(9) { 1.shl(9) - 1 }
        val arr = Array(9) { CharArray(9) }

        fun mset(i: Int, j: Int, v: Char) {
            arr[i][j] = v
            rowSet[i] = rowSet[i].clear(v - '1')
            colSet[j] = colSet[j].clear(v - '1')
            fuckSet[fuckInx(i, j)] = fuckSet[fuckInx(i, j)].clear(v - '1')
        }

        fun mclear(i: Int, j: Int, v: Char) {
            arr[i][j] = '.'
            rowSet[i] = rowSet[i].set(v - '1')
            colSet[j] = colSet[j].set(v - '1')
            fuckSet[fuckInx(i, j)] = fuckSet[fuckInx(i, j)].set(v - '1')
        }

        for (i in board.indices) {
            for (j in board[i].indices) {
                if (board[i][j] != '.') mset(i, j, board[i][j])
            }
        }

        var solved = false
        fun dfs(a: Int, b: Int) {
            if (solved) {
                return
            }
            if (a == 9) {
                arr.forEachIndexed { x, it -> it.forEachIndexed { y, c -> board[x][y] = c } }
                solved = true
                return
            }
            if (board[a][b] != '.') {
                val n = nextInx(a, b)
                dfs(n.first, n.second)
                return
            }
            val can = rowSet[a].and(colSet[b]).and(fuckSet[fuckInx(a, b)])
            for (i in '1'..'9') {
                if (can.and(1.shl(i - '1')) == 0) {
                    continue
                }
                mset(a, b, i)
                val n = nextInx(a, b)
                dfs(n.first, n.second)
                mclear(a, b, i)
            }
        }
        dfs(0, 0)
    }
}

fun main(args: Array<String>) {
    val arr = arrayOf(
            charArrayOf('5','3','.','.','7','.','.','.','.'),
            charArrayOf('6','.','.','1','9','5','.','.','.'),
            charArrayOf('.','9','8','.','.','.','.','6','.'),
            charArrayOf('8','.','.','.','6','.','.','.','3'),
            charArrayOf('4','.','.','8','.','3','.','.','1'),
            charArrayOf('7','.','.','.','2','.','.','.','6'),
            charArrayOf('.','6','.','.','.','.','2','8','.'),
            charArrayOf('.','.','.','4','1','9','.','.','5'),
            charArrayOf('.','.','.','.','8','.','.','7','9')
    )
    Solution().solveSudoku(arr)
    arr.forEach { println(it.toList()) }
}