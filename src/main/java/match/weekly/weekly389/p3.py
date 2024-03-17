from utils.python.predef import *


class Solution:
    def minimumDeletions(self, word: str, k: int) -> int:
        counter = sorted(list(Counter(word).values()))
        acc = list(accumulate(counter)) + [0]
        tot = acc[-2]

        ans = 1 << 50
        for i in range(len(counter)):
            r = bisect_left(counter, counter[i] + k + 1)
            a = acc[i - 1]
            b = tot - acc[r - 1] - (len(counter) - r) * (counter[i] + k)
            ans = min(ans, a + b)
        return ans


if __name__ == '__main__':
    print(Solution().minimumDeletions(word="aabcaba", k=0))
    print(Solution().minimumDeletions(word="dabdcbdcdcd", k=2))
    print(Solution().minimumDeletions(word="aaabaaa", k=2))
