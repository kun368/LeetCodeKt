from utils.python.predef import *


class Solution:
    def lengthAfterTransformations(self, s: str, t: int) -> int:
        MOD = int(10 ** 9 + 7)
        counter = [0] * 26
        for c in s:
            counter[ord(c) - 97] += 1

        for i in range(t):
            next_counter = [0] * 26
            for c in range(26):
                if c == 25:
                    next_counter[0] += counter[c]
                    next_counter[1] += counter[c]
                else:
                    next_counter[c + 1] += counter[c]
            counter = next_counter
        return sum(counter) % MOD


if __name__ == '__main__':
    print(Solution().lengthAfterTransformations(s="abcyy", t=2))
    print(Solution().lengthAfterTransformations(s="azbk", t=1))
    print(Solution().lengthAfterTransformations(s="jqktcurgdvlibczdsvnsg", t=7517))  # 79033769
