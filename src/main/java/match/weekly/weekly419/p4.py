from utils.python.predef import *


class Solution:
    def findXSum(self, nums: List[int], k: int, x: int) -> List[int]:
        from sortedcontainers import SortedSet

        # (count, value)
        sa_sum = [0]
        counter = Counter()
        sa = SortedSet(key=lambda v: (-counter[v], -v))
        sb = SortedSet(key=lambda v: (-counter[v], -v))

        def change_cnt(v, change):
            if v in sa:
                sa.remove(v)
                sa_sum[0] -= v * counter[v]
            if v in sb:
                sb.remove(v)
            counter[v] += change
            sb.add(v)

        def balance() -> int:
            while len(sa) < x and len(sb) > 0:
                v = sb.pop(0)
                sa.add(v)
                sa_sum[0] += v * counter[v]
            return sa_sum[0]

        n = len(nums)
        ans = []
        for i in range(n - k + 1):
            if i == 0:
                for j in nums[:k]:
                    change_cnt(j, 1)
                ans.append(balance())
            else:
                change_cnt(nums[i + k - 1], 1)
                change_cnt(nums[i - 1], -1)
                if len(sa) > 0:
                    change_cnt(sa[-1], 0)
                ans.append(balance())
        return ans


if __name__ == '__main__':
    print(Solution().findXSum(nums=[1, 1, 2, 2, 3, 4, 2, 3], k=6, x=2))
    print(Solution().findXSum(nums=[3, 8, 7, 8, 7, 5], k=2, x=2))
