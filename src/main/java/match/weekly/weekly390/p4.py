from utils.python.predef import *


class Node:
    def __init__(self):
        self.son = dict()
        self.winner = (1 << 30, 1 << 30)


class Solution:
    def stringIndices(self, wordsContainer: List[str], wordsQuery: List[str]) -> List[int]:
        root = Node()
        for idx, word in enumerate(wordsContainer):
            priority = (len(word), idx)
            cur = root
            cur.winner = min(cur.winner, priority)
            for c in reversed(word):
                if c not in cur.son:
                    cur.son[c] = Node()
                cur = cur.son[c]
                cur.winner = min(cur.winner, priority)

        ans = []
        for word in wordsQuery:
            cur = root
            for c in reversed(word):
                if c not in cur.son:
                    break
                cur = cur.son[c]
            ans.append(cur.winner[1])
        return ans
