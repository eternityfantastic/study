public class Test {
    public static void main(String[] args) {
        A a = new B();
    }
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