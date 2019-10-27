public class Test {
      public static void main(String[] args) {
          LinkedList li = new LinkedList();
          //li.addFirst(7);
          //li.addFirst(6);

          li.addFirst(5);
          li.addFirst(5);
          li.addFirst(5);
          li.addFirst(5);
          li.addFirst(5);
          li.addFirst(3);
          li.addFirst(1);
          li.addFirst(1);
          li.display();
          li.deleteDuplication();
          li.display();

    }
}
