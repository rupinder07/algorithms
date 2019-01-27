package com.rupi.datastructures.list;

public class ReverseLinkedList {

    public static void main(String[] args) {
        final Node head = ListHelper.initializeList(10);
        ListHelper.printList(head);
        final Node reversedNode = new ReverseLinkedList().reverseList(head, null);
        ListHelper.printList(reversedNode);
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