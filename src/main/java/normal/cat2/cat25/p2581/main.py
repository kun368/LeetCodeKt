from utils.python.predef import *


class Solution:
    def rootCount(self, edges: List[List[int]], guesses: List[List[int]], k: int) -> int:
        g = defaultdict(list)
        for x, y in edges:
            g[x].append(y)
            g[y].append(x)

        guesses = set((x, y) for x, y in guesses)
        mp = dict()

        def dfs1(pa, cur):
            ans = 0
            for son in g[cur]:
                if son != pa:
                    ans += dfs1(cur, son) + (1 if (cur, son) in guesses else 0)
            mp[cur] = ans
            return ans

        dfs1(-1, 0)

        ok = set()
        st = mp[0]

        def dfs2(pa, cur, a, b):
            if st - a + b >= k:
                ok.add(cur)
            for son in g[cur]:
                if son != pa:
                    na = a + (1 if (cur, son) in guesses else 0)
                    nb = b + (1 if (son, cur) in guesses else 0)
                    dfs2(cur, son, na, nb)

        dfs2(-1, 0, 0, 0)
        return len(ok)


if __name__ == '__main__':
    print(Solution().rootCount(edges=[[0, 1], [1, 2], [1, 3], [4, 2]], guesses=[[1, 3], [0, 1], [1, 0], [2, 4]], k=3))
    print(Solution().rootCount(edges=[[0, 1], [1, 2], [2, 3], [3, 4]], guesses=[[1, 0], [3, 4], [2, 1], [3, 2]], k=1))
