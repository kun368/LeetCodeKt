from utils.python.predef import *


class Solution:
    def numberOfGoodPartitions(self, nums: List[int]) -> int:
        rc = Counter(nums)
        lc = Counter()
        diffs = len(set(nums))
        ok = 0
        for i in range(len(nums)):
            v = nums[i]
            rc.subtract([v])
            lc.update([v])
            if rc[v] <= 0:
                del rc[v]
            if diffs == len(rc) + len(lc):
                ok += 1
        return pow(2, max(0, ok - 1), 1000000007)


if __name__ == '__main__':
    print(Solution().numberOfGoodPartitions(nums=[1, 2, 3, 4]))
    print(Solution().numberOfGoodPartitions(nums=[1, 1, 1, 1]))
    print(Solution().numberOfGoodPartitions(nums=[1, 2, 1, 3]))
