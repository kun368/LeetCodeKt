package cat004.p43.v1

typealias FuckInt = List<Int>

class Solution {

    private fun FuckInt.fmul(t: Int): FuckInt {
        val ret = arrayListOf<Int>()
        var push = 0
        for (i in this.indices) {
            val cur = push + this[i] * t
            ret.add(cur % 10)
            push = cur / 10
        }
        if (push > 0) ret.add(push)
        return ret
    }

    private fun FuckInt.fadd(t: FuckInt): FuckInt {
        val ret = arrayListOf<Int>()
        var push = 0
        for (i in 0..maxOf(this.lastIndex, t.lastIndex)) {
            val cur = push + this.getOrElse(i) { 0 } + t.getOrElse(i) { 0 }
            ret.add(cur % 10)
            push = cur / 10
        }
        if (push > 0) ret.add(push)
        return ret
    }

    private fun FuckInt.trim(): List<Int> {
        val ret = ArrayList(this)
        while (ret.size > 1 && ret.last() == 0) {
            ret.removeAt(ret.lastIndex)
        }
        return ret
    }

    fun multiply(num1: String, num2: String): String {
        val t1 = num1.map { it - '0' }.reversed()
        var sum = listOf(0)
        num2.map { it - '0' }.reversed().forEachIndexed { idx, it ->
            val base = Array(idx) { 0 }.toMutableList()
            base.addAll(t1.fmul(it))
            sum = sum.fadd(base)
        }
        return sum.trim().reversed().joinToString(separator = "")
    }
}

fun main(args: Array<String>) {
    println(Solution().multiply("2", "3"))
    println(Solution().multiply("123", "456"))
    println(Solution().multiply("0", "0"))
    println(Solution().multiply("0", "2"))
    println(Solution().multiply("5", "0"))
    println(Solution().multiply("1", "1"))
    println(Solution().multiply("9133", "0"))
}