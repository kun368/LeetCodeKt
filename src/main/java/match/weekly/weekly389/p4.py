from utils.python.predef import *


class Solution:
    def minimumMoves(self, nums: List[int], k: int, maxChanges: int) -> int:
        mp = defaultdict(list)
        for i, v in enumerate(nums):
            cur = sum(nums[max(0, i - 1):min(len(nums), i + 2)])
            use_change = min(maxChanges, max(0, k - cur))
            mp[k - use_change].append(i)

        one_idx_list = []
        for i, v in enumerate(nums):
            if v == 1:
                one_idx_list.append(i)
        idx_ps = list(accumulate(one_idx_list)) + [0]

        ans = 1 << 50
        for need_sum, idx_list in mp.items():
            l, r = 0, need_sum
            for idx in idx_list:
                while r < len(one_idx_list) and (one_idx_list[r] - idx) < (idx - one_idx_list[l]):
                    l, r = l + 1, r + 1
                cur_pos = bisect_left(one_idx_list, idx)
                a = idx * (cur_pos - l) - (idx_ps[cur_pos - 1] - idx_ps[l - 1])
                b = (idx_ps[r - 1] - idx_ps[cur_pos - 1]) - idx * (r - cur_pos)
                cur = a + b + (k - need_sum) * 2
                ans = min(ans, cur)
        return ans


if __name__ == '__main__':
    print(Solution().minimumMoves(nums=[1, 1, 0, 0, 0, 1, 1, 0, 0, 1], k=3, maxChanges=1))
    print(Solution().minimumMoves(nums=[0, 0, 0, 0], k=2, maxChanges=3))
