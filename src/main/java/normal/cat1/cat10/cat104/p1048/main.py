from utils.python.predef import *


class Solution:
    def longestStrChain(self, words: List[str]) -> int:
        words.sort(key=lambda x: len(x))
        vis = dict()
        for w in words:
            if len(w) == 1:
                vis[w] = 1
                continue
            best = 1
            for i in range(len(w)):
                if (cur := w[:i] + w[i+1:]) in vis:
                    best = max(best, vis[cur] + 1)
            vis[w] = best
        return max(vis.values())


if __name__ == '__main__':
    print(Solution().longestStrChain(
        words=["a", "b", "ba", "bca", "bda", "bdca"]
    ))
    print(Solution().longestStrChain(
        words=["xbc", "pcxbcf", "xb", "cxbc", "pcxbc"]
    ))
    print(Solution().longestStrChain(
        words=["abcd", "dbqca"]
    ))
