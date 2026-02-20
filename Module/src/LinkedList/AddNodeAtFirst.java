package src.LinkedList;

public class AddNodeAtFirst {

    public static void main(String[] args) {
        LinkNode head = LinkedList.getLinkedListHead();
        LinkNode newNode = new LinkNode(10);
        newNode.next = head;
        head = newNode;
        while (head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }

}
