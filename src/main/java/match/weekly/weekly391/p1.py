from utils.python.predef import *


class Solution:
    def sumOfTheDigitsOfHarshadNumber(self, x: int) -> int:
        t = sum(int(i) for i in str(x))
        return t if x % t == 0 else -1