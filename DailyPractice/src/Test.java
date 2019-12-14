public class Test {
    static {
        System.out.println("加载了");
    }
    static String sb = "sb";
    public static void hello() {

        System.out.println("hello");
    }
//    public static void main(String[] args) {
//        A a = new B();
//    }
}

abstract class A{
    protected abstract float f();
}
class B extends A{

    @Override
    public float f(){
        return  1;
    }
}