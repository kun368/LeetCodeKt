from utils.python.predef import *


class Solution:
    def dfs(self, root: Optional[TreeNode], level, mp):
        if root is None:
            return
        mp[level].append(root.val)
        self.dfs(root.left, level + 1, mp)
        self.dfs(root.right, level + 1, mp)

    def minimumOperations(self, root: Optional[TreeNode]) -> int:
        mp = defaultdict(list)
        self.dfs(root, 0, mp)
        return sum(self.minChange(i) for i in mp.values())

    def minChange(self, ls):
        sorted_ls = sorted(ls)
        idx_mp = {v: i for i, v in enumerate(ls)}
        ans = 0
        for i in range(len(ls)):
            if sorted_ls[i] == ls[i]:
                continue
            ti = idx_mp[sorted_ls[i]]
            ls[i], ls[ti] = ls[ti], ls[i]
            idx_mp[ls[i]] = i
            idx_mp[ls[ti]] = ti
            ans += 1
        return ans


if __name__ == '__main__':
    # Solution().minChange([7, 6, 8, 5])
    print(Solution().minimumOperations(TreeNode.create("[1,4,3,7,6,8,5,null,null,null,null,9,null,10]")))
    print(Solution().minimumOperations(TreeNode.create("[1,3,2,7,6,5,4]")))
    print(Solution().minimumOperations(TreeNode.create("[1,2,3,4,5,6]")))
