public class URL {
    public static void urlParse(String url){
        int i = url.indexOf("://");
        String 协议名 = url.substring(0,i);
        url = url.substring(i+3);
        if(url.contains("@")){
            i = url.indexOf("@");
            String 登录信息 = url.substring(0,i);
            url = url.substring(i+1);
        }
        i = url.indexOf("/");

        String 服务器地址 = url.substring(0,i);
        if(服务器地址.contains(":")){
            String address[] = 服务器地址.split(":");
            String 端口 = address[1];
            服务器地址 = address[0];
        }
        url = url.substring(i+1);
        i = url.indexOf("?");
        String 带层次的文件路径 = url.substring(0,i);
        url = url.substring(i+1);
// TODO
        i = url.indexOf("#");
        String 查询字符串 = url.substring(0,i);
        url = url.substring(i+1);



    }
}
