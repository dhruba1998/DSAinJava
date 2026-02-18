package src.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem7 {

    /* 2487. Remove Nodes From Linked List
You are given the head of a linked list.

Remove every node which has a node with a greater value anywhere to the right side of it.

Return the head of the modified linked list.



Example 1:
Input: head = [5,2,13,3,8]
Output: [13,8]
Explanation: The nodes that should be removed are 5, 2 and 3.
- Node 13 is to the right of node 5.
- Node 13 is to the right of node 2.
- Node 8 is to the right of node 3.
Example 2:

Input: head = [1,1,1,1]
Output: [1,1,1,1]
Explanation: Every node has value 1, so no nodes are removed.*/


    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public ListNode removeNodes(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode currNode = head;

        //Push node into stack until a larger(than stack top) number is found
        while(currNode!=null){
            //If found pop until greater number than the currNode is present in the stack
            while (!stack.isEmpty() && stack.peek().val< currNode.val){
                stack.pop();
            }
            stack.push(currNode);
            currNode = currNode.next;
        }
        //Pop the all nodes from stack and create reverse linked list
        ListNode newHead = stack.peek();
        currNode = newHead;
        stack.pop();
        while (!stack.isEmpty()){
            currNode.next=stack.peek();
            currNode = stack.pop();
        }
        currNode.next=null; //The last node's next should be null
        // Reverse the linked list
        ListNode preNode = null;
        currNode = newHead;
        ListNode nxtNode;
        while (currNode!=null){
            nxtNode = currNode.next;
            currNode.next=preNode;
            preNode = currNode;
            currNode = nxtNode;
        }
        return preNode;
    }

}
