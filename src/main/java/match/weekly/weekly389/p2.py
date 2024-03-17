from utils.python.predef import *


class Solution:
    def countSubstrings(self, s: str, c: str) -> int:
        count = 0
        prev_count = 0
        for char in s:
            if char == c:
                count += prev_count + 1
                prev_count += 1
        return count


if __name__ == '__main__':
    print(Solution().countSubstrings(s="abada", c="a"))
    print(Solution().countSubstrings(s="zzz", c="z"))
    print(Solution().countSubstrings(s="abca", c="a"))
