from utils.python.predef import *


class TrieNode:
    def __init__(self):
        self.children = defaultdict(TrieNode)
        self.is_word = False


class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str):
        node = self.root
        for char in word:
            node = node.children[char]
            node.is_word = True

    def get_prefixes(self, s: str, start: int):
        node = self.root
        prefixes = []
        for i in range(start, len(s)):
            char = s[i]
            if char not in node.children:
                break
            node = node.children[char]
            if node.is_word:
                prefixes.append(i + 1)
        return prefixes


class Solution:
    def minValidStrings(self, words: List[str], target: str) -> int:
        trie = Trie()
        for word in words:
            trie.insert(word)

        n = len(target)
        queue = deque([(0, 0)])  # (current position in target, number of strings used)
        visited = [False] * (n + 1)
        visited[0] = True

        while queue:
            current_pos, steps = queue.popleft()
            if current_pos == n:
                return steps
            for next_pos in reversed(trie.get_prefixes(target, current_pos)):
                if not visited[next_pos]:
                    visited[next_pos] = True
                    queue.append((next_pos, steps + 1))
        return -1


if __name__ == '__main__':
    print(Solution().minValidStrings(words=["abc", "aaaaa", "bcdef"], target="aabcdabc"))
    print(Solution().minValidStrings(words=["abababab", "ab"], target="ababaababa"))
    print(Solution().minValidStrings(words=["abcdef"], target="xyz"))
