from math import sqrt


def build_isp(sz=10240):
    isp = [True] * sz
    isp[0] = isp[1] = False
    for i in range(2, int(sqrt(sz)) + 1):
        if not isp[i]: continue
        for j in range(i * i, sz, i):
            isp[j] = False
    pri = [a for a, b in enumerate(isp) if b]
    return isp, pri


def build_isp(sz=10240):
    isp = [True] * sz
    isp[0] = isp[1] = False
    for i in range(2, sz):
        if isp[i]:
            isp[i * i::i] = [False] * len(isp[i * i::i])
    pri = [a for a, b in enumerate(isp) if b]
    return isp, pri
