from utils.python.predef import *


from sortedcontainers import SortedList


class Solution:
    def mostFrequentIDs(self, nums: List[int], freq: List[int]) -> List[int]:
        counter = dict()
        st = SortedList()

        ans = []
        for n, f in zip(nums, freq):
            if n in counter:
                pre_freq = counter[n]
                st.pop(st.bisect_left(pre_freq))
            else:
                pre_freq = 0

            cur_freq = pre_freq + f
            st.add(cur_freq)
            counter[n] = cur_freq
            ans.append(st[-1])
        return ans
