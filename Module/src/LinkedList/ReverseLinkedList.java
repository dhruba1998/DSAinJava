package src.LinkedList;

public class ReverseLinkedList {


   /* 206. Reverse Linked List
   1 -> 2 -> 3
    head
    current = head
    prev = null
    next = null

    while(current!=null){
        next = current.next
        current.next = prev
        prev = current
        current = next
    }
    prev = head
    */
   public static void main(String[] args) {
       LinkNode head = LinkedList.getLinkedListHead();
       LinkNode current = head, prev = null, next = null;
       while (current!=null){
           next = current.next;
           current.next = prev;
           prev = current;
           current = next;
       }
       head = prev;
       LinkNode temp = head;
       while (temp!=null){
           System.out.println(temp.val);
           temp = temp.next;
       }
   }


}
