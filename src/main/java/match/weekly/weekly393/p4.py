from utils.python.predef import *


class SegmentTreeNode:
    def __init__(self, start, end, max_value):
        self.start = start
        self.end = end
        self.max_value = max_value
        self.left = None
        self.right = None


class SegmentTree:
    def __init__(self, nums):
        self.root = self.build_tree(nums, 0, len(nums) - 1)

    def build_tree(self, nums, start, end):
        if start > end:
            return None
        node = SegmentTreeNode(start, end, nums[start])
        if start == end:
            return node
        mid = (start + end) // 2
        node.left = self.build_tree(nums, start, mid)
        node.right = self.build_tree(nums, mid + 1, end)
        node.max_value = min(node.left.max_value, node.right.max_value)
        return node

    def query(self, node, start, end):
        if start > node.end or end < node.start:
            return float('inf')
        if start <= node.start and end >= node.end:
            return node.max_value
        return min(self.query(node.left, start, end), self.query(node.right, start, end))

    def update(self, node, index, value):
        if node.start == node.end:
            node.max_value = value
            return
        mid = (node.start + node.end) // 2
        if index <= mid:
            self.update(node.left, index, value)
        else:
            self.update(node.right, index, value)
        node.max_value = min(node.left.max_value, node.right.max_value)

    def query_range(self, start, end):
        return self.query(self.root, start, end)

    def update_value(self, index, value):
        self.update(self.root, index, value)


class Solution:
    def minimumValueSum(self, nums: List[int], andValues: List[int]) -> int:
        n, m = len(nums), len(andValues)
        seg_def = [float('inf') for _ in range(n + 10)]
        trees = [SegmentTree(seg_def) for _ in range(m + 2)]

        zeros = [-1 for _ in range(32)]
        for i in range(n):
            for j in range(1, m + 1):
                if j > i + 1:
                    trees[j].update_value(i, float('inf'))
                    continue
                cur_head = nums[i]
                cur_and = andValues[j - 1]

                l, r = 0, i
                for b in range(32):
                    if not (cur_head & (1 << b)):
                        zeros[b] = max(zeros[b], i)
                    if cur_and & (1 << b):
                        l = max(l, zeros[b] + 1)
                    else:
                        r = min(r, zeros[b])

                if r < l:
                    trees[j].update_value(i, float('inf'))
                else:
                    cur_ans = (trees[j - 1].query_range(l - 1, r - 1) + nums[i]) if j > 1 else nums[i]
                    trees[j].update_value(i, cur_ans)

        ans = trees[m].query_range(n - 1, n - 1)
        return -1 if ans >= inf else ans


if __name__ == '__main__':
    print(Solution().minimumValueSum(nums=[1, 4, 3, 3, 2], andValues=[0, 3, 3, 2]))
    print(Solution().minimumValueSum(nums=[2, 3, 5, 7, 7, 7, 5], andValues=[0, 7, 5]))
    print(Solution().minimumValueSum(nums=[1, 2, 3, 4], andValues=[2]))
