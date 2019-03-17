package cat000.p9.v1

class Solution {
    fun isPalindrome(x: Int): Boolean {
        return with(x) { toString().reversed() == toString() }
    }
}

fun main(args: Array<String>) {
    println(Solution().isPalindrome(121))
    println(Solution().isPalindrome(-121))
    println(Solution().isPalindrome(10))
}