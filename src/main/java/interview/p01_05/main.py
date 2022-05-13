class Solution:
    def oneEditAway(self, first: str, second: str) -> bool:
        l1, l2 = len(first), len(second)
        if abs(l1 - l2) > 1:
            return False
        for i in range(min(l1, l2)):
            if first[i] == second[i]:
                continue
            if l1 < l2:
                return first[i:] == second[i + 1:]
            elif l2 < l1:
                return first[i + 1:] == second[i:]
            else:
                return first[i + 1:] == second[i + 1:]
        return True


if __name__ == '__main__':
    print(Solution().oneEditAway('pale', 'ple'))
    print(Solution().oneEditAway('pales', 'pal'))
