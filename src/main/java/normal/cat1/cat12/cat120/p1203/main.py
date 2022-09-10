from utils.python.predef import *


class Solution:
    def sortItems(self, n: int, m: int, group: List[int], beforeItems: List[List[int]]) -> List[int]:
        group_dict = defaultdict(list)
        for i in range(len(group)):
            if group[i] == -1:
                group[i] = m
                m += 1
            group_dict[group[i]].append(i)

        G_n = [[] for i in range(n)]
        G_m = [[] for i in range(m)]
        in_n, in_m = [0] * n, [0] * m
        for i, bef in enumerate(beforeItems):
            for j in bef:
                if group[i] == group[j]:
                    G_n[j].append(i)
                    in_n[i] += 1
                else:
                    G_m[group[j]].append(group[i])
                    in_m[group[i]] += 1

        ans_m = []
        qu = deque()
        for i in range(m):
            if in_m[i] == 0:
                qu.append(i)
        while qu:
            top = qu.popleft()
            ans_m.append(top)
            for i in G_m[top]:
                in_m[i] -= 1
                if in_m[i] == 0:
                    qu.append(i)

        ans_n = []
        for t in ans_m:
            qu.clear()
            for i in group_dict[t]:
                if in_n[i] == 0:
                    qu.append(i)
            while qu:
                top = qu.popleft()
                ans_n.append(top)
                for i in G_n[top]:
                    in_n[i] -= 1
                    if in_n[i] == 0:
                        qu.append(i)
        return ans_n if len(ans_n) == n else []


if __name__ == '__main__':
    print(Solution().sortItems(n=8, m=2, group=[-1, -1, 1, 0, 0, 1, 0, -1],
                               beforeItems=[[], [6], [5], [6], [3, 6], [], [], []]))
    print(Solution().sortItems(n=8, m=2, group=[-1, -1, 1, 0, 0, 1, 0, -1],
                               beforeItems=[[], [6], [5], [6], [3], [], [4], []]))
    print(Solution().sortItems(n=5, m=5, group=[2, 0, -1, 3, 0],
                               beforeItems=[[2, 1, 3], [2, 4], [], [], []]))  # [3,2,4,1,0]
