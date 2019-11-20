class BB extends Object{
    static {
        System.out.println("LB1");
    }
    public BB(){
        System.out.println("CB");
    }
    static {
        System.out.println("LB2");
    }
}
class AA extends BB{
    static {
        System.out.println("LA");
    }
    public AA(){
        System.out.println("CA");
    }

}
public class TestClass {
    public static void main(String[] args) {
        new AA();

    }
}
