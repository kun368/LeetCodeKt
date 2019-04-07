package cat006.p61.v1

import utils.ListNode

class Solution {
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        if (head == null || k == 0) {
            return head
        }

        var last: ListNode? = null
        fun dfs(pre: ListNode, cur: ListNode?): Int {
            if (cur == null) {
                last = pre
                return 0
            }
            val dep = dfs(cur, cur.next) + 1
            if (dep == k) {
                pre.next = null
            }
            return dep
        }

        val mock = ListNode(-1)
        mock.next = head
        dfs(mock, mock.next)
        last!!.next = mock.next
        return mock.next
    }
}


// TODO solve
fun main(args: Array<String>) {
    println(Solution().rotateRight(ListNode.parse("1->2->3->4->5"), 2))
    println(Solution().rotateRight(ListNode.parse("0->1->2"), 4))
}