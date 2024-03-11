from utils.python.predef import *


class Solution:
    def minimumBoxes(self, apple: List[int], capacity: List[int]) -> int:
        s = sum(apple)
        capacity.sort(reverse=True)
        for i in range(len(capacity)):
            s -= capacity[i]
            if s <= 0:
                return i + 1
        return -1


if __name__ == '__main__':
    print(Solution().minimumBoxes(apple=[1, 3, 2], capacity=[4, 3, 1, 5, 2]))
    print(Solution().minimumBoxes(apple=[5, 5, 5], capacity=[2, 4, 2, 7]))
