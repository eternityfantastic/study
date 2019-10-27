class Node {
    public int date;
    public Node next;

    public Node(int val) {
        date = val;
    }
}
//如果插入必须“找”到前一个节点进行的插入，必须把空链表情况单独考虑

//链表只有一个字段就是head;
public class LinkedList {
    //head是Node类型的引用，通过引用第一个节点将链表穿起来;
    //head本身放在栈上，它存储的是第一个节点的地址，
    // 而第一个节点在新建立是也会在栈上设立一个变量来引用它，因此两个存放的内容是一样的；
    //若有head=node;则 head.next;和node.next相同;
    //若是空链表，则head=null;
    public Node head = null;

    //O(1)
    public void addFirst(int elem) {
        Node node = new Node(elem);
//        if (head == null) {
//            head = node;
//            return;
//        } else {
//            node.next = head;
//            head = node;
//        }
//          可以不判断非空链表头插;
        node.next = head;
        head = node;

    }

    //O(N)
    public void addLast(int elem) {
        Node node = new Node(elem);
        //当head为null时不能直接进行head.next所以需要把头节点为空的情况单独列出来；
        if (head == null) {
            head = node;
            return;
        } else {
            Node cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
            /*错误代码
            while (cur != null) {
                cur = cur.next;
            }
            cur = node;*/
            //cur此时不能和节点联系起来（不是Node的字段）;
            // 要想将链表串联起来必须.next;
        }
    }

    //index从零开始
    public void addIndex(int index, int elem) {
        Node node = new Node(elem);
        int len = getLength();
        //index==len就是尾插了
        if (index > len || index < 0) {
            return;
        }
        if (index == 0) {
            node.next = head;
            head = node;
            return;
        }
        Node cur = head;
        //找到索引前一个位置处;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        node.next = cur.next;
        cur.next = node;
    }

