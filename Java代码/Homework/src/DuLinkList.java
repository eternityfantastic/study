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
    DuNode head = null;
    DuNode last = null;

    public DuNode addFirst(int val) {
        if (head == null) {
            head = new DuNode(val);
            last = head;
        } else {
            DuNode node = new DuNode(val);
            node.next = head;
            head.prev = node;
            head = node;
        }
        return head;
    }

    public DuNode addLast(int val) {
        if (head == null) {
            head = new DuNode(val);
            last = head;
        } else {
            DuNode node = new DuNode(val);
            last.next = node;
            node.prev = last;
            last = node;
        }
        return head;
    }

    public void remove(int val) {
        if (head == null) {
            return;
        }
        if (head.date == val) {
            if (head.next != null) {
                DuNode Next = head.next;
                head = head.next;
            } else {
                head = null;
            }
        }
        if (last.date == val) {
            last= last.prev;
            last.next = null;
        } else {
            DuNode cur = head;
            while (cur != null && cur.date != val) {
                cur = cur.next;
            }
            DuNode Next = cur.next;
            DuNode Prev = cur.prev;

            Next.prev = cur.prev;
            Prev.next = cur.next;
        }
    }
    public void removeAllKey(int val) {
        if(head != null ){
            if(head.next!= null){
                DuNode cur  = head.next;
                while(cur!= null){
                    if(cur.date == val){

                    }
                }
            }
        }
    }
    public void display() {
        System.out.print("[");
        DuNode cur = head.next;
        while (cur != head) {
            System.out.print(cur.date);
            if (cur.next != null) {
                System.out.print(",");
            }
            cur = cur.next;
        }
        System.out.println("]");
    }
//    public DuNode addFirst(int val) {
//        DuNode node = new DuNode(val);
//        DuNode next = head.next;
//
//        node.next = next;
//        next.prev = node;
//
//        node.prev = head;
//        head.next = node;
//        return head;
//    }
//
//    public DuNode addLast(int val) {
//        DuNode node = new DuNode(val);
//        DuNode prev = head.prev;
//        node.prev = prev;
//        prev.next = node;
//
//        node.next = head;
//        head.prev = node;
//        return head;
//
//    }
//
//    public void forwardDisplay() {
//        System.out.print("[");
//        DuNode cur = head.next;
//        while (cur != head) {
//            System.out.print(cur.date);
//            if (cur.next != head) {
//                System.out.print(",");
//            }
//            cur = cur.next;
//        }
//        System.out.println("]");
//    }
//
//    public void reverseDisplay() {
//        System.out.print("[");
//        DuNode cur = head.prev;
//        while (cur != head) {
//            System.out.print(cur.date);
//            if (cur.prev != head) {
//                System.out.print(",");
//            }
//            cur = cur.prev;
//        }
//        System.out.println("]");
//    }
}
