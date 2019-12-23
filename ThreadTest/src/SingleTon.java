//public class SingleTon {
//    private SingleTon() {
//    }
//    private static volatile SingleTon singleTon = null;
//
//    public static SingleTon getInstance() {
//        if (singleTon == null) {
//            synchronized (SingleTon.class) {
//                if (singleTon == null) {
//                    SingleTon singleTon = new SingleTon();
//                }
//            }
//        }
//        return singleTon;
//    }
//}
public class SingleTon {
    private static class SingletonHolder {
        private static final SingleTon INSTANCE = new SingleTon();
    }

    private SingleTon() {
    }

    public static final SingleTon getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
