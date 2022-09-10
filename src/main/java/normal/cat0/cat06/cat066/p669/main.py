from utils.python.predef import *


class Solution:
    def trimBST(self, root: Optional[TreeNode], low: int, high: int) -> Optional[TreeNode]:
        if not root:
            return None
        print(root.val)
        if low <= root.val <= high:
            root.left = self.trimBST(root.left, low, high)
            root.right = self.trimBST(root.right, low, high)
            return root
        if root.val < low:
            return self.trimBST(root.right, low, high)
        if root.val > high:
            return self.trimBST(root.left, low, high)


if __name__ == '__main__':
    print(Solution().trimBST(TreeNode.create("[1,0,2]"), 1, 2))
    print(Solution().trimBST(TreeNode.create("[3,0,4,null,2,null,null,1]"), 1, 3))
