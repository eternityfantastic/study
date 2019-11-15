public class Queue {
    QuNode head;
    QuNode tail;

    public QuNode offer(int date){
        if (head == null){
            tail = new QuNode(date);
            head = tail;
        }else{
            tail.next = new QuNode(date);
            tail = tail.next;
        }
        return head;
    }
//    出队
    public void poll(){
        if(head != null){
          QuNode ret = head;
          head = head.next;

        }
    }
}
 class QuNode{
    int val;
    QuNode next;

     public QuNode(int val) {
         this.val = val;
         this.next = null;
     }
 }
