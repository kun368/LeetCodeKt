from utils.python.predef import *


class Solution:
    def minWindow(self, s: str, t: str) -> str:
        target = Counter(t)
        cnt = Counter()
        l = 0
        match = 0
        ans = ""
        for i, c in enumerate(s):
            cnt[c] += 1
            if c in target and cnt[c] == target[c]:
                match += 1
            while l < i and (s[l] not in target or cnt[s[l]] > target[s[l]]):
                cnt[s[l]] -= 1
                l += 1
            if match == len(target):
                if ans == "" or (i + 1 - l) < len(ans):
                    ans = s[l:i + 1]
        return ans


if __name__ == '__main__':
    print(Solution().minWindow(s="ADOBECODEBANC", t="ABC"))
    print(Solution().minWindow(s="a", t="a"))
    print(Solution().minWindow(s="a", t="aa"))
