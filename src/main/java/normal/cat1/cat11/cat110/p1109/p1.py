from utils.python.predef import *


class STNode:
    def __init__(self, l: int, r: int, value: Any = None):
        self.l, self.r = l, r  # 左边界和右边界
        self.value = value  # 节点值(区间值)
        self.left = self.right = self.father = None  # 左右儿子及父指针
        self.lazy = None  # 用于区间和问题的延迟更新标记

    def __repr__(self):
        return f'({self.l}~{self.r}:{self.value})'


class SegmentTree:  # class模板
    def __init__(self, fr: int, to: int,
                 when_reach_leaf: Callable[[int], Any],
                 collect: Callable[[Any, Any], Any],
                 lazy_update: Callable[[STNode, Any], None] = None):
        # fr, to 是整个区间的其实和终结，取双闭区间
        # when_reach_leaf 是一个函数，用于向线段树内的叶子赋值；传入叶子的索引所谓参数，返回一个任意值
        # collect 是一个函数，左区间和右区间的聚合方法；传入左区间和右区间，返回一个任意值作为两区间的聚合结果 | 左右区间应具有自反性
        # lazy_update 延迟更新算法，如果需要实现乘法的区间修改，请手动指定，否则默认取None即可
        assert fr <= to
        # 到达叶时的赋值函数, 向上递归时对左右节点值的收集函数(必须为一个自反函数)
        self.cal, self.collect = when_reach_leaf, collect
        self.root = self.__create_tree(fr, to)  # 构建根节点
        # 默认的lazy更新方法
        self.lazy_update = self.__default_lazy_update if lazy_update is None else lazy_update

    def __create_tree(self, fr, to, parent: STNode = None) -> STNode:  # 构建[fr, to]的树
        node = STNode(fr, to)
        node.father = parent  # 构建一个父指针
        if fr == to:
            node.value = self.cal(fr)  # 到达叶节点，根据元线段的值fr构建叶节点
        else:
            mid = (fr + to) >> 1
            # 构建左右子树
            node.left, node.right = self.__create_tree(fr, mid, node), self.__create_tree(mid + 1, to, node)
            node.value = self.collect(node.left.value, node.right.value)  # 后序收集区间值
        return node

    def query(self, fr: int, to: int):  # 区间查询 | O(logN)
        def dfs(node, _fr, _to) -> Any:
            if node.lazy is not None:  # 下传懒惰标记，仅适用于区间和问题
                self.__push_down(node)

            l, r = node.l, node.r
            if l == _fr and r == _to:  # 找到对应区间
                return node.value
            else:
                mid = (l + r) >> 1
                if _to <= mid:  # 在左区间
                    return dfs(node.left, _fr, _to)
                elif _fr > mid:  # 在右区间
                    return dfs(node.right, _fr, _to)
                else:  # 跨区间
                    return self.collect(dfs(node.left, _fr, mid), dfs(node.right, mid + 1, _to))

        assert self.root.l <= fr <= to <= self.root.r
        return dfs(self.root, fr, to)

    def update(self, i: int, value: Any):  # 单点修改: 把元线段[i, i]的值修改为value
        def dfs(node):
            l, r = node.l, node.r
            if l == i == r:  # 找到对应元线段
                node.value = value
            else:
                mid = (l + r) >> 1
                if i <= mid:  # 在左区间
                    dfs(node.left)
                elif i > mid:  # 在右区间
                    dfs(node.right)
                node.value = self.collect(node.left.value, node.right.value)  # 后序收集区间值

        assert self.root.l <= i <= self.root.r
        dfs(self.root)

    # 加强内容: push_down, 仅适用于区间修改 -- #

    def modify(self, fr: int, to: int, offset: Any):  # 区间修改: 整个区间的每个值都偏移一个幅度 O(logN)
        def dfs(node, _fr, _to):
            l, r = node.l, node.r
            if l == _fr and r == _to:  # 找到对应区间
                self.lazy_update(node, offset)
            else:
                mid = (l + r) >> 1
                if _to <= mid:  # 在左区间
                    dfs(node.left, _fr, _to)
                elif _fr > mid:  # 在右区间
                    dfs(node.right, _fr, _to)
                else:  # 跨区间
                    dfs(node.left, _fr, mid)
                    dfs(node.right, mid + 1, _to)
                self.collect(node.left.value, node.right.value)  # 后序收集区间值

        assert self.collect(3527, 1007) == 3527 + 1007  # 简单判定是否为区间和问题
        dfs(self.root, fr, to)

    def __default_lazy_update(self, ch: STNode, lazy: Any):
        meta_size = (ch.r - ch.l + 1)  # (r - l + 1)为此区间的元线段数
        ch.value += meta_size * lazy
        ch.lazy = ch.lazy + lazy if ch.lazy is not None else lazy

    def __push_down(self, node: STNode):
        if node.l != node.r:  # 非元线段
            # 给左右子树下传延迟更新标记并更新其值
            self.lazy_update(node.left, node.lazy)
            self.lazy_update(node.right, node.lazy)
        node.lazy = None  # 元线段不用下传lazy标志, 当前节点的lazy标志可清零


class Solution:
    def corpFlightBookings(self, bookings: List[List[int]], n: int) -> List[int]:
        st = SegmentTree(
            0, n,
            when_reach_leaf=lambda idx: 0,
            collect=lambda a, b: a + b
        )
        for first, last, seats in bookings:
            st.modify(first, last, seats)

        ans = []
        for i in range(n):
            ans.append(st.query(i + 1, i + 1))
        return ans


if __name__ == '__main__':
    print(Solution().corpFlightBookings(bookings=[[1, 2, 10], [2, 3, 20], [2, 5, 25]], n=5))
    print(Solution().corpFlightBookings(bookings=[[1, 2, 10], [2, 2, 15]], n=2))
