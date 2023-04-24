from utils.python.predef import *


class Solution:
    def split(self, x):
        return set() if len(x) == 0 else set(x.split('->'))

    def adventureCamp(self, expeditions: List[str]) -> int:
        s = self.split(expeditions[0])
        ans, find = -1, 0
        for i in range(1, len(expeditions)):
            cur = self.split(expeditions[i])
            if (cur_find := len(cur - s)) > find:
                find = cur_find
                ans = i
            s |= cur
        return ans


if __name__ == '__main__':
    print(Solution().adventureCamp(["leet->code", "leet->code->Campsite->Leet", "leet->code->leet->courier"]))
    print(Solution().adventureCamp(["Alice->Dex", "", "Dex"]))
    print(Solution().adventureCamp(["", "Gryffindor->Slytherin->Gryffindor", "Hogwarts->Hufflepuff->Ravenclaw"]))
