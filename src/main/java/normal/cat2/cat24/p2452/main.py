from utils.python.predef import *


def dis(a, b):
    return sum(1 if x != y else 0 for x, y in zip(a, b))


class Solution:
    def twoEditWords(self, queries: List[str], dictionary: List[str]) -> List[str]:
        ans = []
        for q in queries:
            if any(dis(q, d) <= 2 for d in dictionary):
                ans.append(q)
        return ans


if __name__ == '__main__':
    print(Solution().twoEditWords(queries=["word", "note", "ants", "wood"], dictionary=["wood", "joke", "moat"]))
    print(Solution().twoEditWords(queries=["yes"], dictionary=["not"]))
