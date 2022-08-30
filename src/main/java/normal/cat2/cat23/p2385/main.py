from utils.python.predef import *


class Solution:
    def amountOfTime(self, root: Optional[TreeNode], start: int) -> int:
        next = defaultdict(list)
        self.dfs_next(root, next)

        infected = {start}
        cur_loop, next_loop = infected, set()
        minutes = 0
        while len(infected) < len(next):
            for i in list(cur_loop):
                for j in next[i]:
                    if j in infected:
                        continue
                    next_loop.add(j)
                    infected.add(j)
            minutes += 1
            cur_loop, next_loop = next_loop, set()
        return minutes

    def dfs_next(self, root: TreeNode, next: DefaultDict[int, list]):
        if not root:
            return
        if root.left:
            next[root.val].append(root.left.val)
            next[root.left.val].append(root.val)
        if root.right:
            next[root.val].append(root.right.val)
            next[root.right.val].append(root.val)
        self.dfs_next(root.left, next)
        self.dfs_next(root.right, next)


if __name__ == '__main__':
    print(Solution().amountOfTime(TreeNode.create('[1,5,3,null,4,10,6,9,2]'), 3))
    print(Solution().amountOfTime(TreeNode.create('[1]'), 1))
