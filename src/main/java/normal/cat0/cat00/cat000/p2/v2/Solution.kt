package normal.cat0.cat00.cat000.p2.v2

import utils.kotlin.ListNode

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val head = ListNode(0)
        var cursor: ListNode = head
        var t1 = l1
        var t2 = l2
        var push = 0
        while (t1 != null || t2 != null || push != 0) {
            val val1 = t1?.`val` ?: 0
            val val2 = t2?.`val` ?: 0
            val cur = val1 + val2 + push
            cursor.next = ListNode(cur % 10)
            push = cur / 10
            t1 = t1?.next
            t2 = t2?.next
            cursor = cursor.next!!
        }
        return if (head.next != null) head.next else head
    }
}

fun main(args: Array<String>) {
    val test = Solution()
    val l1 = ListNode(2, ListNode(4, ListNode(3)))
    val l2 = ListNode(5, ListNode(6, ListNode(4)))
    val ret = test.addTwoNumbers(l1, l2)
    print(ret)
}