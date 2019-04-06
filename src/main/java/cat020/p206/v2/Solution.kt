package cat020.p206.v2

import utils.ListNode

class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        var prev: ListNode? = null
        var curr = head
        while (curr != null) {
            val next = curr.next
            curr.next = prev
            prev = curr
            curr = next
        }
        return prev
    }
}

fun main(args: Array<String>) {
    println(Solution().reverseList(ListNode.parse("1->2->3->4->5")))
}