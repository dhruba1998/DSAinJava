package src.LinkedListBasics;

public class AddNodeAtAnyPosition {

    public static void main(String[] args) {
        LinkNode head = LinkedList.getLinkedListHead();
        LinkNode newNode = new LinkNode(10);
        int pos = 0; //0 based index
        int idx = 0;
        LinkNode temp = head;
        // Traverse just before the desire position
        while(idx<pos-1){
            temp = temp.next;
            idx++;
        }
        // Case 1: Insert at beginning (at position 0)
        if(pos==0){
            newNode.next=temp;
            head=newNode;
        }
        // Case 2: Insert at any position (0 based index)
        else{
            newNode.next = temp.next;
            temp.next = newNode;
        }
        temp = head;
        while (temp!=null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
