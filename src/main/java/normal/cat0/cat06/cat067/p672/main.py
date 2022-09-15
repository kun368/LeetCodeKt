class Solution:
    def flipLights(self, n: int, presses: int) -> int:
        if presses == 0:
            return 1
        mask = (1 << min(n, 4)) - 1
        cc = [int('1111', 2), int('0101', 2), int('1010', 2), int('0001', 2)]
        vis = {mask}
        for i in range(presses):
            new = set()
            for v in vis:
                for c in cc:
                    new.add((v ^ c) & mask)
            vis = new
        return len(vis)


if __name__ == '__main__':
    print(Solution().flipLights(n=1, presses=1))
    print(Solution().flipLights(n=2, presses=1))
    print(Solution().flipLights(n=3, presses=1))
    print(Solution().flipLights(n=3, presses=2))
