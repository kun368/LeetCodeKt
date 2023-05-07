from utils.python.predef import *


class Solution:
    def numPairsDivisibleBy60(self, time: List[int]) -> int:
        counter = [0]*60
        for i in time:
            counter[i % 60] += 1
        ans = 0
        ans += counter[0] * (counter[0] - 1) // 2
        ans += counter[30] * (counter[30] - 1) // 2
        for i in range(1, 30):
            ans += counter[i] * counter[60-i]
        return ans


if __name__ == '__main__':
    print(Solution().numPairsDivisibleBy60(time=[30, 20, 150, 100, 40]))
    print(Solution().numPairsDivisibleBy60(time=[60, 60, 60]))
