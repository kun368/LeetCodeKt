from utils.python.predef import *


class Node:
    __slots__ = 'son', 'fail', 'last', 'depth', 'end', 'cost'

    def __init__(self, depth=0):
        self.son: list = [None] * 26
        self.fail = None  # 当 cur.son[i] 不能匹配 target 中的某个字符时，cur.fail.son[i] 即为下一个待匹配节点（等于 root 则表示没有匹配）
        self.last = None  # 快速跳到一定是某个 words[k] 的最后一个字母的节点（等于 root 则表示没有）
        self.depth = depth  # 从根到 node 的字符串的长度，也是 node 在 trie 中的深度
        self.end = False  # 是否是某个 words[i] 的结束节点
        self.cost = 1 << 30


class AhoCorasick:
    def __init__(self):
        self.root = Node()

    def put(self, s: str, cost) -> None:
        cur = self.root
        for b in s:
            b = ord(b) - ord('a')
            if cur.son[b] is None:
                cur.son[b] = Node(cur.depth + 1)
            cur = cur.son[b]
        cur.end = True  # 设定当前节点为结束节点
        cur.cost = min(cur.cost, cost)

    def build_fail(self) -> None:
        self.root.fail = self.root.last = self.root
        q = deque()
        for i, son in enumerate(self.root.son):
            if son is None:
                self.root.son[i] = self.root
            else:
                son.fail = son.last = self.root  # 第一层的失配指针，都指向根节点 ∅
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
                # 沿着 last 往上走，可以直接跳到一定是某个 words[k] 的最后一个字母的节点（如果跳到 root 表示没有匹配）
                son.last = son.fail if son.fail.end else son.fail.last
                q.append(son)

    def search(self, text: str) -> list:
        cur = self.root
        result = []
        for i, char in enumerate(text):
            cur = cur.son[ord(char) - ord('a')]
            temp = cur

            # [二选一, 看场景] 使用 fail 跳转
            while temp != self.root:
                if temp.end:
                    result.append((i - temp.depth + 1, i))  # 添加匹配到的模式串的起始和结束位置
                temp = temp.fail

            # [二选一, 看场景] 也可以 使用 last 直接基于尾节点快速跳转
            while temp.end and temp != self.root:
                result.append((i - temp.depth + 1, i))  # 添加匹配到的模式串的起始和结束位置
                temp = temp.last

        return result


class Solution:
    def minimumCost(self, target: str, words: List[str], costs: List[int]) -> int:
        ac = AhoCorasick()
        for w, c in zip(words, costs):
            ac.put(w, c)
        ac.build_fail()

        n = len(target)
        cur = ac.root
        dp = [1 << 30] * (n + 1)
        dp[0] = 0
        for i, v in enumerate(target, 1):
            cur = cur.son[ord(v) - ord('a')]
            if cur is ac.root:
                return -1
            temp = cur
            while temp != ac.root:
                dp[i] = min(dp[i], dp[i - temp.depth] + temp.cost)
                temp = temp.last
        return dp[n] if dp[n] < (1 << 30) else -1


if __name__ == '__main__':
    print(Solution().minimumCost(target="abcdef", words=["abdef", "abc", "d", "def", "ef"], costs=[100, 1, 1, 10, 5]))
    print(Solution().minimumCost(target="aaaa", words=["z", "zz", "zzz"], costs=[1, 10, 100]))
    print(Solution().minimumCost(target="r", words=["r", "r", "r", "r"], costs=[1, 6, 3, 3]))  # 1
    print(Solution().minimumCost(target="eulhjfer",
                                 words=["eu", "jf", "lh", "eulhj", "er"],
                                 costs=[9, 4, 4, 2, 4]))  # 21
