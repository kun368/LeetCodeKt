from utils.python.predef import *


class Solution:
    def countPairs(self, nums: List[int]) -> int:

        def calc(vs) -> set[str]:
            ret = set(vs)
            for v in vs:
                n = len(v)
                for x in range(n):
                    for y in range(x + 1, n):
                        cur = list(v)
                        cur[x], cur[y] = cur[y], cur[x]
                        ret.add(str(''.join(cur)))
            return ret

        ans = 0
        counter = Counter()
        nums.sort(key=lambda x: len(str(x)))
        for n in nums:
            for v in calc(calc([(str(n))])):
                ans += counter[int(v)]
            counter[n] += 1
        return ans


if __name__ == '__main__':
    print(Solution().countPairs(nums=[1023, 2310, 2130, 213]))
    print(Solution().countPairs(nums=[1, 10, 100]))
