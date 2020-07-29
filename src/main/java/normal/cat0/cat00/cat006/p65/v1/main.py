class Solution:
    def isNumber(self, s: str) -> bool:
        try:
            float(s)
            return True
        except:
            return False


if __name__ == '__main__':
    s = Solution()
    print(s.isNumber("0") == True)
    print(s.isNumber(" 0.1 ") == True)
    print(s.isNumber("abc") == False)
    print(s.isNumber("1 a") == False)
    print(s.isNumber("2e10") == True)
    print(s.isNumber(" -90e3 ") == True)
    print(s.isNumber(" 1e") == False)
    print(s.isNumber("e3") == False)
    print(s.isNumber(" 6e-1") == True)
