public interface MyParent {

    public static final Thread th = new Thread(){
        {
            System.out.println("111");
        }
    };
}
