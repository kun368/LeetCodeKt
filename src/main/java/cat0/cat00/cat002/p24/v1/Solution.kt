package cat0.cat00.cat002.p24.v1

import utils.kotlin.ListNode

class Solution {
    fun swapPairs(head: ListNode?): ListNode? {
        val mock = ListNode(-1)
        mock.next = head

        fun dfs(pre: ListNode, a: ListNode?, b: ListNode?) {
            if (a == null || b == null) {
                return
            }
            val next = b.next
            pre.next = b
            b.next = a
            a.next = next
            dfs(a, a.next, a.next?.next)
        }

        dfs(mock, mock.next, mock.next?.next)
        return mock.next
    }
}

fun main(args: Array<String>) {
    println(Solution().swapPairs(ListNode.parse("1->2->3->4")))
}