from utils.python.predef import *


class Solution:
    def minimumCost(self, target: str, words: List[str], costs: List[int]) -> int:
        cost_mp = {}
        for w, c in zip(words, costs):
            cost_mp[w] = min(c, cost_mp.get(w, inf))
        n = len(target)
        mp = sorted([(len(w), hash(w), c) for w, c in cost_mp.items()])
        ha_set = set(hash(i) for i in words)
        len_cnt = Counter([i[0] for i in mp])

        @cache
        def dfs(st):
            if st >= n:
                return 0
            ans = inf
            i = 0
            while i < len(mp):
                length, ha, cost = mp[i]
                if st + length > n: break
                cur_ha = hash(target[st:st + length])
                if cur_ha not in ha_set:
                    i += len_cnt[length]
                    continue
                if cur_ha == ha:
                    if (cur_ans := cost + dfs(st + length)) < ans:
                        ans = cur_ans
                i += 1
            return ans

        ret = dfs(0)
        return -1 if ret == inf else ret


if __name__ == '__main__':
    print(Solution().minimumCost(target="abcdef", words=["abdef", "abc", "d", "def", "ef"], costs=[100, 1, 1, 10, 5]))
    print(Solution().minimumCost(target="aaaa", words=["z", "zz", "zzz"], costs=[1, 10, 100]))
    print(Solution().minimumCost(target="n", words=["n", "n", "n", "n"], costs=[2, 1, 1, 1]))
    print(Solution().minimumCost(target="wvgafw", words=["wvgafw", "w"], costs=[1, 2]))
