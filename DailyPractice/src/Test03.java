public class Test03{
	public static  void main(String [] args){
		System.out.println(MyChild.str2);
	}
}
class Myparent{
	public static  Thread th = new Thread(){
		{
			System.out.println("111");
		}
	};
	
}
class MyChild extends Myparent{
	public static String str2 = "word";
	static{
		System.out.println("222");
	}
}