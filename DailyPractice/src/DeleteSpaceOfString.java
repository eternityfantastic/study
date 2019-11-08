public class DeleteSpaceOfString {
    public static String deleteSpace(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < str.length() - 1; i++) {
            if (chars[i] == ' ') {
                int j = i + 1;
                while (j < str.length() - 1 && chars[j] == ' ') {
                    j++;
                }
                if (chars[j] != ' ') {
                    chars[i] = chars[j];
                    chars[j] = ' ';
                }
            }
        }
        int j = 0;
        while (chars[j] != ' ') {
            j++;
        }
        char[] chars1 = new char[j];
        for (int i = 0; i < j; i++) {
            chars1[i] = chars[i];
        }
        String s = String.valueOf(chars1);
        return s;
    }

    public static void main(String[] args) {
        String s = deleteSpace("0123 456 78 9         ");
        System.out.println("0123 456 78 9         ".length());
        System.out.println(s);
        System.out.println(s.length());
    }
}
