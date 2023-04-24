from utils.python.predef import *


class Solution:
    def supplyWagon(self, supplies: List[int]) -> List[int]:
        N = len(supplies) // 2
        while len(supplies) > N:
            pos, s = None, None
            for i in range(len(supplies) - 1):
                cur = supplies[i] + supplies[i + 1]
                if s is None or cur < s:
                    s = cur
                    pos = i
            supplies[pos] = s
            del supplies[pos + 1]
        return supplies
