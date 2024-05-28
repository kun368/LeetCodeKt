from utils.python.predef import *


class STNode:
    def __init__(self, l: int, r: int, value: Any = None):
        self.l, self.r = l, r  # 左边界和右边界
        self.value = value  # 节点值(区间值)
        self.left_obstacle = None
        self.right_obstacle = None
        self.left = self.right = self.father = None  # 左右儿子及父指针

    def __repr__(self):
        return f'({self.l}~{self.r}:{self.value})'


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
            node.value = self.cal(fr)  # 到达叶节点，根据元线段的值fr构建叶节点
        else:
            mid = (fr + to) >> 1
            # 构建左右子树
            node.left, node.right = self.__create_tree(fr, mid, node), self.__create_tree(mid + 1, to, node)
            self.collect(node, node.left, node.right)  # 后序收集区间值
        return node

    def query(self, fr: int, to: int) -> STNode:  # 区间查询 | O(logN)
        def dfs(node, _fr, _to) -> STNode:
            l, r = node.l, node.r
            if l == _fr and r == _to:  # 找到对应区间
                return node
            else:
                mid = (l + r) >> 1
                if _to <= mid:  # 在左区间
                    return dfs(node.left, _fr, _to)
                elif _fr > mid:  # 在右区间
                    return dfs(node.right, _fr, _to)
                else:  # 跨区间
                    ans = STNode(_fr, _to)
                    ans.left, ans.right = dfs(node.left, _fr, mid), dfs(node.right, mid + 1, _to)
                    self.collect(ans, ans.left, ans.right)
                    return ans

        assert self.root.l <= fr <= to <= self.root.r
        return dfs(self.root, fr, to)

    def update(self, i: int, value: Any):  # 单点修改: 把元线段[i, i]的值修改为value
        def dfs(node):
            l, r = node.l, node.r
            if l == i == r:  # 找到对应元线段
                node.value = value
                node.left_obstacle = i
                node.right_obstacle = i
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
    def getResults(self, queries: List[List[int]]) -> List[bool]:
        def collect(root: STNode, ln: STNode, rn: STNode):
            root.left_obstacle = ln.left_obstacle or rn.left_obstacle
            root.right_obstacle = rn.right_obstacle or ln.right_obstacle
            a = ln.right_obstacle or (root.l - 1)
            b = rn.left_obstacle or root.r
            root.value = max(ln.value, rn.value, b - a)

        limit = max(q[1] for q in queries)
        st = SegmentTree(
            1, limit,
            lambda idx: 1,
            collect=collect
        )
        ans = []
        for q in queries:
            match q:
                case [1, x]:
                    st.update(x, 1)
                case [2, x, sz]:
                    cur = st.query(1, x)
                    ans.append(cur.value >= sz)
        return ans


if __name__ == '__main__':
    print(Solution().getResults(queries=[[1, 2], [2, 3, 3], [2, 3, 1], [2, 2, 2]]))
    print(Solution().getResults(queries=[[1, 7], [2, 7, 6], [1, 2], [2, 7, 5], [2, 7, 6]]))
