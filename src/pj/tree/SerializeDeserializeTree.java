package pj.tree;

import pj.V;

public class SerializeDeserializeTree {

    public static String serialize(Node node) {
        return null;
    }

    public static Node deserialize(String node) {
        return null;
    }

    public static void main(String args[]) {
        Node tree0 = null;
        V.verify(deserialize(serialize(tree0)), tree0);

        Node tree1 = new Node(101);
        V.verify(deserialize(serialize(tree1)), tree1);

        Node tree2 = new Node(1,
                new Node(2),
                new Node(3));
        V.verify(deserialize(serialize(tree2)), tree2);

        Node tree3 = new Node(1,
                new Node(2,
                        new Node(4),
                        null),
                new Node(3));
        V.verify(deserialize(serialize(tree3)), tree3);

        V.end();
    }

}
