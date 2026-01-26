package src.LinkedListBasics;

public class AddNodeAtLast {

    public static void main(String[] args) {
        LinkNode head = LinkedList.getLinkedListHead();
        LinkNode newNode = new LinkNode(15);
        LinkNode temp = head;
        while (temp.next!=null){
            temp = temp.next;
        }
        temp.next = newNode;
        temp = head;
        while (temp!=null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

}
