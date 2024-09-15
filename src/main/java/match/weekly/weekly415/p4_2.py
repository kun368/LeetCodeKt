from utils.python.predef import *


class Node:
    __slots__ = 'son', 'fail', 'depth', 'end'

    def __init__(self, depth=0):
        self.son: list = [None] * 26
        self.fail = None  # 当 cur.son[i] 不能匹配 target 中的某个字符时，cur.fail.son[i] 即为下一个待匹配节点（等于 root 则表示没有匹配）
        self.depth = depth  # 从根到 node 的字符串的长度，也是 node 在 trie 中的深度
        self.end = False  # 是否是某个 words[i] 的结束节点


class AhoCorasick:
    def __init__(self):
        self.root = Node()

    def put(self, s: str) -> None:
        cur = self.root
        for b in s:
            b = ord(b) - ord('a')
            if cur.son[b] is None:
                cur.son[b] = Node(cur.depth + 1)
            cur = cur.son[b]
        cur.end = True  # 设定当前节点为结束节点

    def build_fail(self) -> None:
        self.root.fail = self.root
        q = deque()
        for i, son in enumerate(self.root.son):
            if son is None:
                self.root.son[i] = self.root
            else:
                son.fail = self.root  # 第一层的失配指针，都指向根节点 ∅
                q.append(son)
        # BFS
        while q:
            cur = q.popleft()
            for i, son in enumerate(cur.son):
                if son is None:
                    # 虚拟子节点 cur.son[i]，和 cur.fail.son[i] 是同一个
                    # 方便失配时直接跳到下一个可能匹配的位置（但不一定是某个 words[k] 的最后一个字母）
                    cur.son[i] = cur.fail.son[i]
                    continue
                son.fail = cur.fail.son[i]  # 计算失配位置
                q.append(son)


class Solution:
    def minValidStrings(self, words: List[str], target: str) -> int:
        ac = AhoCorasick()
        for w in words:
            ac.put(w)
        ac.build_fail()

        n = len(target)
        cur = ac.root
        dp = [1 << 30] * (n + 1)
        dp[0] = 0
        for idx, c in enumerate(target, 1):
            cur = cur.son[ord(c) - ord('a')]
            if cur is ac.root:
                return -1
            dp[idx] = min(dp[idx], dp[idx - cur.depth] + 1)
        return dp[-1]


if __name__ == '__main__':
    print(Solution().minValidStrings(words=["abc", "aaaaa", "bcdef"], target="aabcdabc"))
    print(Solution().minValidStrings(words=["abababab", "ab"], target="ababaababa"))
    print(Solution().minValidStrings(words=["abcdef"], target="xyz"))
