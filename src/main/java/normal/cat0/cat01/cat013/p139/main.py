from utils.python.predef import *


class Node:
    def __init__(self, value):
        self.value = value
        self.sons = dict()


class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        root = Node(-1)
        for w in wordDict:
            cur = root
            for i in range(len(w)):
                c = w[i]
                if c not in cur.sons:
                    cur.sons[c] = Node(0)
                cur = cur.sons[c]
                if i == len(w) - 1:
                    cur.value = 1

        @functools.cache
        def dfs(idx):
            if idx == len(s):
                return True
            cur = root
            for i in range(idx, len(s)):
                c = s[i]
                if c not in cur.sons:
                    break
                cur = cur.sons[c]
                if cur.value == 1 and dfs(i + 1):
                    return True
            return False

        return dfs(0)


if __name__ == '__main__':
    print(Solution().wordBreak(s="leetcode", wordDict=["leet", "code"]))
    print(Solution().wordBreak(s="applepenapple", wordDict=["apple", "pen"]))
    print(Solution().wordBreak(s="catsandog", wordDict=["cats", "dog", "sand", "and", "cat29"]))
    print(Solution().wordBreak(s="cars", wordDict=["car", "ca", "rs"]))
