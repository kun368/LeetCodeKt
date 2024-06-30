from utils.python.predef import *


def tree_diameter(edges: List[List[int]]) -> int:
    from collections import defaultdict

    tree = defaultdict(list)
    for edge in edges:
        u, v = edge
        tree[u].append(v)
        tree[v].append(u)

    def dfs(node, parent):
        max_distance = 0
        farthest_node = node
        for neighbor in tree[node]:
            if neighbor != parent:
                distance, farthest = dfs(neighbor, node)
                if distance + 1 > max_distance:
                    max_distance = distance + 1
                    farthest_node = farthest
        return max_distance, farthest_node

    _, farthest_node = dfs(0, -1)
    max_distance, _ = dfs(farthest_node, -1)
    return max_distance


class Solution:
    def minimumDiameterAfterMerge(self, edges1: List[List[int]], edges2: List[List[int]]) -> int:
        d1 = tree_diameter(edges1)
        d2 = tree_diameter(edges2)
        return max((d1 + 1) // 2 + (d2 + 1) // 2 + 1, d1, d2)


if __name__ == '__main__':
    print(Solution().minimumDiameterAfterMerge(edges1=[[0, 1], [0, 2], [0, 3]], edges2=[[0, 1]]))
    print(Solution().minimumDiameterAfterMerge(edges1=[[0, 1], [0, 2], [0, 3], [2, 4], [2, 5], [3, 6], [2, 7]],
                                               edges2=[[0, 1], [0, 2], [0, 3], [2, 4], [2, 5], [3, 6], [2, 7]]))
