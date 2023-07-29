from utils.python.predef import *


class Solution:
    def splitWordsBySeparator(self, words: List[str], separator: str) -> List[str]:
        return list(j for w in words for j in str(w).split(separator) if j)


if __name__ == '__main__':
    print(Solution().splitWordsBySeparator(words=["one.two.three", "four.five", "six"], separator="."))
    print(Solution().splitWordsBySeparator(words=["$easy$", "$problem$"], separator="$"))
    print(Solution().splitWordsBySeparator(words=["|||"], separator="|"))
