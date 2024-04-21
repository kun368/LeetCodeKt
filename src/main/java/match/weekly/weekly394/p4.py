from utils.python.predef import *


def dijkstra(s: int, G: List[List[Tuple]]):
    import heapq
    d = [float("inf")] * len(G)
    pre = [list() for _ in range(len(G))]

    d[s] = 0
    qu = [(0, s)]
    heapq.heapify(qu)
    while qu:
        du, u = heapq.heappop(qu)
        if d[u] < du:
            continue
        for to, cost in G[u]:
            if d[to] >= du + cost:
                if d[to] > du + cost:
                    d[to] = du + cost
                    heapq.heappush(qu, (d[to], to))
                    pre[to] = [u]
                else:
                    pre[to].append(u)

    vis = set()
    # for i in range(len(G)):
    #     print(i, d[i], pre[i])

    @cache
    def dfs(cur):
        for to in pre[cur]:
            vis.add((cur, to))
            dfs(to)
        return -1

    dfs(len(G) - 1)
    return vis


class Solution:
    def findAnswer(self, n: int, edges: List[List[int]]) -> List[bool]:
        G: List[List[Tuple]] = [list() for i in range(n)]
        for a, b, w in edges:
            G[a].append((b, w))
            G[b].append((a, w))

        ans = []
        vis = dijkstra(0, G)
        for a, b, w in edges:
            if (a, b) in vis or (b, a) in vis:
                ans.append(True)
            else:
                ans.append(False)
        return ans


if __name__ == '__main__':
    print(Solution().findAnswer(n=6, edges=[[0, 1, 4], [0, 2, 1], [1, 3, 2], [1, 4, 3], [1, 5, 1], [2, 3, 1], [3, 5, 3],
                                            [4, 5, 2]]))
    print(Solution().findAnswer(n=4, edges=[[2, 0, 1], [0, 1, 1], [0, 3, 4], [3, 2, 2]]))
    print(Solution().findAnswer(n=4, edges=[[2, 0, 1]]))
