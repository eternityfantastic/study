import java.util.*;
import java.util.LinkedList;

public class CollectionTest {
    public static void iterCollection(Collection col){
//        迭代器一去不复返
        Iterator iterator = col.iterator();
        while(iterator.hasNext()){
            Object next = iterator.next();
            System.out.println(next);
        }
    }
    public static void main(String[] args) {
        Collection<Integer> collection = new ArrayList<Integer>();
        System.out.println(collection.isEmpty());
        System.out.println(collection.size());
        collection.add(1);
        (collection).add(3);
        (collection).add(4);
        (collection).add(5);
        (collection).add(6);
        (collection).add(7);
        System.out.println(collection.size());
        System.out.println(collection);
        Collection<Integer> c = new ArrayList<>();
//        Collection<Integer> c = new LinkedList<>();
        c.add(3);
        c.add(6);
        //使用addAll会把另一个集合中的元素(内容)添加进集合中,而如果直接add一个集合,他会把集合当作一个元素进行添加
        collection.addAll(c);
//        boolean add = ((ArrayList<Integer>) collection).add((ArrayList<Integer>)c);
        System.out.println(collection.containsAll(c));

        System.out.println("======================");

        Map<String, String> map = new HashMap();
        map.put("1", "one");
        map.put("1", "zero");
        map.put("2", "one");
        map.put("3", "two");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey());
        }


    }
}
