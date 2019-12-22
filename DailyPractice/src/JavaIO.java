import java.io.*;
import java.util.Scanner;

public class JavaIO {

    public static void parseFiles(File file,int level) {
        if (file == null || !file.exists()){
            return;
        }
        level++;
        File[] files = file.listFiles();
        for(File f : files){
            for(int i = 0 ; i < level;i++  ){
                System.out.print("\t");
            }
            //System.out.println(f.getName());
            if(!f.isDirectory()){
                System.out.println(f.getName());
            }
            if(f.isDirectory()){
                System.out.println(f.getName()+"\\");
                parseFiles(f,level);
            }
        }
    }

//    public static void parse(File file){
//        Queue<Node> queue = new LinkedList<>();
//    }
    public static InputStream 获取一个输入字节流() throws FileNotFoundException {
//        从文件获取输入流
        InputStream inputStream = new FileInputStream("D:\\text.txt");
        return inputStream;
    }
    public static String 从一个输入字节流中得到最终的字符(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[8192];
//        int len = 8192;
//        for (int i = 0; i < 8192; i++) {
//            int b = inputStream.read();
//            if(b==-1){
//                len = i;
//                break;
//            }
//            buffer[i] = (byte)b;
//        }
        char[]buff = new char[1024];
        inputStream.read(buffer);
        return new String(buffer);
//        根据输入流构造输入流，使用read方法读取流中内容
//        Reader reader = new InputStreamReader(inputStream,"UTF-8");
//        while(reader.read() != -1){
//
//        }
//        reader.read(buff);
//
//       // return new String(buffer,0,len);
////        String s= new String(buffer,0,len,"UTF-8");
////        return s;
//        BufferedReader bufferedReader  = new BufferedReader(reader);
////        带缓冲的输入流，会一次性读取一定量数据，当调用readLine()时直接在缓冲区取；
//        return bufferedReader.readLine();
    }
    public static void Method() throws IOException {
        //读取
        InputStream inputStream = new FileInputStream("D:\\text.txt");
        Reader reader = new InputStreamReader(inputStream,"UTF-8");
        BufferedReader bufferedReader = new BufferedReader(reader);
        Scanner scanner = new Scanner(inputStream);
        StringBuilder sb = new StringBuilder();
        String line;
        while((line = bufferedReader.readLine()) != null){
            sb.append(line);
            sb.append("\r\n");
        }
    }

    public static void main2() throws IOException {
       // ByteArrayInputStream byteStream = new ByteArrayInputStream("中国人民站起来了".getBytes("UTF-8"));
        OutputStream op = new FileOutputStream("D:\\text.txt");
        PrintStream ps = new PrintStream(op);

        op.write("好♥".getBytes());
        op.flush();

    }
    public static void main(String[] args) throws IOException {
//        File f1 = new File("D:" + File.separator + "test");
//        System.out.println(f1.isAbsolute());
//        System.out.println(f1.isDirectory());
//        System.out.println(f1.isFile());
//        File f = new File("D:\\Study\\ThreadTest");
//        parseFiles(f,0);
//        InputStream 字节流 = 获取一个输入字节流();
//
//        System.out.println(从一个输入字节流中得到最终的字符(字节流));
        main2();
    }
}