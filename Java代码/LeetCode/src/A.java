public class A {
    public int method(int a,int b) {
        while (true) {
           int c = a %  b;
            if(c==0){
                return b;
            }
            a = b;
            b = c;
        }
    }

}
