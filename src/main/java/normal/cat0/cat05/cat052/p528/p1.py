from utils.python.predef import *


class Solution:
    def __init__(self, w: List[int]):
        self.x = list(accumulate(w))

    def pickIndex(self) -> int:
        return bisect_right(self.x, random.randint(0, self.x[-1] - 1))


if __name__ == '__main__':
    # obj = Solution([3, 1, 4, 1, 5, 9, 2, 6])
    obj = Solution([1, 1, 1, 1, 0, 1, 10])
    print(Counter(obj.pickIndex() for i in range(10000)))
