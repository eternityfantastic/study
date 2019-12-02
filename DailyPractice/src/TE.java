public class TE <T>{
    public  void print(T[] array) {
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
    public static  <T> void print(T[] array) {
        for (T a : array) {
            System.out.println(a);
        }
    }
}

class Testtt{
    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5};
        new TE().print(arr);
    }
}
