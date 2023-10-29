from utils.python.predef import *

MAX_N = 1 << 30


class Solution:
    def minimumChanges(self, s: str, k: int) -> int:
        return self.dp(s, len(s) - 1, k)

    @functools.cache
    def dp(self, s: str, end: int, k: int) -> int:
        if k == 1:
            return self.count(s, 0, end)
        ans = MAX_N
        for start in range(1, end + 1):
            ans = min(ans, self.dp(s, start - 1, k - 1) + self.count(s, start, end))
        return ans

    @functools.cache
    def count(self, s: str, start: int, end: int):
        s = s[start:end + 1]
        if len(s) == 1:
            return MAX_N
        ret = MAX_N
        for d in range(1, len(s)):
            if not len(s) % d == 0:
                continue
            ans = 0
            for i in range(d):
                cur = s[i::d]
                for j in range(len(cur) // 2):
                    if cur[j] != cur[-(j + 1)]:
                        ans += 1
                if ans >= ret: break
            ret = min(ret, ans)
        return ret


if __name__ == '__main__':
    print(Solution().minimumChanges(s="abcac", k=2))
    print(Solution().minimumChanges(s="abcdef", k=2))
    print(Solution().minimumChanges(s="aabbaa", k=3))
    print(Solution().minimumChanges(s="acba", k=2))  # 2
