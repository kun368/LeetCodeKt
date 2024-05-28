from utils.python.predef import *


class STNode:
    def __init__(self, l: int, r: int, value: Any = None):
        self.l, self.r = l, r  # 左边界和右边界
        self.value = value  # 节点值(区间值)
        self.left_obstacle = None
        self.right_obstacle = None
        self.left = self.right = None  # 左右儿子
        self.lazy = None  # 用于区间和问题的延迟更新标记

    def __repr__(self):
        return f'({self.l}~{self.r}:{self.value})'


class SegmentTree:  # class模板
    def __init__(self, fr: int, to: int,
                 build_leaf: Callable[[STNode], Any],
                 collect: Callable[[STNode, STNode, STNode], None],
                 lazy_update: Callable[[STNode, Any], None] = None):
        # fr, to 是整个区间的其实和终结，取双闭区间
        assert fr <= to
        # 到达叶时的赋值函数, 向上递归时对左右节点值的收集函数(必须为一个自反函数)
        # build_leaf 是一个函数，用于向线段树内的叶子赋值
        # collect 是一个函数，左区间和右区间的聚合到父区间的方法
        self.build_leaf, self.collect = build_leaf, collect
        self.root = self.__create_tree(fr, to)  # 构建根节点
        # 默认的lazy更新方法
        # lazy_update 延迟更新算法，如果需要实现乘法的区间修改，请手动指定，否则默认取None即可
        self.lazy_update = lazy_update or self.__default_lazy_update

    def __create_tree(self, fr, to) -> STNode:  # 构建[fr, to]的树
        node = STNode(fr, to)
        if fr == to:
            self.build_leaf(node)  # 到达叶节点，构建叶节点
        else:
            mid = (fr + to) >> 1
            # 构建左右子树
            node.left, node.right = self.__create_tree(fr, mid), self.__create_tree(mid + 1, to)
            self.collect(node, node.left, node.right)  # 后序收集区间值
        return node

    def query(self, fr: int, to: int) -> STNode:  # 区间查询 | O(logN)
        def dfs(node, _fr, _to) -> STNode:
            if node.lazy is not None:  # 下传懒惰标记，仅适用于区间和问题
                self.__push_down(node)

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
                    ret = STNode(_fr, _to)
                    ret.left, ret.right = dfs(node.left, _fr, mid), dfs(node.right, mid + 1, _to)
                    self.collect(ret, ret.left, ret.right)
                    return ret

        assert self.root.l <= fr <= to <= self.root.r
        return dfs(self.root, fr, to)

    def update(self, i: int, update_leaf: Callable[[STNode], Any]):  # 单点修改: 把元线段[i, i]的值修改为value
        def dfs(node):
            l, r = node.l, node.r
            if l == i == r:  # 找到对应元线段
                update_leaf(node)
            else:
                mid = (l + r) >> 1
                if i <= mid:  # 在左区间
                    dfs(node.left)
                elif i > mid:  # 在右区间
                    dfs(node.right)
                self.collect(node, node.left, node.right)  # 后序收集区间值

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

        dfs(self.root, fr, to)

    def __push_down(self, node: STNode):
        if node.l != node.r:  # 非元线段
            # 给左右子树下传延迟更新标记并更新其值
            self.lazy_update(node.left, node.lazy)
            self.lazy_update(node.right, node.lazy)
        node.lazy = None  # 元线段不用下传lazy标志, 当前节点的lazy标志可清零

    def __default_lazy_update(self, ch: STNode, lazy: Any):
        meta_size = (ch.r - ch.l + 1)  # (r - l + 1)为此区间的元线段数
        ch.value += meta_size * lazy
        ch.lazy = ch.lazy + lazy if ch.lazy is not None else lazy


class Solution:
    def getResults(self, queries: List[List[int]]) -> List[bool]:
        def collect(root: STNode, ln: STNode, rn: STNode):
            root.left_obstacle = ln.left_obstacle or rn.left_obstacle
            root.right_obstacle = rn.right_obstacle or ln.right_obstacle
            a = ln.right_obstacle or (root.l - 1)
            b = rn.left_obstacle or root.r
            root.value = max(ln.value, rn.value, b - a)

        def build_leaf(root: STNode):
            root.value = 1

        limit = max(q[1] for q in queries)
        st = SegmentTree(
            1, limit,
            build_leaf=build_leaf,
            collect=collect
        )
        ans = []
        for q in queries:
            match q:
                case [1, x]:
                    def update_leaf(node: STNode):
                        node.value = 1
                        node.left_obstacle = node.l
                        node.right_obstacle = node.l

                    st.update(x, update_leaf)
                case [2, x, sz]:
                    cur = st.query(1, x)
                    ans.append(cur.value >= sz)
        return ans


if __name__ == '__main__':
    print(Solution().getResults(queries=[[1, 2], [2, 3, 3], [2, 3, 1], [2, 2, 2]]))
    print(Solution().getResults(queries=[[1, 7], [2, 7, 6], [1, 2], [2, 7, 5], [2, 7, 6]]))
