import java.util.ArrayList;

public class RemoveAllCollection {
    public ArrayList<Object> RemoveAll(String s1, String s2) {
        ArrayList<Object> list1 = new ArrayList<>();
        ArrayList<Object> list2 = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            list1.add(s1.charAt(i));
        }
        for (int i = 0; i < s2.length(); i++) {
            list2.add(s2.charAt(i));
        }
        boolean b = list1.removeAll(list2);
        return list1;
    }

    public ArrayList<Object> RemoveAll2(String s1, String s2) {
        ArrayList<Object> list1 = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            if (!s2.contains(s1.charAt(i) + "")) {
                list1.add(s1.charAt(i));
            }
        }

        return list1;
    }
}

class TestRemove {
    public static void main(String[] args) {
        RemoveAllCollection removeAllCollection = new RemoveAllCollection();
        ArrayList<Object> objects = removeAllCollection.RemoveAll2("welcome to bit", "come");
        System.out.println(objects);


    }
}

