public class Single {
    private static volatile Single instance = null;//防止对属性instance操作是的重排序
    private Single(){};//为什么要加private
    public static Single getInstance(){
        if(instance == null){
            synchronized (Single.class){//synchronized的位置
                if(instance == null){
                    instance = new Single();
                }
            }
        }
        return instance;
    }
}
