from utils.python.predef import *


class Solution:
    def minOperations(self, k: int) -> int:
        def check(ops):
            for i in range(ops + 1):
                num = (1 + i) * (ops - i + 1)
                if num >= k:
                    return True
            return False

        return bisect_left(range(k + 10), True, key=check)
