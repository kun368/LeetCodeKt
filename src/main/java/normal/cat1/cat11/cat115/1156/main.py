from utils.python.predef import *


class Solution:
    def maxRepOpt1(self, text: str) -> int:
        mp = defaultdict(list)
        for i, v in enumerate(text):
            if not mp[v] or mp[v][-1][1] != i:
                mp[v].append((i, i + 1))
            else:
                mp[v][-1] = (mp[v][-1][0], i + 1)

        ans = 0
        l = lambda t: t[1] - t[0]
        for hits in mp.values():
            for h in hits:
                ans = max(ans, l(h) + (1 if len(hits) >= 2 else 0))
            for j in range(len(hits) - 1):
                if hits[j][1] + 1 == hits[j + 1][0]:
                    ans = max(ans, l(hits[j]) + l(hits[j + 1]) + (1 if len(hits) >= 3 else 0))
        return ans


if __name__ == '__main__':
    print(Solution().maxRepOpt1(text="ababa"))
    print(Solution().maxRepOpt1(text="aaabaaa"))
    print(Solution().maxRepOpt1(text="aaabbaaa"))
    print(Solution().maxRepOpt1(text="aaaaa"))
    print(Solution().maxRepOpt1(text="abcdef"))
