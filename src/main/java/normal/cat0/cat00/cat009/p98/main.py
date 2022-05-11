from typing import *


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

    def __repr__(self):
        return str(self.__dict__)


class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        l = []
        self.dfs(root, l)
        return all(l[i] < l[i + 1] for i in range(len(l) - 1))

    def dfs(self, root, prev):
        if root is None:
            return
        self.dfs(root.left, prev)
        prev.append(root.val)
        self.dfs(root.right, prev)


if __name__ == '__main__':
    print(Solution().isValidBST(
        TreeNode(2, TreeNode(1), TreeNode(3))
    ))
    print(Solution().isValidBST(
        TreeNode(5, TreeNode(1), TreeNode(4, TreeNode(3), TreeNode(6)))
    ))
