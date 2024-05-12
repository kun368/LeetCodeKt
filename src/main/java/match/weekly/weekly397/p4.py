import itertools

from utils.python.predef import *


class Solution:
    def findPermutation(self, nums: List[int]) -> List[int]:
        n = len(nums)
        used = [False] * n
        perm = [0]
        used[0] = True

        ans = inf
        ret = None

        def backtrack(s):
            nonlocal ans, perm, used, ret
            if len(perm) == n:
                cur_s = s + abs(perm[-1] - nums[0])
                if cur_s < ans:
                    ans = cur_s
                    ret = list(perm)
            for i in range(n):
                if not used[i]:
                    cur_s = s + abs(perm[-1] - nums[i])
                    if cur_s >= ans:
                        continue
                    perm.append(i)
                    used[i] = True
                    backtrack(cur_s)
                    perm.pop()
                    used[i] = False

        backtrack(0)
        return ret


if __name__ == '__main__':
    print(Solution().findPermutation(nums=[1, 0, 2]))
    print(Solution().findPermutation(nums=[0, 2, 1]))
