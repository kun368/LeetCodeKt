from utils.python.predef import *


class Solution:
    def maxBottlesDrunk(self, numBottles: int, numExchange: int) -> int:
        full_b, empty_b = numBottles, 0
        ans = 0
        while True:
            if full_b:
                ans += full_b
                empty_b += full_b
                full_b = 0
            elif empty_b >= numExchange:
                empty_b -= numExchange
                full_b += 1
                numExchange += 1
            else:
                break
        return ans
