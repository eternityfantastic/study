//import java.util.*;
//
//class Node {
//    int val;
//    Node next;
//    Node random;
//
//    public Node(int val, Node next, Node random) {
//        this.val = val;
//        this.next = next;
//        this.random = random;
//    }
//
//    public Node(int val) {
//        this.val = val;
//        this.next = null;
//        this.random = null;
//    }
//}
//
//public class CopyOfRandomList {
//    public void copy(Node head) {
//
//        HashMap map = new HashMap<Node, Node>();
//        Node cur = head;
//        while (cur != null) {
//            Node newNode = new Node(cur.val);
//            if (cur.next != null) {
//                newNode.next = new Node(cur.next.val);
//            }
//            if (cur.random != null) {
//                newNode.random = new Node(cur.random.val);
//            }
//
//
//            cur = cur.next;
//        }
//    }
//
//    public void copp(Node head) {
//        HashMap<Node, Node> map = new HashMap<>();
//        Node cur = head;
//        while (cur != null) {
//            Node newNode = new Node(cur.val);
//            map.put(cur, newNode);
//            cur = cur.next;
//        }
//        cur = head;
//        while (cur != null) {
//            //key—> value;
//            map.get(cur).next = map.get(cur.next);
//            map.get(cur).random = map.get(cur.random);
//            cur = cur.next;
//        }
//    }
//
//    public static void main(String... args) {
//        HashSet<Integer> set = new HashSet<>();
//        set.add(1);
//        set.add(1);
//        set.add(1);
//        set.add(1);
//        set.add(1);
//        System.out.println(set);
//
//    }
//
//
//    class Solution {
//        public List<String> topKFrequent(String[] words, int k) {
//            HashMap<String, Integer> map = new HashMap<>();
//            for (String str : words) {
//                if (map.containsKey(str)) {
//                    map.put(str, map.get(str) + 1);
//                } else {
//                    map.put(str, 1);
//                }
//            } Set<Map.Entry<String, Integer>> entries = map.entrySet();
//            PriorityQueue<Map.Entry<String, Integer>> que = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>() {
//                @Override
//                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
////                    o1 - o2小堆
//                    if (o1.getValue().equals(o2.getValue())) {
//                        return o2.getKey().compareTo(o1.getKey());
//                    }
////                    数字你大的放前面
//                    return o1.getValue() - o2.getValue();
//                }
//            });
//            for (Map.Entry<String, Integer> entry : entries) {
//
//                if (que.size() < k) {
//                    que.add(entry);
//                } else {
//                    Map.Entry<String, Integer> top = que.peek();
//                    if (top.getValue().equals(entry.getValue())) {
//                        //value相同判断字母
//                        if (top.getKey().compareTo(entry.getKey()) > 0){
//                            que.poll();
//                            que.add(entry);
//                        }
//                    }else if(top.getValue() < entry.getValue()){
//                        que.poll();
//                        que.add(entry);
//                    }
//                }
//            }
//
//        }
//
//    }
//}
//
//}
