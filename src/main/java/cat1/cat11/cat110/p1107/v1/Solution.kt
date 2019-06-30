package cat1.cat11.cat110.p1107.v1

class Solution {
    fun parseBoolExpr(exp: String): Boolean {
        if ('(' !in exp) {
            return 't' in exp
        }
        val sub = exp.substring(2, exp.length - 1)
        val arr = ArrayList<String>()
        var i = 0
        while (i < sub.length) {
            if (sub[i] !in arrayOf('!', '&', '|')) {
                arr += sub.substring(i, i + 1)
                i += 2
            } else {
                var end = sub.length - 1
                for (j in i until sub.length) {
                    val c = sub[j]
                    if (c == ')' && sub.substring(i, j + 1).count { it == '(' } == sub.substring(i, j + 1).count { it == ')' }) {
                        end = j
                        break
                    }
                }
                arr += sub.substring(i, end + 1)
                i = end + 2
            }
        }
        val res = arr.map { parseBoolExpr(it) }
        return when {
            exp[0] == '&' -> return res.all { it }
            exp[0] == '|' -> return res.any { it }
            exp[0] == '!' -> return !res.all { it }
            else -> false
        }
    }
}

fun main() {
    println(Solution().parseBoolExpr("!(f)"))
    println(Solution().parseBoolExpr("|(f,t)"))
    println(Solution().parseBoolExpr("&(t,f)"))
    println(Solution().parseBoolExpr("|(&(t,f,t),!(t))"))
    println(Solution().parseBoolExpr("t"))
    println(Solution().parseBoolExpr("f"))
    println(Solution().parseBoolExpr("!(&(!(t),&(f),|(f)))"))

}