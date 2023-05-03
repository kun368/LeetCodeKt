from utils.python.predef import *


class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if endWord not in wordList:
            return 0
        bits = [26 ** i for i in range(len(beginWord))]
        ha = lambda w: sum((ord(a) - 97) * b for a, b in zip(w, bits))
        word_set = set(ha(w) for w in wordList if w != beginWord)
        qu = deque([(ha(beginWord), 0)])
        target = ha(endWord)
        while qu:
            cur, dis = qu.popleft()
            if cur == target:
                return dis + 1
            val = cur
            for i in range(len(beginWord)):
                t = val % 26
                for j in range(26):
                    next = cur + bits[i] * (j - t)
                    if next in word_set:
                        qu.append((next, dis + 1))
                        word_set.remove(next)
                val //= 26
        return 0


if __name__ == '__main__':
    print(Solution().ladderLength(beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]))
    print(Solution().ladderLength(beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]))
    print(Solution().ladderLength(beginWord = "hot", endWord = "dog", wordList = ["hot","dog"]))
