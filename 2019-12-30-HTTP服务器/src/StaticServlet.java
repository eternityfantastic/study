import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StaticServlet extends HttpServlet{
    public static String docBase = "D:\\Study\\2019-12-30-HTTP服务器\\";
    public static Map<String, String> mimeType = new HashMap<>();

    static {
        mimeType.put("js", "application/javascript; charset=UTF-8");
        mimeType.put("css", "text/css; charset=UTF-8");
    }


    public static boolean exits(String url) {
        File file = new File(docBase + url);
        if(!file.exists() || file.isDirectory()){
            return false;
        }
        return true;
    }


    @Override
    public void doGet(Request req, Response resp) throws Exception {
        int index = req.url.lastIndexOf('.');
        String suffix = req.url.substring(index + 1);
        String contentType = mimeType.getOrDefault(suffix, "text/html; charset=UTF-8");
        resp.setHeader("Content-Type", contentType);

        // Content-Type html
        String filename = docBase + req.url;
        InputStream is = new FileInputStream(filename);
        Scanner scanner = new Scanner(is, "UTF-8");
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            resp.println(line);

        }
    }
}
