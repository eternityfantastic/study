public class Test02{
	public static  void main(String [] args){
		System.out.println(MyChild.str2);
	}
}
interface Myparent{
	public static final String str1 = "hellow ";
	
}
class MyChild implements Myparent{
	public static  final String str2 = "word";
	static{
		System.out.println("222");
	}
}