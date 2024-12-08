from utils.python.predef import *


class Solution:
    def maxRectangleArea(self, xCoord: List[int], yCoord: List[int]) -> int:
        from sortedcontainers import SortedList
        point_lst = sorted(zip(xCoord, yCoord))
        pre_cnt = {}

        ans = -1
        x_map = defaultdict(list)
        y_map = defaultdict(list)
        ys = SortedList()
        for x, y in point_lst:
            x_map[x].append(y)
            y_map[y].append(x)
            pre_cnt[(x, y)] = ys.bisect_right(y) + 1
            ys.add(y)

        for x, y in point_lst:
            arr = x_map[x]
            idx = bisect_left(arr, y)
            if idx + 1 < len(arr):
                next_y = arr[idx + 1]
            else:
                continue

            arr = y_map[y]
            idx = bisect_left(arr, x)
            if idx + 1 < len(arr):
                next_x = arr[idx + 1]
            else:
                continue

            if (next_x, next_y) not in pre_cnt:
                continue

            left, right, bottom, top = x, next_x, y, next_y
            if pre_cnt[(right, top)] - pre_cnt[(left, top)] - pre_cnt[(right, bottom)] + pre_cnt[(left, bottom)] == 1:
                ans = max(ans, (right - left) * (top - bottom))
        return ans


if __name__ == '__main__':
    print(Solution().maxRectangleArea(xCoord=[1, 1, 3, 3], yCoord=[1, 3, 1, 3]))
    print(Solution().maxRectangleArea(xCoord=[1, 1, 3, 3, 2], yCoord=[1, 3, 1, 3, 2]))
    print(Solution().maxRectangleArea(xCoord=[1, 1, 3, 3, 1, 3], yCoord=[1, 3, 1, 3, 2, 2]))
    print(Solution().maxRectangleArea(
        xCoord=[89, 55, 89, 55, 0, 34, 17, 71, 98, 90, 63, 49, 76, 72, 4, 46, 67, 94, 52, 6],
        yCoord=[58, 69, 69, 58, 100, 36, 14, 40, 13, 41, 29, 23, 47, 52, 95, 49, 37, 77, 54, 59]
    ))  # 374
