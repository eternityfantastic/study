public class CommonSubmultiple {
    //    public int common(int x, int y, int z, int s) {
//        int com = 1;
//        int i = 2;
//        while (i <= 7) {
//            if (x % i == 0 && y % i == 0 && z % i == 0 && s % i == 0) {
//                com = com * i;
//                x = x / i;
//                y = y / i;
//                z = z / i;
//                s = s / i;
//                i = 2;
//            } else {
//                i++;
//            }
//        }
//        return com;
//    }
    public int common(int... arr) {
        int num = 0;
        int com = 1;
        int i = 2;
        while (i < 7) {
            for (int j = 0; j < arr.length; j++) {
                num += arr[j] % i;
            }
            if (num == 0) {
                com = com * i;
                for (int j = 0; j < arr.length; j++) {
                    arr[j] = arr[j] / i;
                }
                i = 2;
            } else {
                num = 0;
                i++;
            }
        }
        return com;
    }

    public int common(int x, int y) {
        while (x % y != 0) {
            int temp = x % y;
            x = y;
            y = temp;
        }
        return y;
    }

}
