package src.LinkedList;


public class Problem1 {

    /* 92. Reverse Linked List II
Given the head of a singly linked list and two integers left and right where left <= right,
reverse the nodes of the list from position left to position right, and return the reversed list.
Example 1:
Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]

Example 2:
Input: head = [5], left = 1, right = 1
Output: [5]*/

    public ListNode reverseBetween(ListNode head, int left, int right) {
        int idx = 1;
        ListNode curr = head,pre=null;
        while(idx!=left){
            pre = curr;
            curr = curr.next;
            idx++;
        }
        ListNode tmpCurr = curr;
        ListNode tmpPre = null,tmpNxt=null;
        while(idx<=right){
            tmpNxt = tmpCurr.next;
            tmpCurr.next=tmpPre;
            tmpPre=tmpCurr;
            tmpCurr=tmpNxt;
            idx++;
        }
        if(pre!=null){
            pre.next=tmpPre;
        }
        curr.next=tmpCurr;
        if(left>1){
            return head;
        }
        return tmpPre;
    }

}
