class Node {
    public int data;
    public Node next;

    //？？？？
    public Node() {

    }

    public Node(int data) {
        this.data = data;
    }
}

class LinkedList {
    public Node head;

    //头插法
    public void addFirst(int date) {
        Node node = new Node(date);
        node.next = head;
        head = node;
    }

    public void addLast(int date) {
        Node node = new Node(date);
        if (head == null) {
            head = node;
        } else {
            Node tail = head;
            while (tail.next != null) {
                tail = tail.next;
            }
            tail.next = node;
        }
    }

    public void addIndex(int date, int pos) {
        //pos合法性检查pos从0开始
        int size = 0;
        Node cur = head;
        while (cur != null) {
            cur = cur.next;
            size++;
        }
        if (size >= pos) {
            if (pos == 0) {//头插
                addFirst(date);
            } else {
                Node node = new Node(date);
                cur = head;
                for (int i = 0; i < pos - 1; i++) {
                    cur = cur.next;//找前驱
                }
                node.next = cur.next;
                cur.next = node;
            }
        }
    }

    public void remove(int val) {
        Node cur = head;
        while (cur.data != val && cur.next.next != null) {
            cur = cur.next;
        }
        if (cur.data == val) {
            cur.data = cur.next.data;
            cur.next = cur.next.next;
        } else {
            Node next = cur.next;
            if (next.data == val) {
                cur.next = null;
            }
        }
    }

    public void removeAll(int val) {
        if (head == null) {
            return;
        }
        Node prev = head;
        Node cur = head.next;
        while (cur != null) {
            if (cur.data == val) {
                prev.next = cur.next;
                cur = cur.next;
            } else {
                cur = cur.next;
                prev = prev.next;

            }
        }
    }

    public Node reserve() {
        if (head == null || head.next == null) {
            return head;
        }
        Node cur = head;
        Node prev = null;
        while (cur != null) {
            Node next = cur.next;

            cur.next = prev;
            prev = cur;
            cur = next;

        }
        head = prev;
        return head;
    }

    public Node midNode() {
        int size = 0;
        Node cur = head;
        while (cur != null) {
            cur = cur.next;
            size++;
        }
        cur = head;
        for (int i = 0; i < size / 2; i++) {
            cur = cur.next;
        }
        return head;
    }

    public void KthNode(int k) {
        //此处省略K的合法性判断
        Node fast = head;
        Node slow = head;
        while (fast != null && k != 0) {
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        System.out.println(slow.data);
    }

//    public Node partition(int x) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        Node cur = head;
//        Node Smallhead = new Node(-1);
//        Node Tail1 = Smallhead;
//        Node Largehead = new Node(-1);
//        Node Tail2 = Largehead;
//        while (cur != null) {
//            if (cur.data < x) {
//                Tail1.next = cur;
//                Tail1 = Tail1.next;
//            } else {
//                Tail2.next = cur;
//                Tail2 = Tail2.next;
//            }
//            cur = cur.next;
//        }
//        Tail2.next = null;
//        Tail1.next = Largehead.next;
//        return Smallhead.next;
//    }

    public Node partition(int x) {
        Node beforeStart = null;
        Node beforeEnd = null;
        Node afterStart = null;
        Node afterEnd = null;
        Node cur = this.head;
        while (cur != null) {
//            Node curNext = cur.next;
//            cur.next = null;
            if(cur.data < x) {
                //第一次插入到beforeStart
                if(beforeStart == null) {
                    beforeStart = cur;
                    beforeEnd = cur;
                }else {
                    beforeEnd.next = cur;
                    beforeEnd = cur;
                }
            }else {//cur.data >= x
                if(afterStart == null) {
                    afterStart = cur;
                    afterEnd = cur;
                }else {
                    afterEnd.next = cur;
                    afterEnd = cur;
                }
            }
            cur = cur.next;
        }
        //如果第一个线段没有数据 没有比基准小的数据
        afterEnd.next=null;
        if(beforeStart == null) {
            return afterStart;
        }
        beforeEnd.next = afterStart;
        return beforeStart;
    }
    public void show() {
        System.out.print("{");
        for (Node cur = head; cur != null; cur = cur.next) {
            System.out.print(cur.data);
            if (cur.next != null) {
                System.out.print(",");
            }
        }
        System.out.println("}");
    }
}

