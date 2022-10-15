from utils.python.predef import *


class Solution:
    def equalFrequency(self, word: str) -> bool:
        char_counter = Counter(word)
        if len(char_counter) == 1:
            return True

        freq_counter = Counter(char_counter.values())
        freq_counter = list(freq_counter.items())

        if len(freq_counter) > 2:
            return False
        if len(freq_counter) == 1:
            return freq_counter[0][0] == 1

        if freq_counter[1] == (1, 1):
            return True
        if freq_counter[0] == (1, 1):
            return True
        if freq_counter[1] == (freq_counter[0][0] + 1, 1):
            return True
        if freq_counter[0] == (freq_counter[1][0] + 1, 1):
            return True
        return False


if __name__ == '__main__':
    print(Solution().equalFrequency('aaa'))  # True
    print(Solution().equalFrequency('abcc'))  # True
    print(Solution().equalFrequency('aazz'))  # False
    print(Solution().equalFrequency('bac'))  # True
    print(Solution().equalFrequency("abbcc"))  # True
    print(Solution().equalFrequency("cccaa"))  # True
    print(Solution().equalFrequency("abbb"))  # True
