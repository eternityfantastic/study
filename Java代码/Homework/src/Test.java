public class Test {
    public static void main(String[] args) {
    DuLinkList list = new DuLinkList();
    list.addFirst(4);
    list.addFirst(3);
    list.addFirst(2);
    list.addFirst(1);
    list.addLast(5);
    list.addLast(6);
    list.addLast(7);
    list.addLast(8);
    list.forwardDisplay();
    list.reverseDisplay();
    }
}
