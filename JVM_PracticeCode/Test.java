public class Test{
	public static  void main(String [] args){
		//str2�����final ���ڱ���ʱ����ȷ��
		System.out.println(MyChild.str1);
		
	}
}
class Myparent{
	public static  String str1 = "hello ";
	static{
		System.out.println("111");
	}
}
class MyChild extends Myparent{
	static{
		System.out.println("222");
	}
	public final static  String str2 = "word";
	static{
		System.out.println("222");
	}
}