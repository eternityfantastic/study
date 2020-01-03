package servlet.http_servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class Response {
    String version;
    String statusAndDescribe = "200 ok";
    Map<String, String> header = new HashMap<>();
    StringBuilder bodyBuilder = new StringBuilder();
    public Response(){
        //动态页面需要手动设置文本解析方式
        header.put("Content-Type", "text/html; charset=UTF-8");
    }

    public void setStatusAndDescribe(String statusAndDescribe) {
        this.statusAndDescribe = statusAndDescribe;
    }


    public void setHeader(String k, String v) {
        header.put(k, v);
    }


    public void setBodyBuilder(String s) {
        bodyBuilder.append(s);
    }

    //将 response —> String —>流

    public String buildResponse() throws UnsupportedEncodingException {

        StringBuilder responseBuilder = new StringBuilder();
        // 响应行
        responseBuilder.append("HTTP/1.0 ").append(statusAndDescribe).append("\r\n");
        // 响应头
        int contentLength = bodyBuilder.toString().getBytes("UTF-8").length;
        header.put("Content-Length", String.valueOf(contentLength));

        for (Map.Entry<String, String> entry : header.entrySet()) {
            responseBuilder.append(entry.getKey()).append(": ").append(entry.getValue()).append("\r\n");
        }
        // 空行
        responseBuilder.append("\r\n");
        // 正文
        responseBuilder.append(bodyBuilder);

        return responseBuilder.toString();
    }

    /**
     * 将拼装好的response写回客户端输出流；
     */

    public void writeAndFlush(OutputStream os) throws IOException {
        String response = buildResponse();
        System.out.println(response);
        os.write(response.getBytes("UTF-8"));
        os.flush();
    }

}