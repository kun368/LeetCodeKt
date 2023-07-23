from typing import *

DIR_4 = ((-1, 0), (1, 0), (0, -1), (0, 1))
MOD = 1000000007


class UnionFind:
    def __init__(self, size):
        self.parent = list(range(size))

    def union(self, a, b):
        self.parent[self.find(a)] = self.find(b)

    def find(self, x) -> int:
        if x != self.parent[x]:
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]


def dijkstra(s: int, G: List[List[Tuple]]) -> List[int]:
    import heapq
    d = [float("inf")] * len(G)
    d[s] = 0
    qu = [(0, s)]
    heapq.heapify(qu)
    while qu:
        du, u = heapq.heappop(qu)
        if d[u] < du:
            continue
        for to, cost in G[u]:
            if d[to] > du + cost:
                d[to] = du + cost
                heapq.heappush(qu, (d[to], to))
    return d
