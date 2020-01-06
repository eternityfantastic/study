package util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Util {
    private static final String[] sizeName = {"B", "KB", "MB", "GB"};
    private static final String Data_PATH="yyyy-mm-dd HH:mm:ss";

    private static DateFormat DATE_FORMAT = new SimpleDateFormat(Data_PATH);
//文件大写格式转换
    public static String parseSize(long size) {
        int i = 0;
        while (size >= 1024 && i < sizeName.length - 1) {
            size /= 1024;
            i++;
        }
        return size + sizeName[i];
    }
//修改日期格式转换
    public static String parseDate(long lastModified) {
        return DATE_FORMAT.format(new Date(lastModified));
    }

    public static void main(String[] args) {
        System.out.println(parseSize(1025));
        TreeSet
    }
}
