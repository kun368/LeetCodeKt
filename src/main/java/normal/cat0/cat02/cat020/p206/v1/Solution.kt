package normal.cat0.cat02.cat020.p206.v1

import utils.kotlin.ListNode

class Solution {

    fun dfs(prev: ListNode, head: ListNode?): ListNode {
        if (head == null) {
            return prev
        }
        val newHead = dfs(head, head.next)
        head.next = prev
        return newHead
    }

    fun reverseList(head: ListNode?): ListNode? {
        if (head == null) {
            return null
        }
        val newHead = dfs(head, head.next)
        head.next = null
        return newHead
    }
}

fun main(args: Array<String>) {
    println(Solution().reverseList(ListNode.parse("1->2->3->4->5")))
}