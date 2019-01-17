package com.rupi.datastructures.list;

public class ReverseLinkedList {

    public static void main(String[] args) {
        final Node head = NodeHelper.initializeList(10);
        NodeHelper.printList(head);
        final Node reversedNode = new ReverseLinkedList().reverseList(head, null);
        NodeHelper.printList(reversedNode);
    }

    private Node reverseList(Node currentNode, Node previousNode) {
        if(currentNode == null){
            return null;
        }
        if (currentNode.getNextNode() == null) {
            currentNode.setNextNode(previousNode);
            return currentNode;
        }
        Node nextNode = currentNode.getNextNode();
        currentNode.setNextNode(previousNode);
        return reverseList(nextNode, currentNode);
    }
}

class Node {

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

class NodeHelper {

    static Node initializeList(final int sizeOfList) {
        Node node = new Node(0);
        final Node head = node;
        for (int i = 1; i < sizeOfList; i++) {
            final Node nextNode = new Node(i);
            node.setNextNode(nextNode);
            node = nextNode;
        }
        return head;
    }

    static void printList(final Node head) {
        Node node = head;
        while (node.getNextNode() != null) {
            System.out.print(node.getValue() + " -> ");
            node = node.getNextNode();
        }
        System.out.println(node.getValue());
    }
}