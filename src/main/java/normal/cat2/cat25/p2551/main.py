from utils.python.predef import *


class Solution:
    def putMarbles(self, weights: List[int], k: int) -> int:
        if k == 1:
            return 0
        arr = []
        for i in range(len(weights) - 1):
            arr.append(weights[i] + weights[i + 1])
        arr.sort()
        return sum(arr[-(k - 1):]) - sum(arr[:k - 1])


if __name__ == '__main__':
    print(Solution().putMarbles(weights=[1, 3, 5, 1], k=2))
    print(Solution().putMarbles(weights=[1, 3], k=2))
