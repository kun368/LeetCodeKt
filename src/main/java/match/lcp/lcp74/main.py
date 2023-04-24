from utils.python.predef import *


class Solution:

    def get_corners(self, xx, yy):
        res = []
        for x in xx:
            for y in yy:
                res.append((x, y))
        return res

    def point_in_corners(self, a, b, x, y, r):
        return x - r/2.0 <= a <= x + r/2.0 and y - r/2.0 <= b <= y + r/2.0

    def fieldOfGreatestBlessing(self, forceField: List[List[int]]) -> int:
        corners = set()
        for a, b, c in forceField:
            for d, e, f in forceField:
                xx = (a - c/2, a + c/2, d - f/2, d + f/2)
                yy = (b - c/2, b + c/2, e - f/2, e + f/2)
                corners |= set(self.get_corners(xx, yy))

        best_cnt = 0
        for a, b in corners:
            cnt = 0
            for x, y, r in forceField:
                if self.point_in_corners(a, b, x, y, r):
                    cnt += 1
            best_cnt = max(best_cnt, cnt)
        return best_cnt


if __name__ == '__main__':
    print(Solution().fieldOfGreatestBlessing(
        forceField=[[0, 0, 1], [1, 0, 1]]
    ))
    print(Solution().fieldOfGreatestBlessing(
        forceField=[[4, 4, 6], [7, 5, 3], [1, 6, 2], [5, 6, 3]]
    ))
    print(Solution().fieldOfGreatestBlessing(
        forceField=[[932, 566, 342], [546, 489, 250], [723, 454, 748], [830, 887, 334], [617, 534, 721], [924, 267, 892], [151, 64, 65], [318, 825, 196], [102, 941, 940], [748, 562, 582], [76, 938, 228], [921, 15, 245], [871, 96, 823], [
            701, 737, 991], [339, 861, 146], [484, 409, 823], [574, 728, 557], [104, 845, 459], [363, 804, 94], [445, 685, 83], [324, 641, 328], [626, 2, 897], [656, 627, 521], [935, 506, 956], [210, 848, 502], [990, 889, 112]]
    ))
    print(Solution().fieldOfGreatestBlessing(
        forceField=[[565, 34, 242], [299, 628, 870], [724, 673, 221], [128, 267, 917], [561, 488, 696], [341, 71, 604], [835, 92, 846], [945, 696, 973], [554, 776, 430], [209, 134, 594], [987, 898, 282], [819, 154, 462], [618, 946, 505], [561, 40, 677], [
            602, 863, 657], [295, 83, 718], [456, 920, 939], [94, 717, 813], [611, 946, 366], [818, 850, 85], [395, 554, 333], [325, 700, 628], [590, 401, 119], [248, 858, 499], [298, 723, 602], [189, 538, 646], [194, 283, 344], [842, 535, 866], [192, 832, 195]]
    ))
