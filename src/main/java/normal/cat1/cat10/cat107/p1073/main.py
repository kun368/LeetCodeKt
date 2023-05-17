from utils.python.predef import *


class Solution:
    def addNegabinary(self, arr1: List[int], arr2: List[int]) -> List[int]:
        arr1.reverse()
        arr2.reverse()
        l = max(len(arr1), len(arr2)) + 5
        while len(arr1) < l: arr1.append(0)
        while len(arr2) < l: arr2.append(0)
        ans = [0] * l
        for i in range(l):
            ans[i] = arr1[i] + arr2[i] + ans[i]
            while ans[i] >= 2:
                ans[i] -= 2
                if ans[i + 1]:
                    ans[i + 1] -= 1
                else:
                    ans[i + 1] += 1
                    ans[i + 2] += 1

        while len(ans) >= 2 and ans[-1] == 0:
            ans.pop()
        ans.reverse()
        return ans


if __name__ == '__main__':
    print(Solution().addNegabinary(arr1=[1, 1, 1, 1, 1], arr2=[1, 0, 1]))
    print(Solution().addNegabinary(arr1=[0], arr2=[0]))
    print(Solution().addNegabinary(arr1=[0], arr2=[1]))
