from utils.python.predef import *


class TrieNode:
    def __init__(self):
        self.children = {}
        self.idxs = set()


class Solution:
    def shortestSubstrings(self, arr: List[str]) -> List[str]:
        root = TrieNode()

        def insert(s, idx):
            if not s: return
            cur = root
            for c in s:
                if c not in cur.children:
                    cur.children[c] = TrieNode()
                cur = cur.children[c]
                cur.idxs.add(idx)

        for idx, i in enumerate(arr):
            for j in range(len(i)):
                insert(i[j:], idx)

        ret = []
        for i in arr:
            ans = None
            for j in range(len(i)):
                cur = root
                for t in range(j, len(i)):
                    c = i[t]
                    if c in cur.children:
                        cur = cur.children[c]
                    if len(cur.idxs) == 1:
                        cur_ans = i[j:t + 1]
                        if ans is None or len(cur_ans) < len(ans) or (len(cur_ans) == len(ans) and cur_ans < ans):
                            ans = cur_ans
                            # print('find', ans)
                        break
            ret.append(ans if ans else "")
        return ret


if __name__ == '__main__':
    print(Solution().shortestSubstrings(arr=["cab", "ad", "bad", "c"]))
    print(Solution().shortestSubstrings(arr=["abc", "bcd", "abcd"]))