    private Node getIndexPos(int index) {
        Node cur = this.head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public boolean contains(int toFind) {
        Node cur = head;
        while (cur != null) {
            if (cur.date == toFind) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public void remove(int toRemove) {
        if (contains(toRemove)) {
            Node cur = this.head;
            //首元素删除；
            if (cur.date == toRemove) {
                head = cur.next;
            } else {
//                需要找前一个节点进行删除
                while (cur.next.date != toRemove) {
                    cur = cur.next;
                }
                cur.next = cur.next.next;
            }
        } else {
            System.out.println("NO Found");
            return;
        }
    }
//


    public void RemoveAll(int toRemove) {
        if (head == null) {
            return;
        }
        Node cur = head;
        while (cur.next != null) {
            //从第二个元素开始判断cur.next即第二个节点的地址（引用）；
            if (cur.next.date == toRemove) {
                //跳两格
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

//        //优化代码
//        Node prev = head;
//        Node cur = head.next;
//        while (cur != null) {
//            if (cur.date == toRemove) {
//                prev.next = cur.next;//prev跳两格
//                cur = cur.next;
//            } else {
//                prev = prev.next;//或者 prev = cur
//                cur = cur.next;
//            }
//        }
        //判断是否删除头节点
        if (head.date == toRemove) {
            head = head.next;
        }
    }


    public void clear() {
        head = null;
    }

    // 当要删除的元素不是第一个元素时，找到要删除元素的前一个位置
    private Node searchPrev(int toRemove) {
        if (this.head == null) {
            return null;
        }
        Node prev = this.head;
        while (prev.next != null) {
            if (prev.next.date == toRemove) {
                return prev;
            }
            prev = prev.next;
        }
        // 返回 null 表示没找到
        return null;
    }

    public int getLength() {
        Node cur = head;
        int len = 0;
        while (cur != null) {
            cur = cur.next;
            len++;
        }
        return len;
    }

    public void display() {
        System.out.print("[");
        for (Node node = this.head;
             node != null; node = node.next) {
            System.out.print(node.date);
            if (node.next != null) {
                // 如果不是最后一个元素就加上 , 否则不加
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public Node midNode() {
        if (head == null || head.next == null) {
            return head;
        }
        int len = 0;
        Node cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        cur = head;
        for (int i = 0; i < len / 2; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public Node FindKthToTail(int k) {
//缺省了k的合法性判断；
        if (head == null) {
            return head;
        }
        Node fast = head;
        Node slow = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

//    //逆置
//    public Node reverseList() {
//        if (head == null || head.next == null) {
//            return head;
//        } else {
//            Node prev = null;
//            Node cur = head;
//            while (cur != null) {
//                Node next = cur.next;
//                cur.next = prev;
//                prev = cur;
//                cur = next;
//
//            }
//            this.head = prev;
//            return head;
//        }
//    }
//
//        //空链表
//        if (head == null) {
//            return head;
//        }
//        //
//        Node prev = null;
//        Node cur = head;
//        Node newhead = null;
//        while (cur != null) {
//            Node next = cur.next;
//            if (next == null) {
//                newhead = cur;
//            }
//            cur.next = prev;
//            prev = cur;//若用prev = prev.next刚开始会有空指针异常；
//            cur = next;
//        }
//        return newhead;
////        空链表直接返回
////        if(head==null){
////            return;
////        }
////        while(cur.next != null){
////            Node next = cur.next;
////            cur.next = prev;
////            prev = cur;
////            cur = next;
////        }
////        Node newhead = cur;


    public Node mergeTwoLists(LinkedList list1, LinkedList list2) {
        LinkedList list3 = new LinkedList();
        Node cur3 = list3.head;
        if (list1.head == null) {
            return list2.head;
        }
        if (list2.head == null) {
            return list1.head;
        }
        Node cur1 = list1.head;
        Node cur2 = list2.head;
        while (cur1 != null && cur2 != null) {
            if (cur1.date >= cur2.date) {
                Node node = new Node(cur2.date);
                if (list3.head == null) {
                    list3.head = node;
                    cur3 = list3.head;
                    cur2 = cur2.next;
                } else {
                    cur3.next = node;
                    cur3 = cur3.next;
                    cur2 = cur2.next;
                }
            } else {
                Node node = new Node(cur1.date);
                if (list3.head == null) {
                    list3.head = node;
                    cur3 = list3.head;
                    cur1 = cur1.next;
                } else {
                    cur3.next = node;
                    cur3 = cur3.next;
                    cur1 = cur1.next;
                }
            }
        }
        if (cur1 != null) {
            cur3.next = cur1;
        } else {
            cur3.next = cur2;
        }
        return list3.head;
    }

    public void getIntersectionNode(Node headA, Node headB) {
        int lenA = 0;
        int lenB = 0;
        Node cur1 = headA;
        Node cur2 = headB;
        while (cur1 != null) {
            cur1 = cur1.next;
            lenA++;
        }
        while (cur2 != null) {
            cur2 = cur2.next;
            lenB++;
        }
        cur1 = headA;
        cur2 = headB;
        if (lenA > lenB) {
            int len = lenA - lenB;
            for (int i = 0; i < len; i++) {
                cur1 = cur1.next;
            }
        } else {
            int len = lenB - lenA;
            for (int i = 0; i < len; i++) {
                cur2 = cur2.next;
            }
        }
        while (cur1.next != cur2.next) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        System.out.println(cur1.next.date);

    }

    public boolean chkPalindrome() {
        if (head == null || head.next == null) {
            return true;
        }
        int len = 0;
        Node cur = head;
        while (cur != null) {
            cur = cur.next;
            len++;
        }
        cur = head;
        len /= 2;
        for (int i = 0; i < len; i++) {
            cur = cur.next;
        }
        Node prev = null;
        Node head2 = null;
        while (cur != null) {
            if (cur.next == null) {
                head2 = cur;
            }
            Node next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        Node cur1 = head;
        Node cur2 = head2;
        while (cur1 != null && cur2 != null) {
            if (cur1.date != cur2.date) {
                return false;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return true;
    }

    public void deleteDuplication() {
        if (head == null || head.next == null) {
            return ;
        }
        while (head != null && head.next != null && head.date == head.next.date) {
            while (head.next != null && head.date == head.next.date) {
                head = head.next;
            }
            head = head.next;
        }
        Node cur = head.next;
        Node prev = head;
        int index  = 0;
        while (cur!=null ) {
            if (cur.next != null && cur.date == cur.next.date) {
                while (cur.next != null && cur.date == cur.next.date) {
                    cur = cur.next;
                }
                cur = cur.next;
                index = 1;
            }
            if(index == 0){
                //此时cur为不重复元素,只需移动prev和cur即可
                prev = prev.next;
                cur = cur.next;
            }
            if(index == 1){
//                此时的cur指向或为null,或为一个不重复元素；
                prev.next = cur;
                index = 0;
            }
        }

    }
}


