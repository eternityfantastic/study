public class Josepfu {
    Node head;
    Node tail;

    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public void insert(Node insert) {
        if (head == null) {
            insert.next = insert;
            head = insert;
            tail = insert;
        } else {
            insert.next = head;
            tail.next = insert;
            tail = tail.next;
        }
    }

    public void display() {
        if (head == null) {
            return;
        } else {
            Node cur = head;
            while (cur.next != head) {
                System.out.println(cur.val);
                cur = cur.next;
            }
            System.out.println(cur.val);

        }
    }

    public void arrToList(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            insert(new Node(arr[i]));
        }
    }

    public void lastPersion(Node head, int m) {
        int i = 1;
        Node cur = head;
        while (cur.next != cur) {
            i++;
            cur = cur.next;
            if (i % m == 0) {
                cur.val = cur.next.val;
                cur.next = cur.next.next;
            }
        }
        this.head = cur;
    }
}

class JTest {
    public static void main(String[] args) {
        Josepfu j = new Josepfu();
        j.arrToList(new int[]{1, 2, 3, 4, 5});
        j.display();
        j.lastPersion(j.head, 2);
        j.display();

    }

}
