DIR_4 = ((-1, 0), (1, 0), (0, -1), (0, 1))


class UnionFind:
    def __init__(self, size):
        self.parent = list(range(size))

    def union(self, a, b):
        self.parent[self.find(a)] = self.find(b)

    def find(self, x) -> int:
        if x != self.parent[x]:
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]
