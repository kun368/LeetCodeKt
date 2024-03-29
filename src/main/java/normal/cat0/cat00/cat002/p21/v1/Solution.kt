package normal.cat0.cat00.cat002.p21.v1

import utils.kotlin.ListNode

class Solution {
    fun mergeTwoLists(a: ListNode?, b: ListNode?): ListNode? {
        val head = ListNode(-1)
        var cur = head
        var A = a
        var B = b
        while (A != null || B != null) {
            if (B == null || (A != null && A.`val` < B.`val`)) {
                cur.next = ListNode(A!!.`val`)
                A = A.next
            } else {
                cur.next = ListNode(B.`val`)
                B = B.next
            }
            cur = cur.next!!
        }
        return head.next
    }
}

fun main() {
    println(Solution().mergeTwoLists(ListNode.parse("1->2->4"), ListNode.parse("1->3->4")))
}