from utils.python.predef import *


class Solution:
    def maximumHappinessSum(self, happiness: List[int], k: int) -> int:
        happiness.sort(reverse=True)
        ans = 0
        for i in range(k):
            ans += max(0, happiness[i] - i)
        return ans


if __name__ == '__main__':
    print(Solution().maximumHappinessSum(happiness=[1, 2, 3], k=2))
    print(Solution().maximumHappinessSum(happiness=[1, 1, 1, 1], k=2))
    print(Solution().maximumHappinessSum(happiness=[2, 3, 4, 5], k=1))
