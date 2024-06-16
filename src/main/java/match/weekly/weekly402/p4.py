from utils.python.predef import *


class BinIndexTree:
    def __init__(self, data: List, need_build=True):  # 由于建树开销较大，在需要动态建树时将need_build置为False
        self.n = len(data)
        self.c = [0] * (self.n + 1)  # 此时维护的是一个差分数组:data[i] = sum(c[1:i])
        self.cp = [0] * (self.n + 1)  # 差分数组:(1*c[1] + 2*c[2] + ... + n*c[n])
        if need_build:
            self.__build([0] + data)

    def update(self, i: int, value: Any):  # 单点修改: 将某点的值设为value | O(logN)
        self.modify(i, i, value - self.query(i, i))

    def modify(self, i: int, j: int, offset: Any):  # 区间修改: 整个区间的每个值都偏移一个幅度 O(logN)
        self.__modify(i, offset)
        self.__modify(j + 1, -offset)

    def query(self, i: int, j: int):  # 区间查询 | O(logN)
        return self.__query(j) - self.__query(i - 1)

    def __build(self, data: List):
        for i in range(1, len(data)):  # O(NlogN)
            self.__modify(i - 1, data[i] - data[i - 1])

    def __low_bit(self, x: int):
        return x & (-x)  # => n & (~n + 1), 只留下二进制码中最右侧的1

    def __query(self, i: int):  # 核心API：求data[0~i]的和(闭区间)
        i += 1  # 统一API
        res = 0
        x = i + 1
        while i > 0:
            res += x * self.c[i] - self.cp[i]  # ☆ 仅能用于求区间合
            i -= self.__low_bit(i)
        return res

    def __modify(self, i: int, diff: Any):  # 核心API：差分修改
        i += 1  # 统一API: 由于树状数组中索引必须从1起，因此对应原数组索引从0起，此处要+1
        d_diff = i * diff
        while i <= self.n:
            self.c[i] += diff
            self.cp[i] += d_diff  # ☆ 仅能用于求区间合
            i += self.__low_bit(i)  # 修改其父级


class Solution:
    def countOfPeaks(self, nums: List[int], queries: List[List[int]]) -> List[int]:
        n = len(nums)

        def check(i):
            if i == 0 or i == n - 1:
                return 0
            return 1 if nums[i] > nums[i - 1] and nums[i] > nums[i + 1] else 0

        arr = [check(i) for i in range(n)]
        tree = BinIndexTree(arr)

        ans = []
        for a, b, c in queries:
            # ic([tree.query(i, i) for i in range(n)])
            if a == 1:
                if c - 1 >= b + 1:
                    ans.append(tree.query(b + 1, c - 1))
                else:
                    ans.append(0)
            else:
                nums[b] = c
                for i in range(max(0, b - 1), min(n, b + 2), 1):
                    tree.update(i, check(i))
        return ans


if __name__ == '__main__':
    print(Solution().countOfPeaks(nums=[3, 1, 4, 2, 5], queries=[[2, 3, 4], [1, 0, 4]]))
    print(Solution().countOfPeaks(nums=[4, 1, 4, 2, 1, 5], queries=[[2, 2, 4], [1, 0, 2], [1, 0, 4]]))
    print(Solution().countOfPeaks(nums=[3, 6, 9], queries=[[1, 1, 1], [1, 2, 2], [2, 2, 3]]))
