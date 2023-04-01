from utils.python.predef import *


class Solution:
    def repairCars(self, ranks: List[int], cars: int) -> int:
        def check(x):
            t = 0
            for r in ranks:
                t += int(sqrt(x / r))
            return t >= cars

        upper = cars * cars * min(ranks) + 10
        return bisect.bisect_left(range(upper), 1, key=check)


if __name__ == '__main__':
    print(Solution().repairCars(ranks=[4, 2, 3, 1], cars=10))
    print(Solution().repairCars(ranks=[5, 1, 8], cars=6))
