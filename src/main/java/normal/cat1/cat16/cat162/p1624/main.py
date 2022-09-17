from utils.python.predef import *


class Solution:
    def maxLengthBetweenEqualCharacters(self, s: str) -> int:
        p = defaultdict(list)
        for i in range(len(s)):
            p[s[i]].append(i)
        ans = -1
        for vs in p.values():
            if len(vs) >= 2:
                ans = max(ans, vs[-1] - vs[0] - 1)
        return ans


if __name__ == '__main__':
    print(Solution().maxLengthBetweenEqualCharacters(s="aa"))
    print(Solution().maxLengthBetweenEqualCharacters(s="abca"))
    print(Solution().maxLengthBetweenEqualCharacters(s="cbzxy"))
    print(Solution().maxLengthBetweenEqualCharacters(s="cabbac"))
