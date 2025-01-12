from utils.python.predef import *


class Solution:
    def minMaxWeight(self, n: int, edges: List[List[int]], threshold: int) -> int:
        def check(max_weight):
            visited = set()
            reverse_graph = defaultdict(list)
            for A, B, W in edges:
                if W <= max_weight:
                    reverse_graph[B].append(A)

            def dfs(node):
                visited.add(node)
                for neighbor in reverse_graph[node]:
                    if neighbor not in visited:
                        dfs(neighbor)

            dfs(0)
            return len(visited) == n

        rr = max(i[2] for i in edges) + 10
        best = 1 + bisect_left(range(1, rr), True, key=check)
        return -1 if best >= rr else best


if __name__ == '__main__':
    print(Solution().minMaxWeight(n=5,
                                  edges=[[1, 0, 1], [2, 0, 2], [3, 0, 1], [4, 3, 1], [2, 1, 1]],
                                  threshold=2))
    print(Solution().minMaxWeight(n=5,
                                  edges=[[0, 1, 1], [0, 2, 2], [0, 3, 1], [0, 4, 1], [1, 2, 1], [1, 4, 1]],
                                  threshold=1))
    print(Solution().minMaxWeight(n=5,
                                  edges=[[1, 2, 1], [1, 3, 3], [1, 4, 5], [2, 3, 2], [3, 4, 2], [4, 0, 1]],
                                  threshold=1))
    print(Solution().minMaxWeight(n=5,
                                  edges=[[1, 2, 1], [1, 3, 3], [1, 4, 5], [2, 3, 2], [4, 0, 1]],
                                  threshold=1))
    print(Solution().minMaxWeight(n=2,
                                  edges=[[1, 0, 4]],
                                  threshold=1))  # 4
