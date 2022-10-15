from utils.python.predef import *


class Solution:
    def equalFrequency(self, word: str) -> bool:
        for d in range(len(word)):
            cnt = Counter()
            for i in range(len(word)):
                if i != d:
                    cnt[word[i]] += 1
            if len(set(cnt.values())) == 1:
                return True
        return False
