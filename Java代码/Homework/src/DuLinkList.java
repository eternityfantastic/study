class DuNode {
    int date;
    DuNode prev;
    DuNode next;

    DuNode(int val) {
        this.date = val;
        this.prev = this;
        this.next = this;
    }
}

public class DuLinkList {
    DuNode head = new DuNode(-1);

    public DuNode addFirst(int val) {
        DuNode node = new DuNode(val);
        DuNode next = head.next;

        node.next = next;
        next.prev = node;

        node.prev = head;
        head.next = node;
        return head;
    }

    public DuNode addLast(int val) {
        DuNode node = new DuNode(val);
        DuNode prev = head.prev;
        node.prev = prev;
        prev.next = node;

        node.next = head;
        head.prev = node;
        return head;

    }

    public void forwardDisplay() {
        System.out.print("[");
        DuNode cur = head.next;
        while (cur != head) {
            System.out.print(cur.date);
            if (cur.next != head) {
                System.out.print(",");
            }
            cur = cur.next;
        }
        System.out.println("]");
    }

    public void reverseDisplay() {
        System.out.print("[");
        DuNode cur = head.prev;
        while (cur != head) {
            System.out.print(cur.date);
            if (cur.prev != head) {
                System.out.print(",");
            }
            cur = cur.prev;
        }
        System.out.println("]");
    }
}
