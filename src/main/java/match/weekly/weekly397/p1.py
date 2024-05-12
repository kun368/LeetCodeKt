from utils.python.predef import *


class Solution:
    def findPermutationDifference(self, s: str, t: str) -> int:
        a = dict()
        for idx, v in enumerate(s):
            a[v] = idx

        ans = 0
        for idx, v in enumerate(t):
            ans += abs(idx - a[v])
        return ans


if __name__ == '__main__':
    print(Solution().findPermutationDifference(s="abc", t="bac"))
    print(Solution().findPermutationDifference(s="abcde", t="edbac"))
