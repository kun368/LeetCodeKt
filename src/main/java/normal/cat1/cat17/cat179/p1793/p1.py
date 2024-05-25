from utils.python.predef import *

class Solution:
    def maximumScore(self, nums: List[int], k: int) -> int:
        from sortedcontainers import SortedList
        mp = defaultdict(list)
        for idx, v in enumerate(nums):
            mp[v].append(idx)

        ha = SortedList([-1, len(nums)])
        ans = 0
        for v in sorted(mp.keys()):
            for idx in mp[v]:
                cur = ha.bisect_left(idx)
                a, b = ha[cur - 1], ha[cur]
                if a < k < b:
                    cur_ans = (b - a - 1) * v
                    ans = max(ans, cur_ans)
            for idx in mp[v]:
                ha.add(idx)
        return ans


if __name__ == '__main__':
    print(Solution().maximumScore(nums=[1, 4, 3, 7, 4, 5], k=3))
    print(Solution().maximumScore(nums=[5, 5, 4, 5, 4, 1, 1, 1], k=0))
