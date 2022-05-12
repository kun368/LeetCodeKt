from typing import *


class Solution:
    def minDeletionSize(self, strs: List[str]) -> int:
        ans = 0
        ha = range(len(strs) - 1)
        for i in range(len(strs[0])):
            for j in ha:
                if strs[j + 1][i] < strs[j][i]:
                    ans += 1
                    break
        return ans


if __name__ == '__main__':
    print(Solution().minDeletionSize(["cba", "daf", "ghi"]))
    print(Solution().minDeletionSize(["a", "b"]))
    print(Solution().minDeletionSize(["zyx", "wvu", "tsr"]))
