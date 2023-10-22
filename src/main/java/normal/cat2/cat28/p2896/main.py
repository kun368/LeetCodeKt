from utils.python.predef import *


class Solution:
    def minOperations(self, s1: str, s2: str, x: int) -> int:
        cur = []
        for i in range(len(s1)):
            if s1[i] != s2[i]:
                cur.append(i)
        if len(cur) % 2 == 1:
            return -1

        cur = tuple(cur)
        qu = [(0, cur)]
        vis = {cur: 0}
        while qu:
            (cost, value) = heappop(qu)
            if not value:
                return cost
            if cost > vis[value]:
                continue

            ops = [
                (cost + x, value[1:-1]),
                (cost + value[1] - value[0], value[2:]),
                (cost + value[-1] - value[-2], value[:-2]),
            ]
            # print(cost, value, ops)
            for cc, vv in ops:
                if cc < vis.get(vv, 1 << 30):
                    heappush(qu, (cc, vv))
                    vis[vv] = cc


if __name__ == '__main__':
    print(Solution().minOperations(s1="1100011000", s2="0101001010", x=2))  # 4
    print(Solution().minOperations(s1="10110", s2="00011", x=4))  # -1
    print(Solution().minOperations(s1="101101", s2="000000", x=6))  # 4
    print(Solution().minOperations(s1="101111110110010100", s2="010001111100000100", x=3))  # 7
