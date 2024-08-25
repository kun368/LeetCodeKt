from utils.python.predef import *


class Solution:
    def countPairs(self, nums: List[int]) -> int:
        mp = defaultdict(list)
        for i, num in enumerate(nums):
            mp[num].append(i)

        ans = set()
        for idx, v in enumerate(nums):
            n = len(str(v))
            for x in range(n):
                for y in range(x + 1, n):
                    cur = list(str(v))
                    cur[x], cur[y] = cur[y], cur[x]
                    cur = int(''.join(cur))
                    for nidx in mp[cur]:
                        ans.add((idx, nidx))
                        ans.add((nidx, idx))
            for nidx in mp[v]:
                ans.add((idx, nidx))
                ans.add((nidx, idx))

        return (len(ans) - len(nums)) // 2


if __name__ == '__main__':
    print(Solution().countPairs(nums=[3, 12, 30, 17, 21]))
    print(Solution().countPairs(nums=[1, 1, 1, 1, 1]))
    print(Solution().countPairs(nums=[123, 231]))
    print(Solution().countPairs(nums=[5, 12, 8, 5, 5, 1, 20, 3, 10, 10, 5, 5, 5, 5, 1]))  # 27
