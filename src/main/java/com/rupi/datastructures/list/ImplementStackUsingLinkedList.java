package com.rupi.datastructures.list;

import com.rupi.datastructures.exceptions.CapacityExceededException;
import com.rupi.datastructures.exceptions.NoElementFoundException;

/**
 * Implement Stack using a linked list
 */
public class ImplementStackUsingLinkedList {

    private static final int CAPACITY = 5;

    private int size;
    private Node head;

    public static void main(String[] args) {
        final ImplementStackUsingLinkedList stack = new ImplementStackUsingLinkedList();
        stack.push(new Node(1));
        stack.push(new Node(2));
        stack.push(new Node(3));
        stack.push(new Node(4));
        stack.push(new Node(5));
        ListHelper.printList(stack.head);
        System.out.println(stack.pop().getValue());
        ListHelper.printList(stack.head);
        System.out.println(stack.pop().getValue());
        ListHelper.printList(stack.head);
        System.out.println(stack.pop().getValue());
        ListHelper.printList(stack.head);
        stack.push(new Node(6));
        ListHelper.printList(stack.head);

    }

    private void push(final Node node) {
        if(size == CAPACITY){
            throw new CapacityExceededException("Can not push new node");
        }
        if(head == null){
            head = node;
        } else{
            node.setNextNode(head);
            head = node;
        }
        size++;
    }

    private Node pop(){
        if(head == null){
            throw new NoElementFoundException("No element present in the list");
        }
        final Node temp = head;
        head = head.getNextNode();
        size--;
        return temp;

    }

}
