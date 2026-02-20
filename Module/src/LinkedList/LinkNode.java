package src.LinkedList;

public class LinkNode {
    int val;
    LinkNode next;
    LinkNode(int val){
        this.val=val;
        this.next=null;
    }
}

class LinkedList{
    public static LinkNode getLinkedListHead(){
        LinkNode node1 = new LinkNode(2);
        LinkNode node2 = new LinkNode(4);
        LinkNode node3 = new LinkNode(7);
        LinkNode node4 = new LinkNode(1);
        LinkNode node5 = new LinkNode(3);
        LinkNode node6 = new LinkNode(5);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        LinkNode node = node1;
        return node;
    }
}
