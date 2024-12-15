from utils.python.predef import *


class Solution:
    def makeStringGood(self, s: str) -> int:
        counter = [0] * 26
        for i in s:
            counter[ord(i) - 97] += 1

        @cache
        def dfs(i, target, ap=0):
            if i >= 26:
                return 0
            cur_v = counter[i] + ap
            if cur_v == 0:
                return dfs(i + 1, target)
            ans_lst = [
                abs(cur_v - target_cnt) + dfs(i + 1, target),
                cur_v + dfs(i + 1, target)
            ]
            if i < 25:
                op = max(0, min(cur_v, target_cnt - counter[i + 1]))
                ans_lst.append(cur_v + dfs(i + 1, target, op))
                if cur_v >= target_cnt:
                    op = max(0, min(cur_v - target_cnt, target_cnt - counter[i + 1]))
                    ans_lst.append((cur_v - target_cnt) + dfs(i + 1, target, op))
            return min(ans_lst)

        best = 1 << 30
        for target_cnt in range(1, max(counter) + 1):
            best = min(best, dfs(0, target_cnt))
        return best


if __name__ == '__main__':
    print(Solution().makeStringGood(s="acab"))  # 1
    print(Solution().makeStringGood(s="wddw"))  # 0
    print(Solution().makeStringGood(s="aaabc"))  # 2
    print(Solution().makeStringGood(s="ruuu"))  # 1
