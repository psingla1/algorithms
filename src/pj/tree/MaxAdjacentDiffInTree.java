package pj.tree;

import pj.V;

// Return the max diff between two adjacent elements in a tree.
// Two elements are adjacent if one is parent of another.

public class MaxAdjacentDiffInTree {
    public static int solve(Node node) {
        if (node == null) {
            return 0;
        }
        int leftNode = node.left == null ? node.val : node.left.val;
        int rightNode = node.right == null ? node.val : node.right.val;

        int val = Math.max(Math.abs(node.val - leftNode), Math.abs(node.val - rightNode));
        return Math.max(Math.max(solve(node.left), solve(node.right)), val);
    }

    public static void main(String args[]) {
        V.verify(solve(null), 0);
        V.verify(solve(new Node(1)), 0);
        V.verify(solve(
                new Node(1,
                    new Node(100),
                    new Node(200))),
                199);
        V.verify(solve(
                new Node(1,
                    new Node(100,
                            new Node(1),
                            new Node(2)),
                    new Node(200,
                            null,
                            new Node(1000)))),
                800);
        V.verify(solve(
                new Node(1,
                    new Node(100,
                            new Node(1),
                            new Node(2)),
                    new Node(200,
                            null,
                            null))),
                199);

        V.end();
    }
}
