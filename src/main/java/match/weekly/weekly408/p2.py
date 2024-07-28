from utils.python.predef import *


def build_isp(sz=10240):
    isp = [True] * sz
    isp[0] = isp[1] = False
    for i in range(2, int(sqrt(sz)) + 1):
        if isp[i]:
            for j in range(i * i, sz, i):
                isp[j] = False
    pri = [a for a, b in enumerate(isp) if b]
    return pri


pri = build_isp(int(sqrt(1e9 + 7)))
pri = [i * i for i in pri]


def get_cnt(p):
    return bisect_right(pri, p)


class Solution:
    def nonSpecialCount(self, l: int, r: int) -> int:
        cnt1 = get_cnt(l - 1)
        cnt2 = get_cnt(r)
        ans = cnt2 - cnt1
        return (r - l + 1) - ans


if __name__ == '__main__':
    print(Solution().nonSpecialCount(5, 7))
    print(Solution().nonSpecialCount(4, 16))
    print(Solution().nonSpecialCount(1, int(1e9)))
    print(Solution().nonSpecialCount(1, 4))  # 3
