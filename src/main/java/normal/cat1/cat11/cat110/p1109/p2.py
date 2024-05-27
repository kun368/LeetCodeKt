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
    def corpFlightBookings(self, bookings: List[List[int]], n: int) -> List[int]:
        tree = BinIndexTree([0] * n)
        for first, last, seats in bookings:
            tree.modify(first - 1, last - 1, seats)
        return [tree.query(i, i) for i in range(n)]


if __name__ == '__main__':
    print(Solution().corpFlightBookings(bookings=[[1, 2, 10], [2, 3, 20], [2, 5, 25]], n=5))
    print(Solution().corpFlightBookings(bookings=[[1, 2, 10], [2, 2, 15]], n=2))
