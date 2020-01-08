import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class Test03{
	public static  void main(String [] args){
//		System.out.println(MyChild.str2);
		ExecutorService
		Integer [] arr = {4, 2, 3, 12};
		List<Integer> list =  new ArrayList<>();
//		List<Integer> integers = Arrays.asList(1, 4);
		Collections.addAll(list,1);
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