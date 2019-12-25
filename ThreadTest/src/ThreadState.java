public class ThreadState {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000_0000; i++) {

                }
            }
        });
        System.out.println(t.getName()+":"+t.getState());
        t.start();
        while (t.isAlive()){
            System.out.println(t.getName()+":"+t.getState());
        }
        System.out.println(t.getName()+":"+t.getState());
    }
}
