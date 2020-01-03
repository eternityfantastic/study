package servlet.http_servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Servlet 执行以下主要任务：
 * 读取客户端（浏览器）发送的显式的数据。
 *      这包括网页上的 HTML 表单，或者也可以是来自 applet 或自定义的 HTTP 客户端程序的表单。
 * 读取客户端（浏览器）发送的隐式的 HTTP 请求数据。
 *      这包括 cookies、媒体类型和浏览器能理解的压缩格式等等。
 * 处理数据并生成结果。
 *      这个过程可能需要访问数据库，执行 RMI 或 CORBA 调用，调用 Web 服务，或者直接计算得出对应的响应。
 * 发送显式的数据（即文档）到客户端（浏览器）。
 *      该文档的格式可以是多种多样的，包括文本文件（HTML 或 XML）、二进制文件（GIF 图像）、Excel 等。
 * 发送隐式的 HTTP 响应到客户端（浏览器）。
 *      这包括告诉浏览器或其他客户端被返回的文档类型（例如 HTML），设置 cookies 和缓存参数，以及其他类似的任务。
 */

public class StaitcServlet extends Servlet{
    public final static String docBase = "D:\\Study\\project_face";
    public static Map<String, String> mimeType = new HashMap<>();

    static{
        mimeType.put("js", "application/javascript; charset=UTF-8");
        mimeType.put("css", "text/css; charset=UTF-8");
    }
    public void doPost(Request req, Response resp) throws Exception {}
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
            resp.setBodyBuilder(line);
        }
    }
    public static boolean exits(String url) {
        File file = new File(docBase + url);
        if(!file.exists() || file.isDirectory()){
            return false;
        }
        return true;
    }
}
