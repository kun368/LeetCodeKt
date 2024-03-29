package normal.cat0.cat00.cat000.p9.v1

class Solution {
    fun isPalindrome(x: Int): Boolean {
        return with(x) { toString().reversed() == toString() }
    }
}

fun main() {
    println(Solution().isPalindrome(121))
    println(Solution().isPalindrome(-121))
    println(Solution().isPalindrome(10))
}