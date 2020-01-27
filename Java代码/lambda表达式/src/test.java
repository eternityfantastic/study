import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {
    public static List init() {
        List<Employ> list = Arrays.asList(new Employ(18, 3000, "小粉"), new Employ(12, 3500, "小紫"), new Employ(19, 5000, "小绿"), new Employ(21, 4000, "大白"));
        return list;
    }

    //    这个方法的参数是一个接口，调用时可以传它的匿名类
    public static List<Employ> select(List<Employ> list, Compare<Employ> com) {
        List<Employ> emps = new ArrayList<>();
        for (Employ emp : list) {
            if (com.compare(emp)) {
                emps.add(emp);
            }
        }
        return emps;
    }

    public static void selectByAge(List<Employ> list) {
//        直接调用select方法
        List<Employ> employs = select(list, new Compare<Employ>() {
            @Override
            public boolean compare(Employ emp) {
                return emp.age > 18;
            }
        });
        show(employs);
    }

    public static void selectBySalary(List<Employ> list) {
        select(list, (e) ->  e.salary > 4000 );
                //.forEach(System.out::println);
    }

    public static void show(List<Employ> list) {
        for (Employ employ : list) {
            System.out.println(employ);
        }
    }

    public static void main(String[] args) {
        List<Employ> employs = init();
//        selectByAge(employs);
        selectBySalary(employs);
    }
}
