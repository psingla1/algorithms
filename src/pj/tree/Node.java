package pj.tree;

public class Node {
    int val;
    Node left;
    Node right;

    public Node(int val) {
        this(val, null, null);
    }

    public Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        String str = Integer.toString(val);
        String leftStr = (left == null) ? null : left.toString();
        String rightStr = (right == null) ? null : right.toString();
        if (leftStr == null && rightStr != null) {
            leftStr = "null";
        }
        if (rightStr == null && leftStr != null) {
            rightStr = "null";
        }
        return str
                + (leftStr == null ? "" : "\n|- " + String.join("\n|  ", leftStr.split("\n")))
                + (rightStr == null ? "" : "\n|- " + String.join("\n   ", rightStr.split("\n")));
    }


    static Node parseTree(String s) {
        return null;
    }

    static Node parseTree(String s, int pos) {
        String valStr = "";
        return null;
    }

    public static void main(String args[]) {
        System.out.println(
                new Node(1,
                        new Node(2,
                                new Node(3,
                                        new Node(8, null, null),
                                        null),
                                new Node(4,
                                        null,
                                        new Node(7, null, null))),
                        new Node(5, null, null))
                        .toString());
    }
}
