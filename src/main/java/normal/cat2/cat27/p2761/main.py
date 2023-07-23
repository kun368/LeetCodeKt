from utils.python.predef import *


def build_isp(sz=10240):
    isp = [True] * sz
    isp[0] = isp[1] = False
    for i in range(2, int(sqrt(sz)) + 1):
        if isp[i]:
            for j in range(i * i, sz, i):
                isp[j] = False
    return isp


isp = build_isp(1024000)


class Solution:
    def findPrimePairs(self, n: int) -> List[List[int]]:
        ans = []
        for i in range(2, n // 2 + 1):
            if isp[i] and isp[n - i]:
                ans.append([i, n - i])
        return ans


if __name__ == '__main__':
    print(Solution().findPrimePairs(10))
    print(Solution().findPrimePairs(2))
    print(Solution().findPrimePairs(1000000))
