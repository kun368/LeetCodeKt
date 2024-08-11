from utils.python.predef import *


class Solution:
    def countGoodNodes(self, edges):
        from collections import defaultdict

        n = len(edges) + 1
        tree = defaultdict(list)
        for a, b in edges:
            tree[a].append(b)
            tree[b].append(a)
        subtree_size = [0] * n
        good_nodes = set()

        def dfs(node, parent):
            size = 1
            child_sizes = []
            for neighbor in tree[node]:
                if neighbor != parent:
                    child_size = dfs(neighbor, node)
                    size += child_size
                    child_sizes.append(child_size)
            subtree_size[node] = size
            if not child_sizes or all(x == child_sizes[0] for x in child_sizes):
                good_nodes.add(node)
            return size

        dfs(0, -1)
        return len(good_nodes)


if __name__ == '__main__':
    print(Solution().countGoodNodes(edges=[[0, 1], [0, 2], [1, 3], [1, 4], [2, 5], [2, 6]]))
    print(Solution().countGoodNodes(edges=[[0, 1], [1, 2], [2, 3], [3, 4], [0, 5], [1, 6], [2, 7], [3, 8]]))
    print(Solution().countGoodNodes(
        edges=[[0, 1], [1, 2], [1, 3], [1, 4], [0, 5], [5, 6], [6, 7], [7, 8], [0, 9], [9, 10], [9, 12], [10, 11]]))
