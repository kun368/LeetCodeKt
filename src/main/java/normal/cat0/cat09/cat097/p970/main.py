from utils.python.predef import *


class Solution:
    def powerfulIntegers(self, x: int, y: int, bound: int) -> List[int]:
        s1, s2 = [1], [1]
        while s1[-1] < (n := s1[-1] * x) <= bound:
            s1.append(n)
        while s2[-1] < (n := s2[-1] * y) <= bound:
            s2.append(n)
        return list(set(a + b for a, b in itertools.product(s1, s2) if a + b <= bound))


if __name__ == '__main__':
    print(Solution().powerfulIntegers(x = 2, y = 3, bound = 10))
    print(Solution().powerfulIntegers(x = 3, y = 5, bound = 15))
