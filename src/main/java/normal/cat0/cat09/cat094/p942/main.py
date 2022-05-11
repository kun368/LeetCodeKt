from typing import *


class Solution:
    def diStringMatch(self, s: str) -> List[int]:
        L, R = 0, len(s)
        ans = []
        for i in s:
            if i == 'I':
                ans.append(L)
                L += 1
            elif i == 'D':
                ans.append(R)
                R -= 1
        ans.append(L)
        return ans


if __name__ == '__main__':
    print(Solution().diStringMatch('IDID'))
    print(Solution().diStringMatch('III'))
    print(Solution().diStringMatch('DDI'))
