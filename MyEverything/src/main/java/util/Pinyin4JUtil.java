package util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;

import java.util.HashSet;
import java.util.Set;

public class Pinyin4JUtil {
    /**
     * 中文字符格式
     */
    private static final String CHINESE_PATTERN = "[\\u4E00-\\u9FA5]";
    /**
     * 拼音输出格式
     */
    private static final HanyuPinyinOutputFormat PINYIN_OUTPUT_FORMAT = new HanyuPinyinOutputFormat();
    static {
        PINYIN_OUTPUT_FORMAT.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        PINYIN_OUTPUT_FORMAT.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        PINYIN_OUTPUT_FORMAT.setVCharType(HanyuPinyinVCharType.WITH_V);
    }

    public static String[]get (String hanyu){
        String [] array = new String[2];
        StringBuilder pinyin = new StringBuilder();
        StringBuilder pinyin_first = new StringBuilder();
        for (int i = 0; i < hanyu.length(); i++) {
            try {
//                获取第i个汉字的拼音数组
                String[] pinyins = PinyinHelper.toHanyuPinyinStringArray(hanyu.charAt(i));
//                if()第i个汉字是数字或字母返沪的数字是空数组
                if(pinyins==null||pinyins.length==0){
                    pinyin.append(hanyu.charAt(i));
                    pinyin_first.append(hanyu.charAt(i));
                }else {//else将数组去重后添加进二维数组的第i处
                    pinyin.append(pinyins[0]);
                    pinyin_first.append(pinyins[0].charAt(0));
                }
            }catch (Exception e){
//                对于无法识别的字符API会抛出一个异常
                pinyin.append(hanyu.charAt(i));
                pinyin_first.append(hanyu.charAt(i));
            }
        }
        array[0] = pinyin.toString();
        array[1]=pinyin_first.toString();
        return array;
    }
    public static String[][] get(String hanyu,boolean fullSpell){
        String[][] array = new String[hanyu.length()][];
        for(int i = 0;i < hanyu.length();i++){
            try {
                //                获取第i个汉字的拼音数组
                String[] pinyins = PinyinHelper.toHanyuPinyinStringArray(hanyu.charAt(i),PINYIN_OUTPUT_FORMAT);
                if(pinyins == null || pinyins.length == 0){
//                    原样添加
                    array[i] = new String[]{String.valueOf(hanyu.charAt(i))};
                }else {
//                    去重添加
                    array[i] = unique(pinyins,fullSpell);
                }
            } catch (Exception e){
                array[i] = new String[]{String.valueOf(hanyu.charAt(i))};
            }
        }
        return array;
    }
    private static String[] unique(String[] pinyins,boolean fullSpell) {
        Set<String> set = new HashSet<>();
        for(int i = 0;i < pinyins.length;i++){
            if(fullSpell){
                set.add(pinyins[i]);
            }else {
                set.add(String.valueOf(pinyins[i].charAt(0)));
            }
        }
        return set.toArray(new String[set.size()]);
    }
    public static boolean containsChinese(String str){
        return str.matches(".*"+"CHINESE_PATTERN"+".*");
    }
}
