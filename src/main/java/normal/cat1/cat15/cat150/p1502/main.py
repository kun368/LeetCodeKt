from utils.python.predef import *


class Solution:
    def canMakeArithmeticProgression(self, arr: List[int]) -> bool:
        arr.sort()
        return len(set(arr[i] - arr[i - 1] for i in range(1, len(arr)) if i > 0)) == 1


if __name__ == '__main__':
    print(Solution().canMakeArithmeticProgression(arr=[3, 5, 1]))
    print(Solution().canMakeArithmeticProgression(arr=[1, 2, 4]))
