from utils.python.predef import *


class STNode:
    def __init__(self, l: int, r: int, value: Any = None):
        self.l, self.r = l, r  # 左边界和右边界
        self.left = self.right = self.father = None  # 左右儿子及父指针
        self.v00 = 0
        self.v01 = 0
        self.v10 = 0
        self.v11 = value  # 节点值(区间值)

    def __repr__(self):
        return f'({self.l}~{self.r}:{self.v11})'


class SegmentTree:  # class模板
    def __init__(self, fr: int, to: int,
                 when_reach_leaf: Callable[[int], Any], collect):
        # fr, to 是整个区间的其实和终结，取双闭区间
        # when_reach_leaf 是一个函数，用于向线段树内的叶子赋值；传入叶子的索引所谓参数，返回一个任意值
        # collect 是一个函数，左区间和右区间的聚合方法；传入左区间和右区间，返回一个任意值作为两区间的聚合结果 | 左右区间应具有自反性
        # lazy_update 延迟更新算法，如果需要实现乘法的区间修改，请手动指定，否则默认取None即可
        assert fr <= to
        # 到达叶时的赋值函数, 向上递归时对左右节点值的收集函数(必须为一个自反函数)
        self.cal, self.collect = when_reach_leaf, collect
        self.root = self.__create_tree(fr, to)  # 构建根节点

    def __create_tree(self, fr, to, parent: STNode = None) -> STNode:  # 构建[fr, to]的树
        node = STNode(fr, to)
        node.father = parent  # 构建一个父指针
        if fr == to:
            node.v11 = self.cal(fr)  # 到达叶节点，根据元线段的值fr构建叶节点
        else:
            mid = (fr + to) >> 1
            # 构建左右子树
            node.left, node.right = self.__create_tree(fr, mid, node), self.__create_tree(mid + 1, to, node)
            self.collect(node, node.left, node.right)  # 后序收集区间值
        return node

    def update(self, i: int, value: Any):  # 单点修改: 把元线段[i, i]的值修改为value
        def dfs(node):
            l, r = node.l, node.r
            if l == i == r:  # 找到对应元线段
                node.v11 = value
            else:
                mid = (l + r) >> 1
                if i <= mid:  # 在左区间
                    dfs(node.left)
                elif i > mid:  # 在右区间
                    dfs(node.right)
                self.collect(node, node.left, node.right)  # 后序收集区间值

        assert self.root.l <= i <= self.root.r
        dfs(self.root)


class Solution:
    def maximumSumSubsequence(self, nums: List[int], queries: List[List[int]]) -> int:
        n = len(nums)

        def collect(pa: STNode, ln: STNode, rn: STNode):
            pa.v11 = max(ln.v10 + rn.v11, ln.v11 + rn.v01)
            pa.v01 = max(ln.v00 + rn.v11, ln.v01 + rn.v01)
            pa.v10 = max(ln.v10 + rn.v10, ln.v11 + rn.v00)
            pa.v00 = max(ln.v00 + rn.v10, ln.v01 + rn.v00)

        st = SegmentTree(0, n - 1, lambda x: max(0, nums[x]), collect=collect)
        ans = 0
        for pos, x in queries:
            st.update(pos, max(0, x))
            ans = (ans + st.root.v11) % 1000000007
        return ans


if __name__ == '__main__':
    print(Solution().maximumSumSubsequence(nums=[3, 5, 9], queries=[[1, -2], [0, -3]]))
    print(Solution().maximumSumSubsequence(nums=[0, -1], queries=[[0, -5]]))
    print(Solution().maximumSumSubsequence(
        nums=[4, 0, -1, -2, 3, 1, -1],
        queries=[[3, 1], [0, -2], [1, -1], [0, -2], [5, 4], [6, -3], [6, -2], [2, -1]]))
