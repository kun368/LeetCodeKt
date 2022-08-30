from typing import *
from collections import *
from math import *
import itertools
import functools
import string
import heapq


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left: TreeNode = left
        self.right: TreeNode = right

    def __repr__(self):
        return str(self.__dict__)

    @staticmethod
    def create(s):
        if s == '[]':
            return None
        nodes = [None if val == 'null' else TreeNode(int(val)) for val in s.strip('[]').split(',')]
        kids = nodes[::-1]
        root = kids.pop()
        for node in nodes:
            if node:
                if kids:
                    node.left = kids.pop()
                if kids:
                    node.right = kids.pop()
        return root


if __name__ == '__main__':
    pass
