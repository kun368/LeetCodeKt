from utils.python.predef import *


class Solution:
    def reportSpam(self, message: List[str], bannedWords: List[str]) -> bool:
        banned_set = set(bannedWords)
        count = 0
        for word in message:
            if word in banned_set:
                count += 1
                if count == 2:
                    return True
        return False


if __name__ == '__main__':
    print(Solution().reportSpam(message=["hello", "world", "leetcode"], bannedWords=["world", "hello"]))
    print(Solution().reportSpam(message=["hello", "programming", "fun"],
                                bannedWords=["world", "programming", "leetcode"]))
