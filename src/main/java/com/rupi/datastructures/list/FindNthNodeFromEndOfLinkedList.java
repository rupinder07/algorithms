package com.rupi.datastructures.list;

import com.rupi.datastructures.exceptions.InvalidArgumentException;
import com.rupi.datastructures.exceptions.NoElementFoundException;

/**
 * Find Nth node from end of linked list
 * Efficient Approach: Use two pointers p1 and p2. Initially both points to head node of the list.
 * p2 starts moving only after p1 has made n moves.From there both moves forward one step  until p1 reaches end of list
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 */
public class FindNthNodeFromEndOfLinkedList {

    static Node nthNode = null;
    static int counter = 0;

    public static void main(String[] args) {
        final Node head = ListHelper.initializeList(10);
        System.out.println(new FindNthNodeFromEndOfLinkedList().findNthNodeFromEnd(head, 4).getValue());

        counter = 0;
        nthNode = head;
        new FindNthNodeFromEndOfLinkedList()
                .findNthNodeFromEndUsingRecursion(head, 4);
        System.out.println(nthNode.getValue());
    }

    private Node findNthNodeFromEnd(final Node head, final int n) {
        if(n < 1 ){
            throw new InvalidArgumentException("N must be greater than or equal to 1");
        }
        Node p1 = head;
        Node p2 = head;
        for(int i=0;i<n;i++){
            if(p1 == null){
                throw new NoElementFoundException("Length of list is fewer than n");
            }
            p1 = p1.getNextNode();
        }

        while (p1 != null){
            p1 = p1.getNextNode();
            p2 = p2.getNextNode();
        }
        return p2;
    }

    /**
     * This method finds nth node of a linked list from end using recursion.
     * Recursive approach requires global variables
     * @param head
     * @param n
     * @return
     */

    private void findNthNodeFromEndUsingRecursion(final Node head, int n) {
        if(head != null){
            findNthNodeFromEndUsingRecursion(head.getNextNode(), n);
            counter++;
            if(counter == n){
                nthNode = head;
            }
        }
    }

}
