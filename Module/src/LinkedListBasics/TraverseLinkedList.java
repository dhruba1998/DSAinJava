package src.LinkedListBasics;

public class TraverseLinkedList {

    public static void main(String[] args) {
        LinkNode head = LinkedList.getLinkedListHead();
        while(head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
