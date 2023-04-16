from utils.python.predef import *


class MajorityChecker:
    def __init__(self, arr: List[int]):
        self.arr = arr
        self.pos_dict = defaultdict(list)
        for i, v in enumerate(arr):
            self.pos_dict[v].append(i)

    def query(self, left: int, right: int, threshold: int) -> int:
        from random import randrange
        vis = set()
        for _ in range(32):
            v = self.arr[randrange(left, right + 1)]
            if v in vis: continue
            cnt1 = bisect.bisect_right(self.pos_dict[v], left - 1)
            cnt2 = bisect.bisect_right(self.pos_dict[v], right)
            if cnt2 - cnt1 >= threshold:
                return v
            vis.add(v)
        return -1


if __name__ == '__main__':
    majorityChecker = MajorityChecker([1, 1, 2, 2, 1, 1])
    print(majorityChecker.query(0, 5, 4))
    print(majorityChecker.query(0, 3, 3))
    print(majorityChecker.query(2, 3, 2))
