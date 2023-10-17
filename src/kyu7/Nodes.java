package kyu7;

public class Nodes {
    public static void main(String[] args) {
        System.out.println(1 == Node.push(null, 1).data);
        System.out.println(null == Node.push(null, 1).next);
        System.out.println(2 == Node.push(new Node(1), 2).data);
        // System.out.println(1 == Node.push(new Node(1), 2).next.data);
    }
}

class Node {
    int data;
    Node next = null;

    public Node(final int data) {
        this.data = data;
    }

    public static Node push(final Node head, final int data) {
        Node n = new Node(data);
        n.next = head;
        return n;
    }

    public static Node buildOneTwoThree() {
        Node chained = null;
        chained = push(chained, 3);
        chained = push(chained, 2);
        chained = push(chained, 1);
        return chained;
    }
}
