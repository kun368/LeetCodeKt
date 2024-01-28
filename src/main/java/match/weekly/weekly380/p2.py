from utils.python.predef import *


class Solution:
    def beautifulIndices(self, s: str, a: str, b: str, k: int) -> List[int]:
        def find(s: str, x: str):
            n = len(x)
            ans = []
            for i in range(n - 1, len(s)):
                if s[i + 1 - n:i + 1] == x:
                    ans.append(i + 1 - n)
            return ans

        ii = find(s, a)
        jj = find(s, b)
        # print(ii, jj)

        ans = []
        for i in ii:
            idx = bisect_left(jj, i)
            ok = False
            for j in range(max(0, idx - 3), min(len(jj), idx + 3)):
                if abs(jj[j] - i) <= k:
                    ok = True
                    break
            if ok:
                ans.append(i)
        return ans


if __name__ == '__main__':
    print(Solution().beautifulIndices(s="isawsquirrelnearmysquirrelhouseohmy", a="my", b="squirrel", k=15))
    print(Solution().beautifulIndices(s="abcd", a="a", b="a", k=4))
    print(Solution().beautifulIndices(s="bavgoc", a="ba", b="c", k=6))  # [0]
