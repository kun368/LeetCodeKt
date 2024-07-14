from utils.python.predef import *


# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def modifiedList(self, nums: List[int], head: Optional[ListNode]) -> Optional[ListNode]:
        st = set(nums)
        dummy = ListNode(0)
        dummy.next = head

        prev, curr = dummy, head
        while curr:
            if curr.val in st:
                prev.next = curr.next
            else:
                prev = curr
            curr = curr.next
        return dummy.next


if __name__ == '__main__':
    pass
