public class imp implements InterfaceTest,InterfaceTest02 {

    @Override
    public void method() {

    }
    /*
    当一个接口实现了default方法，另一个接口把default方法声明成了abstract的时候，
    同样如此。Java 8试图避免不明确的东西，保持严谨。如果一个方法在多个接口中都有声明，
    那么，任何一个default实现都不会被继承，你将会得到一个编译时错误。
     */

    @Override
    public void method02() {

    }

    public static void main(String[] args) {
        imp im = new imp();

        System.out.println(InterfaceTest.a);

    }
}
