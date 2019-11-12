public class FinalTest {
    private final char[] qq;

    FinalTest() {
        this.qq = new char[]{98, 99, 100};
    }

    public FinalTest(FinalTest t) {
        this.qq = t.qq;
    }

    public static void main(String[] args) {
        FinalTest f1 = new FinalTest();
        FinalTest f2 = new FinalTest(f1);
//            fianl i;当你改变对象的fian i值时无形
// 之中又调用了构造方法，创建了新的对象
        String s1 = "abc";
        String s2 = "def";
        String s = s1 + s2;
//        string本质就是调用了new StringBuilder().append(a).append(b).toString）
//        (不管bc是什么类型的，append方法会调用类型AbstractStringBuilder的append()方法进行转换)



    }
}
