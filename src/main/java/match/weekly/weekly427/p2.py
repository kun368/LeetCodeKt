from utils.python.predef import *


class Solution:
    def maxRectangleArea(self, points: List[List[int]]) -> int:
        pp = defaultdict(set)
        for x, y in points:
            pp[x].add(y)

        def have_middle(left, right, bottom, top):
            for x, y in points:
                if (x, y) in ((left, bottom), (left, top), (right, bottom), (right, top)):
                    continue
                if left <= x <= right and bottom <= y <= top:
                    return True
            return False

        ans = -1
        xs = list(sorted(pp.keys()))
        for i in range(len(xs) - 1):
            for j in range(i + 1, len(xs)):
                ys = sorted(pp[xs[i]] & pp[xs[j]])
                for y1, y2 in itertools.combinations(ys, 2):
                    # ic(xs[i], xs[j], y1, y2)
                    if not have_middle(xs[i], xs[j], y1, y2):
                        ans = max(ans, (y2 - y1) * (xs[j] - xs[i]))
        return ans


if __name__ == '__main__':
    print(Solution().maxRectangleArea(points=[[1, 1], [1, 3], [3, 1], [3, 3]]))
    print(Solution().maxRectangleArea(points=[[1, 1], [1, 3], [3, 1], [3, 3], [2, 2]]))
    print(Solution().maxRectangleArea(points=[[1, 1], [1, 3], [3, 1], [3, 3], [1, 2], [3, 2]]))
