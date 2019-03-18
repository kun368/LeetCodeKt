package cat002.p20.v1

class Solution {
    fun isValid(s: String): Boolean {
        val mp = mapOf('{' to '}', '(' to ')', '[' to ']')
        val stack = arrayListOf<Char>()
        s.forEach {
            when {
                it in mp.keys -> stack += it
                stack.isEmpty() -> return false
                mp[stack.last()] != it -> return false
                else -> stack.removeAt(stack.lastIndex)
            }
        }
        return stack.isEmpty()
    }
}

fun main(args: Array<String>) {
    println(Solution().isValid("()"))
    println(Solution().isValid("()[]{}"))
    println(Solution().isValid("(]"))
    println(Solution().isValid("([)]"))
    println(Solution().isValid("{[]}"))
}