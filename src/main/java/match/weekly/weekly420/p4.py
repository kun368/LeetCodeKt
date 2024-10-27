from utils.python.predef import *


def manacher(s):
    t = "$#" + '#'.join(s) + '#'
    res = [0] * len(t)
    mx, idx = 0, 0
    for i in range(len(t)):
        res[i] = mx > i and min(res[2 * idx - i], mx - i) or 1
        while i + res[i] < len(t) and i - res[i] >= 0 and t[i + res[i]] == t[i - res[i]]:
            res[i] += 1
        if i + res[i] > mx:
            mx, idx = i + res[i], i
    # ic(s, t, res)
    return res


class Solution:
    def findAnswer(self, parent: List[int], s: str) -> List[bool]:
        n = len(s)
        g = defaultdict(list)
        for cur, par in enumerate(parent):
            g[par].append(cur)

        dfs_str = []
        span_mp = {}

        def dfs(root):
            span_st = len(dfs_str)
            for son in sorted(g[root]):
                dfs(son)
            dfs_str.append(s[root])
            span_ed = len(dfs_str)
            span_mp[root] = (span_st, span_ed)

        dfs(0)
        dfs_str = ''.join(dfs_str)
        mc = manacher(dfs_str)
        ret = []
        for i in range(n):
            st, ed = span_mp[i]
            mid = st + ed
            mc_len = mc[mid + 1]
            ok = mc_len > (ed - st)
            # ic(i, dfs_str[st:ed], mid, mc[mid + 1], ok)
            ret.append(ok)
        return ret


if __name__ == '__main__':
    # print(manacher('xaaay'))
    print(Solution().findAnswer(parent=[-1, 0, 0, 1, 1, 2], s="aababa"))
    print(Solution().findAnswer(parent=[-1, 0, 0, 0, 0], s="aabcb"))
