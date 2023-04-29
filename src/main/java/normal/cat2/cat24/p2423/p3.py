from utils.python.predef import *


class Solution:
    def equalFrequency(self, word: str) -> bool:
        return any(len(set(Counter(word[:i] + word[i+1:]).values())) == 1 for i in range(len(word)))


if __name__ == '__main__':
    print(Solution().equalFrequency(word = "abcc"))
    print(Solution().equalFrequency(word = "aazz"))
