package test;

public class Test {

    public static void main(String[] args) {
        //Java中正则表达式的应用？
        //正则表达式是一种可以验证数据格式的表达式
        //完成校验的流程
        //1. 定义正则表达式(regex)
//		String reg = "[0-9]{17}[0-9xX]";
        //定义正则：帐号(6~12位，前两位英文(大小写不区分)，后面数字英文都可以)
        String reg = "[a-zA-Z]{2}[0-9A-Za-z]{4,10}";
        //2. 定义被校验的数据
        String value = "12356";
        //3. 调用matches方法进行校验
        if (value.matches(reg)) {
            System.out.println("正确");
        } else {
            System.out.println("错误");
        }

        /*
         * 正则表达式中常用的符号：
         * 	[]：元字符(匹配一个长度的字符)
         * 	[a-z]：匹配一个长度的小写英文
         * 	[a-z0-9A-Z]：匹配一个长度的数字或英文
         * 	{n}：匹配前元字符n次
         * 	{n,}：匹配前元字符n次及以上
         * 	{n,m}：匹配前元字符n~m次(包含边界)
         * 	+：等价于{1,}
         * 	?：等价于{0,1}
         */
    }
}





