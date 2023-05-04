from utils.python.predef import *


class Solution:
    def findLadders(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if endWord not in wordList:
            return []
        
        bits = [26 ** i for i in range(len(beginWord))]
        def ha(w):
            return sum((ord(a) - 97) * b for a, b in zip(w, bits))
        def ha_rev(val):
            if val is None:
                return None
            ans = []
            for _ in range(len(beginWord)):
                ans.append(chr(97 + val % 26))
                val //= 26
            return ''.join(ans)

        word_set = set(ha(w) for w in wordList if w != beginWord)
        word_prev = defaultdict(list)
        qu = deque([(None, ha(beginWord), 0)])
        dd = dict()
        while qu:
            prev, cur, dis = qu.popleft()
            if cur not in dd:
                dd[cur] = dis
                if prev is not None:
                    word_prev[ha_rev(cur)].append(ha_rev(prev))
            elif dis <= dd[cur]:
                if prev is not None:
                    word_prev[ha_rev(cur)].append(ha_rev(prev))
                continue
            else:
                continue

            # print(ha_rev(prev), ha_rev(cur), dis)
            val = cur
            for i in range(len(beginWord)):
                t = val % 26
                for j in range(26):
                    next = cur + bits[i] * (j - t)
                    if next in word_set and next != cur:
                        qu.append((cur, next, dis + 1))
                val //= 26

        @cache
        def dfs_path(root):
            if root not in word_prev:
                return [[root]]
            ans = []
            for i in word_prev[root]:
                for j in dfs_path(i):
                    ans.append(j + [root])
            return ans

        
        return dfs_path(endWord) if ha(endWord) in dd else []


if __name__ == '__main__':
    print(Solution().findLadders(beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]))
    print(Solution().findLadders(beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]))
    print(Solution().findLadders(beginWord = "hot", endWord = "dog", wordList = ["hot","dog"]))
    print(Solution().findLadders(beginWord = "red", endWord = "tax", wordList = ["ted","tex","red","tax","tad","den","rex","pee"]))
