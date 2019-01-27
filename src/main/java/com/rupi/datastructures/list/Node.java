package com.rupi.datastructures.list;

public class Node {

    private final int value;
    private Node nextNode;

    Node(final int value) {
        this.value = value;
    }

    int getValue() {
        return value;
    }

    Node getNextNode() {
        return nextNode;
    }

    void setNextNode(final Node nextNode) {
        this.nextNode = nextNode;
    }
}
