from utils.python.predef import *


class Solution:
    def minNumberOfFrogs(self, croakOfFrogs: str) -> int:
        counter = [0] * 5
        for c in croakOfFrogs:
            c = 'croak'.index(c)
            if c == 0:
                if counter[4]:
                    counter[4] -= 1
                counter[0] += 1
            else:
                if not counter[c - 1]:
                    return -1
                counter[c - 1] -= 1
                counter[c] += 1
        if counter[0] or counter[1] or counter[2] or counter[3]:
            return -1
        return counter[4]


if __name__ == '__main__':
    print(Solution().minNumberOfFrogs(croakOfFrogs = "croakcroak"))
    print(Solution().minNumberOfFrogs(croakOfFrogs = "crcoakroak"))
    print(Solution().minNumberOfFrogs(croakOfFrogs = "croakcrook"))
    print(Solution().minNumberOfFrogs(croakOfFrogs = "ccccc"))
