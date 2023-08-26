from utils.python.predef import *


class Solution:
    def isAcronym(self, words: List[str], s: str) -> bool:
        return s == ''.join(i[0] for i in words)


if __name__ == '__main__':
    print(Solution().isAcronym(words=["alice", "bob", "charlie"], s="abc"))
    print(Solution().isAcronym(words=["an", "apple"], s="a"))
    print(Solution().isAcronym(words=["never", "gonna", "give", "up", "on", "you"], s="ngguoy"))
