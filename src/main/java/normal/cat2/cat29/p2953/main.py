from utils.python.predef import *


class Solution:
    def countCompleteSubstrings(self, word: str, k: int) -> int:
        subs = []
        cur = 0
        for i in range(1, len(word)):
            if abs(ord(word[i]) - ord(word[i - 1])) > 2:
                subs.append(word[cur:i])
                cur = i
        subs.append(word[cur:])
        return sum(self.check(i, k) for i in subs)

    def check(self, s: str, k: int):
        ans = 0
        for i in range(1, len(set(s)) + 1):
            cur_len = k * i
            if cur_len > len(s):
                break
            counter = Counter()
            for r in range(cur_len - 1, len(s)):
                if r == cur_len - 1:
                    counter.update(s[:r + 1])
                else:
                    counter.update(s[r])
                    counter.subtract(s[r - cur_len])
                if all(c == 0 or c == k for c in counter.values()):
                    ans += 1
        return ans
