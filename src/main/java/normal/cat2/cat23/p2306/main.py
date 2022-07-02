from utils.python.predef import *


class Solution:
    def distinctNames(self, ideas: List[str]) -> int:
        mp = defaultdict(set)
        for i in ideas:
            mp[i[0]].add(i[1:])
        return sum(len(sa - sb) * len(sb - sa) for sa, sb in itertools.combinations(mp.values(), 2)) * 2


if __name__ == '__main__':
    print(Solution().distinctNames(ideas=["coffee", "donuts", "time", "toffee"]))
    print(Solution().distinctNames(ideas=["lack", "back"]))
    print(Solution().distinctNames(ideas=["aaa", "baa", "caa", "bbb", "cbb", "dbb"]))  # 2
