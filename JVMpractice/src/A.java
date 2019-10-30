public class A {
    int a = 10;
    void fun1() {
        fun3();
    }

    void fun3() {
        System.out.println(a);
    }
}

class B extends A {
    @Override
    void fun3() {
        System.out.println(a);
    }

    public static void main(String[] args) {
        B b = new B();
        A a = new A();
        a.fun1();
        b.fun1();
    }
}
