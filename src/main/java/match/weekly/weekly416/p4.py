from utils.python.predef import *


class Solution:
    def validSubstringCount(self, word1: str, word2: str) -> int:
        from collections import Counter, defaultdict

        len1, len2 = len(word1), len(word2)
        if len1 < len2:
            return 0

        count2 = Counter(word2)
        required_matches = len(count2)

        window_count = defaultdict(int)
        matches = 0

        ans = 0
        right = 0
        for i in range(len1):
            # add
            while right < len1 and matches < required_matches:
                c = word1[right]
                window_count[c] += 1
                if c in count2 and window_count[c] == count2[c]:
                    matches += 1
                right += 1

            if matches == required_matches:
                ans += len1 - right + 1

            # remove
            c = word1[i]
            if c in count2 and window_count[c] == count2[c]:
                matches -= 1
            window_count[c] -= 1

        return ans


if __name__ == '__main__':
    print(Solution().validSubstringCount(word1="bcca", word2="abc"))
    print(Solution().validSubstringCount(word1="abcabc", word2="abc"))
    print(Solution().validSubstringCount(word1="abcabc", word2="aaabc"))
