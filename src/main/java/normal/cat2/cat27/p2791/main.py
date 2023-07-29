from utils.python.predef import *


class Solution:
    def countPalindromePaths(self, parent: List[int], s: str) -> int:
        graph = defaultdict(list)
        for i in range(1, len(parent)):
            graph[parent[i]].append((i, s[i]))
        collected = Counter()
        ans = 0

        def collect(v):
            nonlocal ans
            if v.bit_count() <= 1:
                ans += 1
            ans += collected.get(v, 0)
            for i in range(26):
                t = v ^ (1 << i)
                ans += collected.get(t, 0)
            collected.update([v])

        def dfs(cur, cnt):
            if cur: collect(cnt)
            if cur not in graph: return
            for sa, sb in graph[cur]:
                dfs(sa, cnt ^ (1 << string.ascii_lowercase.index(sb)))

        dfs(0, 0)
        return ans


if __name__ == '__main__':
    print(Solution().countPalindromePaths(parent=[-1, 0, 0, 1, 1, 2], s="acaabc"))
    print(Solution().countPalindromePaths(parent=[-1, 0, 0, 0, 0], s="aaaaa"))
