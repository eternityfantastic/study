import com.sun.source.tree.TryTree;

public class ExceptionTest {
    public static void main(String[] args) {
        int a = 3;
        int b= 0;
        try {
            int c = a/b;
        }catch (Exception e){
            System.out.println("处理yichang");
        }finally {
            System.out.println("最后指向");
        }
        System.out.println("12345");
        System.out.println("12345");
    }
}
