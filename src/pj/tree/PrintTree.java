package pj.tree;

import pj.V;

// Convert a tree to it's string form. String forms of trees are of the form:
//
// 1
// |- 2
// |- 3
//
//
// 1
// |- 2
// |  |- 4
// |  |- null
// |- 3
//
// Rules:
// 1. Display a child as null if only one child is null.
// 2. Ask for clarification wherever you have doubt.
public class PrintTree {
    public static String solve(Node node) {
        if (node == null) {
            return "null";
        }
        if (node.left == null && node.right == null) {
            return Integer.toString(node.val);
        }
        String left = String.join("\n|  ", solve(node.left).split("\n"));
        String right = String.join("\n|  ", solve(node.right).split("\n"));
        return Integer.toString(node.val) + "\n|- " + left + "\n|- " + right;
    }

    public static void main(String args[]) {
        Node tree0 = null;
        V.verify(solve(tree0), "null");

        Node tree1 = new Node(101);
        V.verify(solve(tree1), tree1.toString());

        Node tree2 = new Node(1,
                new Node(2),
                new Node(3));
        V.verify(solve(tree2), tree2.toString());

        Node tree3 = new Node(1,
                new Node(2,
                        new Node(4),
                        null),
                new Node(3));
        V.verify(solve(tree3), tree3.toString());

        V.end();
    }
}
