package pj.tree;

import pj.V;

import java.util.HashSet;

public class HashSetTest {

    public static void main(String args[]) {
        HashSet<Node> hs = new HashSet<>();
        V.verify(hs.size(), 0);

        Node tree0 = new Node(10);
        hs.add(tree0);
        V.verify(hs.size(), 1);

        hs.add(tree0);
        V.verify(hs.size(), 1);

        hs.add(new Node(11));
        V.verify(hs.size(), 2);

        hs.add(new Node(11));
        V.verify(hs.size(), 2);

        hs.add(
                new Node(1,
                   new Node(2,
                            new Node(4),
                            null),
                   new Node(3)));
        hs.add(
                new Node(1,
                        new Node(2,
                                new Node(4),
                                null),
                        new Node(3)));
        V.verify(hs.size(), 3);
    }
}
