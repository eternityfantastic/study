public class 异常 {
    public static int method(){
        int a = 0 ;
        try {
            a = 10 ;
            return a;
        }catch (Exception e){
            return 3;
        }finally {
            return 9;
        }
    }
}
