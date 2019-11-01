public class YueSeFu {
    public int Survivor(int n) {
        int[] array = new int[n];
        int count = 0;
        while (n > 1) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == 0) {
                    count++;
                    if (count == 3) {
                        array[i] = 1;
                        count = 0;
                        n--;
                    }
                }
            }
        }
        for (int i = 0; i < array.length ; i++) {
            if(array[i]==0){
                return i;
            }
        }
        return -1;
    }
}
