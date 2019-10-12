###  String 
是不可变的对象, 因此在每次对 String 类型进行改变的时候其实都等同于生成了一个新的 String 对象，
然后将指针指向新的 String 对象，所以经常改变内容的字符串最好不要用 String ，
因为每次生成对象都会对系统性能产生影响，特别当内存中无引用对象多了以后， 

``` java
String s1 = "a";
String s2 = s1+"b";				//重新创建一个对象值为是s1+"b",后将新创建的对象赋值给s2;此时常量池没有ab,
因此会在堆中创建一个对象指向常量池变量，在栈中创建引用，引用堆中对象；
String s3 = "a"+"b";			//JVM将其优化成:s3 = "ab",没有中间变量；
System.out.println(s2 == "ab"); //false
System.out.println(s3 == "ab"); //true
```
demo：
问题：

