import java.io.File;

public class JavaIO {

    public static void main(String[] args) {

        File f1 = new File("D:"+File.separator+ "test");
        System.out.println(f1.isAbsolute());
        System.out.println(f1.isDirectory());
        System.out.println(f1.isFile());

    }

}
