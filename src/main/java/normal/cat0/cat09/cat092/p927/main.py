from utils.python.predef import *


def cmp(a, b, c):
    return all(x == y == z for x, y, z in itertools.zip_longest(reversed(a), reversed(b), reversed(c), fillvalue=0))


class Solution:
    def threeEqualParts(self, arr: List[int]) -> List[int]:
        tot_c = sum(arr)
        N = len(arr)
        rp = [N] * (N + 1)
        rc = [0] * (N + 1)
        for i in reversed(range(N)):
            rp[i] = i if arr[i] == 1 else rp[i + 1]
            rc[i] = rc[i + 1] + 1 if arr[i] == 1 else rc[i + 1]

        cur_c = 0
        for i in range(len(arr) - 2):
            cur_c += 1 if arr[i] == 1 else 0
            a = min(rp[i + 1], N - 2)
            b = min(rp[a + (N - a) // 2], N - 1)
            if N - b != max(1, i - rp[0] + 1):  # length
                continue
            if cur_c != rc[b] or cur_c * 3 != tot_c:  # 1 count
                continue
            j = a + N - b
            if cmp(arr[:i + 1], arr[i + 1:j], arr[j:]):
                return [i, j]
        return [-1, -1]


if __name__ == '__main__':
    print(Solution().threeEqualParts(arr=[1, 0, 1, 0, 1]))
    print(Solution().threeEqualParts(arr=[1, 1, 0, 1, 1]))
    print(Solution().threeEqualParts(arr=[1, 1, 0, 0, 1]))
    print(Solution().threeEqualParts(arr=[1, 0, 1, 1, 0]))
    print(Solution().threeEqualParts(arr=[0, 1, 0, 1, 1]))
    print(Solution().threeEqualParts(arr=[0, 0, 0, 0, 0]))
    print(Solution().threeEqualParts(arr=[1, 1, 1, 1, 1]))
    print(Solution().threeEqualParts(arr=[1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1]))
