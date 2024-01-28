from utils.python.predef import *

pri = 267
mod = 10000000007





class Solution:
    def beautifulIndices(self, s: str, a: str, b: str, k: int) -> List[int]:
        def find(s: str, x: str):
            xha = 0
            rank = 1
            for i in x:
                xha = (xha * pri + ord(i)) % mod
                rank = (rank * pri) % mod

            n = len(x)
            ans = []
            ha = 0
            for i in range(n - 1, len(s)):
                if i == n - 1:
                    for j in range(n):
                        ha = (ha * pri + ord(s[j])) % mod
                else:
                    ha = (ha * pri + ord(s[i]) - rank * ord(s[i - n]) + mod) % mod
                if ha == xha:
                    ans.append(i + 1 - n)
            return ans

        ii = find(s, a)
        jj = find(s, b)
        # print(ii, jj)

        if not ii or not jj:
            return []

        ans = []
        j = 0
        for i in ii:
            while j + 1 < len(jj) and jj[j] < i - k:
                j += 1
            if abs(jj[j] - i) <= k:
                ans.append(i)
        return ans


if __name__ == '__main__':
    print(Solution().beautifulIndices(s="isawsquirrelnearmysquirrelhouseohmy", a="my", b="squirrel", k=15))
    print(Solution().beautifulIndices(s="abcd", a="a", b="a", k=4))
    print(Solution().beautifulIndices(s="bavgoc", a="ba", b="c", k=6))  # [0]
    print(Solution().beautifulIndices("lahhnlwx",
                                      "hhnlw",
                                      "ty",
                                      6))  # []
