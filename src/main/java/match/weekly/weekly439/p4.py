from utils.python.predef import *


class Solution:
    def generateString(self, str1: str, str2: str) -> str:
        ret = ['^'] * (len(str1) + len(str2) - 1)

        for idx, v in enumerate(str1):
            if v == 'T':
                for i in range(len(str2)):
                    if ret[i + idx] in ('^', str2[i]):
                        ret[i + idx] = str2[i]
                    else:
                        return ''

        for idx, v in enumerate(str1):
            if v == 'F':
                if ''.join(ret[idx:idx + len(str2)]) == str2:
                    return ''

        for i in range(len(ret)):
            if ret[i] == '^':
                for c in range(26):
                    check = True
                    ret[i] = chr(ord('a') + c)
                    for st in range(i - len(str2) + 1, i + 1):
                        ed = st + len(str2)
                        if st >= 0 and ed <= len(ret) and str1[st] == 'F' and ''.join(ret[st:ed]) == str2:
                            check = False
                            break
                    if check:
                        break

        return ''.join(ret)


if __name__ == '__main__':
    print(Solution().generateString(str1="TFTF", str2="ab"))
    print(Solution().generateString(str1="TFTF", str2="abc"))
    print(Solution().generateString(str1="F", str2="d"))
    print(Solution().generateString(str1="TTFFT", str2="fff"))  # ""
    print(Solution().generateString(str1="FFTFFF", str2="a"))  # "bbabbb"
