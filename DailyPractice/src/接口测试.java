public class 接口测试 extends par implements InterfaceTest {
    @Override
    public void method() {
        System.out.println("实现了");
    }

    public static void main(String[] args) {
        接口测试 test = new 接口测试();
        test.method02();
    }
}

class par {
    public void method02() {
        System.out.println("jj");
    }

}
