package match.weekly146.p3

class Solution {
    fun mctFromLeafValues(arr: IntArray): Int {
        val ansMap = HashMap<String, Pair<Int, Int>>()
        fun dfs(L: Int, R: Int): Pair<Int, Int> {
            val key = "$L#$R"
            if (key in ansMap) {
                return ansMap[key]!!
            }
            var ans = Int.MAX_VALUE to 0
            if (R - L == 1) {
                ans = 0 to arr[L]
            } else {
                for (i in (L + 1) until R) {
                    val lans = dfs(L, i)
                    val rans = dfs(i, R)
                    val cur = lans.first + rans.first + (lans.second * rans.second)
                    if (cur < ans.first) {
                        ans = cur to maxOf(lans.second, rans.second)
                    }
                }
            }
            // println("L = $L, R = ${R-1}, ans = $ans")
            ansMap[key] = ans
            return ans
        }
        return dfs(0, arr.size).first
    }
}

fun main(args: Array<String>) {
    println(Solution().mctFromLeafValues(intArrayOf(6, 2, 4)))
//    println(Solution().mctFromLeafValues(intArrayOf(2, 4, 6, 8, 10)))
}