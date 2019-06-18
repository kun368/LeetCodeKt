package cat1.cat10.cat107.p1076.v1

class Solution {
    fun numTilePossibilities(tiles: String): Int {
        val set = HashSet<String>()

        fun dfs(cur: String, used: HashSet<Int>) {
            set += cur
            if (cur.length >= tiles.length) {
                return
            }
            tiles.forEachIndexed { i, c ->
                if (i !in used) {
                    used += i
                    dfs(cur + c, used)
                    used -= i
                }
            }
        }

        dfs("", HashSet())
        return set.size - 1
    }
}

fun main() {
    println(Solution().numTilePossibilities("AAB"))
    println(Solution().numTilePossibilities("AAABBC"))
    println(Solution().numTilePossibilities("ABCDEFG"))
}