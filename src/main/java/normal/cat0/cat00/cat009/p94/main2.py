from typing import *


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        ans = []
        qu = [root]
        while qu:
            cur = qu.pop()
            if cur is None:
                continue
            if isinstance(cur, int):
                ans.append(cur)
            else:
                qu.append(cur.right)
                qu.append(cur.val)
                qu.append(cur.left)
        return ans


if __name__ == '__main__':
    root = TreeNode(1, None, TreeNode(2, TreeNode(3), None))
    print(Solution().inorderTraversal(root))
