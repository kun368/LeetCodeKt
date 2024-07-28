from utils.python.predef import *


def count_gte_x(a, b, x):
    return max(0, b - max(a, x))


class Solution:
    def numberOfSubstrings(self, s: str) -> int:
        s = [int(i) for i in s]
        zero_p = [i for i, v in enumerate(s) if v == 0] + [len(s)]

        ans = 0
        for i in range(0, len(s)):
            cnt0, cnt1 = 0, 0
            j = i
            next_zero_idx = bisect_left(zero_p, i)
            while j < len(s):
                if cnt1 + (len(s) - j) < cnt0 * cnt0:
                    break
                if s[j] == 0:
                    cnt0 += 1
                    j += 1
                    next_zero_idx += 1
                    if cnt1 >= cnt0 * cnt0:
                        ans += 1
                    continue
                next_zero = zero_p[next_zero_idx]
                cur_ans = count_gte_x(cnt1 + 1, cnt1 + (next_zero - j) + 1, cnt0 * cnt0)
                # ic(i, j, next_zero, cnt0, cnt1, cur_ans)
                ans += cur_ans
                cnt1 += next_zero - j
                j = next_zero
        return ans


if __name__ == '__main__':
    print(Solution().numberOfSubstrings(s="00011"))  # 5
    print(Solution().numberOfSubstrings(s="101101"))  # 16
    print(Solution().numberOfSubstrings(s="0"))
    print(Solution().numberOfSubstrings(s="1001"))
    print(Solution().numberOfSubstrings(s="10001"))
