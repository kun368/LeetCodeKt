from utils.python.predef import *


class Solution:
    def sufficientSubset(self, root: Optional[TreeNode], limit: int) -> Optional[TreeNode]:
        def dfs(root: Optional[TreeNode], sum):
            if root is None: return True
            if not root.left and not root.right:
                return sum + root.val < limit
            elif root.left and root.right:
                if lr := dfs(root.left, sum + root.val): root.left = None
                if rr := dfs(root.right, sum + root.val): root.right = None
                return lr and rr
            elif root.left:
                return dfs(root.left, sum + root.val)
            elif root.right:
                return dfs(root.right, sum + root.val)

        return None if dfs(root, 0) else root


if __name__ == '__main__':
    print(Solution().sufficientSubset(
        root=TreeNode.create('[1,2,3,4,-99,-99,7,8,9,-99,-99,12,13,-99,14]'),
        limit=1
    ))
    print(Solution().sufficientSubset(
        root=TreeNode.create('[5,4,8,11,null,17,4,7,1,null,null,5,3]'),
        limit=22
    ))
    print(Solution().sufficientSubset(
        root=TreeNode.create('[1,2,3,4,-99,-99,7,8,9,-99,-99,12,13,-99,14]'),
        limit=1
    ))
    print(Solution().sufficientSubset(
        root=TreeNode.create('[1,2,-3,-5,null,4,null]'),
        limit=-1
    ))
