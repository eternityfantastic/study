package servlet.http_servlet;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// /login?username=peixinchen&age=18

public class Request {
    //        请求行
    String method, url, version;


    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    //    请求体
    Map<String, String> header = new HashMap<>();
    //    请求正文
    Map<String, String> body = new HashMap<>();
//    url的请求参数；
    Map<String, String> parameters = new HashMap<>();


    //    解析请求（socket传入的流），从流将取出request，
    public static Request parseRequset(InputStream is) {
        Request request = new Request();
        Scanner sc = new Scanner(is, "UTF-8");
        String requsetLine = sc.nextLine();
        String[] split = requsetLine.split(" ");
        request.method = split[0];
        request.url = split[1];
        request.version = split[2];
        String head;
        while (!(head = sc.nextLine()).isEmpty()) {
            String[] kv = head.split(":");
            String key = kv[0].trim();
            String value = kv[1].trim();
            request.header.put(key, value);
        }
        String Body;
        return request;
    }
    public static void parseUrl(String url){

    }

}
