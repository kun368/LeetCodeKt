from collections import deque


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x, left=None, right=None):
        self.val = x
        self.left = left
        self.right = right

    def __repr__(self):
        return str(self.__dict__)

class Codec:
    def serialize(self, root: TreeNode) -> str:
        ans = []
        qu = deque([root])
        while qu:
            top = qu.popleft()
            if top is None:
                ans.append('X')
                continue
            ans.append(str(top.val))
            qu.append(top.left)
            qu.append(top.right)
        return ','.join(ans)

    def deserialize(self, data: str) -> TreeNode:
        seq = data.split(',')
        if len(seq) <= 1:
            return None

        root = TreeNode(int(seq[0]))
        qu = deque([root])
        for i in range(1, len(seq), 2):
            left = None if seq[i] == 'X' else int(seq[i])
            right = None if seq[i + 1] == 'X' else int(seq[i + 1])
            top = qu[0]
            if left is not None:
                top.left = TreeNode(left)
                qu.append(top.left)
            if right is not None:
                top.right = TreeNode(right)
                qu.append(top.right)
            qu.popleft()
        return root


if __name__ == '__main__':
    print(Codec().serialize(
        TreeNode(1, TreeNode(2, TreeNode(4)), TreeNode(3, None, TreeNode(5)))
    ))
    print(Codec().deserialize(
        '1,2,3,4,X,X,5,X,X,X,X'
    ))
