from utils.python.predef import *


def build_isp(sz=10240):
    isp = [True] * sz
    isp[0] = isp[1] = False
    for i in range(2, int(sqrt(sz)) + 1):
        if isp[i]:
            for j in range(i * i, sz, i):
                isp[j] = False
    pri = [a for a, b in enumerate(isp) if b]
    return isp, pri


isp, pri = build_isp(300100)
print(pri[:20])


class Solution:
    def maximumPrimeDifference(self, nums: List[int]) -> int:
        l = inf
        ans = 0
        for i in range(len(nums)):
            if isp[nums[i]]:
                l = min(l, i)
                ans = max(ans, i - l)
        return ans


if __name__ == '__main__':
    print(Solution().maximumPrimeDifference(nums=[4, 2, 9, 5, 3]))
    print(Solution().maximumPrimeDifference(nums=[4, 8, 2, 8]))
