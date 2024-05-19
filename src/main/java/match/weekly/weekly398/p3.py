from utils.python.predef import *


class Solution:
    def sumDigitDifferences(self, nums: List[int]) -> int:
        t = defaultdict(list)
        for i in nums:
            for idx, v in enumerate(str(i)):
                t[idx].append(int(v))

        ans = 0
        for i in t.values():
            cur = Counter(i).values()
            for a, b in combinations(cur, 2):
                ans += a * b
        return ans


if __name__ == '__main__':
    print(Solution().sumDigitDifferences(nums=[13, 23, 12]))
    print(Solution().sumDigitDifferences(nums=[10, 10, 10, 10]))
