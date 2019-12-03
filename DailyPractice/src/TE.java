import java.util.ArrayList;
import java.util.List;

public class TE<T> {
    private T t;
    class TE2123 {
        public <T> void print(T[] array) {
            for (T a : array) {
                System.out.println(a);
            }
        }
    };


    public void print(T[] array) {
        for (T a : array) {
            System.out.println(a);
        }
    }
}

class TE2 {
    public <T> void print(T[] array) {
        for (T a : array) {
            System.out.println(a);
        }
    }
}

class TE3 {
    //T只有实例化时才会确定，而static方法中要用泛型此时是泛型方法而不是泛型类
    public static <T> void print(T[] array) {
        for (T a : array) {
            System.out.println(a);
        }
    }
}

class Testtt {
    public static<T> void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5};
        new TE().print(arr);
        List<?> list =   new ArrayList<>();
        List<T> list2 =   new ArrayList<>();

    }
}
