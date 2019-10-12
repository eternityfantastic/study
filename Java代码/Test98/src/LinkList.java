public class LinkList {
    Node head;
    int size;
    class Node {
        Object date;
        Node next;//指向下一个结点
    }

    //创建链表；
   //  头插法创建链表
    public Node Create(Object value ){
        Node node = new Node();
        node.date = value;
        node.next = head ;
        head = node;
        size++;
        return head;
    }
    public Node Add(Node head, int index, Object value) {
        int count = 0;
        Node node = head;
        while (node != null || count < index) {
            node = node.next;
            count++;
        }
        if (count == index) {
            node.date = value;
        } else {
            System.out.println("下标太大");
        }
        return head;
    }

    public Node Remove(Node head, Object value) {
        int count = 0;
        // Node cur=head;
        Node node = head;
        while (node != null || node.next.date != value) {
            node = node.next;
        }
        if (node != null) {

        } else {
            node.next = node.next.next;
        }
        return node;
    }
}
