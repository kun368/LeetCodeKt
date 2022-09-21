from utils.python.predef import *


class Solution:
    def canFormArray(self, arr: List[int], pieces: List[List[int]]) -> bool:
        mp = {}
        for i in range(len(pieces)):
            for j in range(len(pieces[i])):
                mp[pieces[i][j]] = (i, j)

        pre = None
        for i in arr:
            if i not in mp:
                return False
            cur = mp[i]
            if pre is None and cur[1] != 0:
                return False
            if pre is not None and (pre[0] != cur[0] or pre[1] + 1 != cur[1]):
                return False
            if cur[1] < len(pieces[cur[0]]) - 1:
                pre = cur
            else:
                pre = None
        return True


if __name__ == '__main__':
    print(Solution().canFormArray(arr=[15, 88], pieces=[[88], [15]]))
    print(Solution().canFormArray(arr=[49, 18, 16], pieces=[[16, 18, 49]]))
    print(Solution().canFormArray(arr=[91, 4, 64, 78], pieces=[[78], [4, 64], [91]]))
    print(Solution().canFormArray(arr=[1, 2, 3], pieces=[[1], [3, 2]]))
