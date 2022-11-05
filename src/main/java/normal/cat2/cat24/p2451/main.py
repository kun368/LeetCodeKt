from utils.python.predef import *


class Solution:
    def oddString(self, words: List[str]) -> str:
        diffs = []
        counter = Counter()
        for i in words:
            cur = tuple(ord(i[k + 1]) - ord(i[k]) for k in range(len(i) - 1))
            diffs.append(cur)
            counter[cur] += 1
        for s, d in zip(words, diffs):
            if counter[d] == 1:
                return s
        return ''


if __name__ == '__main__':
    print(Solution().oddString(["adc", "wzy", "abc"]))
    print(Solution().oddString(["aaa", "bob", "ccc", "ddd"]))
