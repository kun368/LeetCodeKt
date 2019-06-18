package cat0.cat00.cat003.p36.v1

class Solution {

    private fun isValid(arr: CharArray) = arr.filter { a -> a != '.' } .let { it.size == it.toSet().size }

    fun isValidSudoku(board: Array<CharArray>): Boolean {
        if (!board.all { isValid(it) }) {
            return false
        }
        if (!(0 until 9).map { it -> board.map { a -> a[it] }.toCharArray() } .all { isValid(it) }) {
            return false
        }
        val map = HashMap<Int, MutableList<Char>>()
        for (i in board.indices) {
            for (j in board[i].indices) {
                map.getOrPut((i / 3) * 10 + (j / 3)) { arrayListOf() } += board[i][j]
            }
        }
        if (!map.values.all { isValid(it.toCharArray()) }) {
            return false
        }
        return true
    }
}

fun main(args: Array<String>) {
    println(Solution().isValidSudoku(arrayOf(
            charArrayOf('5','3','.','.','7','.','.','.','.'),
            charArrayOf('6','.','.','1','9','5','.','.','.'),
            charArrayOf('.','9','8','.','.','.','.','6','.'),
            charArrayOf('8','.','.','.','6','.','.','.','3'),
            charArrayOf('4','.','.','8','.','3','.','.','1'),
            charArrayOf('7','.','.','.','2','.','.','.','6'),
            charArrayOf('.','6','.','.','.','.','2','8','.'),
            charArrayOf('.','.','.','4','1','9','.','.','5'),
            charArrayOf('.','.','.','.','8','.','.','7','9')
    )))
}