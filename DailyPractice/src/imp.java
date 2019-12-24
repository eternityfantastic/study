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
//        imp.meth
        InterfaceTest.method01();

        byte b1=1,b2=2,b3,b6,b8;

        final byte b4=4,b5=6,b7;
//        b6 = b1 + b2;
            b6 = b4 + b5;
//        b3=(b1+b2);  /*语句1*///b1+b2是int
//
//        b6=b4+b5;    /*语句2*///
//
//        b8=(b1+b4);  /*语句3*///b1+b4是int
//
//        b7=(b2+b5);  /*语句4*///b1+b4是int且b7是final

//        System.out.println(b3+b6);//没有初始化；
    }
}
