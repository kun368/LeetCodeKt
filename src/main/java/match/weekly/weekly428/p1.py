from utils.python.predef import *


class Solution:
    def buttonWithLongestTime(self, events: List[List[int]]) -> int:
        ret = []
        for i in range(len(events)):
            index, time = events[i]
            cs = time if i == 0 else time - events[i - 1][1]
            ret.append((-cs, index))
        ret.sort()
        return ret[0][1]


if __name__ == '__main__':
    print(Solution().buttonWithLongestTime(events=[[1, 2], [2, 5], [3, 9], [1, 15]]))
    print(Solution().buttonWithLongestTime(events=[[10, 5], [1, 7]]))
