from utils.python.predef import *


class Solution:
    def check(self, s: str):
        return s.count(sorted(s)[0])

    def numSmallerByFrequency(self, queries: List[str], words: List[str]) -> List[int]:
        ww = sorted(self.check(w) for w in words)
        ans = []
        for q in queries:
            cur = self.check(q)
            ans.append(len(ww) - bisect_right(ww, cur))
        return ans


if __name__ == '__main__':
    print(Solution().numSmallerByFrequency(queries=["cbd"], words=["zaaaz"]))
    print(Solution().numSmallerByFrequency(queries=["bbb", "cc"], words=["a", "aa", "aaa", "aaaa"]))
