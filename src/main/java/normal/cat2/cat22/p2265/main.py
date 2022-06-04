from utils.python.predef import *


class Ret:
    def __init__(self, sum, cnt, ans):
        self.sum = sum
        self.cnt = cnt
        self.ans = ans

    def __repr__(self):
        return str(self.__dict__)


class Solution:
    def averageOfSubtree(self, root: Optional[TreeNode]) -> int:
        return self.dfs(root).ans

    def dfs(self, root: Optional[TreeNode]) -> Ret:
        if not root:
            return Ret(0, 0, 0)
        ls, rs = self.dfs(root.left), self.dfs(root.right)
        cur_sum, cur_cnt = ls.sum + rs.sum + root.val, ls.cnt + rs.cnt + 1
        cur_ans = ls.ans + rs.ans + (1 if cur_sum // cur_cnt == root.val else 0)
        return Ret(cur_sum, cur_cnt, cur_ans)


if __name__ == '__main__':
    print(Solution().averageOfSubtree(
        TreeNode(
            4,
            TreeNode(8, TreeNode(0), TreeNode(1)),
            TreeNode(5, None, TreeNode(6)),
        )
    ))
