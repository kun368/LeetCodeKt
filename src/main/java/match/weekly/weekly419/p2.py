from utils.python.predef import *


class Solution:
    def kthLargestPerfectSubtree(self, root: Optional[TreeNode], k: int) -> int:
        def dfs(node):
            if not node:
                return 0, 0, True  # (size, height, is_perfect)

            left_size, left_height, left_perfect = dfs(node.left)
            right_size, right_height, right_perfect = dfs(node.right)

            if left_perfect and right_perfect and left_height == right_height:
                size = left_size + right_size + 1
                height = left_height + 1
                perfect_sizes.append(size)
                return size, height, True
            else:
                return 0, max(left_height, right_height), False

        perfect_sizes = []
        dfs(root)
        perfect_sizes = sorted(perfect_sizes, reverse=True)
        return -1 if len(perfect_sizes) < k else perfect_sizes[k - 1]


if __name__ == '__main__':
    print(Solution().kthLargestPerfectSubtree(TreeNode.create(
        "[5,3,6,5,2,5,7,1,8,null,null,6,8]"
    ), k=2))
    print(Solution().kthLargestPerfectSubtree(TreeNode.create(
        "[1,2,3,4,5,6,7]"
    ), k=1))
    print(Solution().kthLargestPerfectSubtree(TreeNode.create(
        "[1,2,3,null,4]"
    ), k=3))
