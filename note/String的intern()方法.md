#### 摘要
java.lang.String中的public native String intern();返回值：如果常量池中有此字符，那么就返回字符串常量池中的字符的地址,由于字符串常量池也在堆上，所以返回的也是堆上的地址；如果字符串常量池没有此字符，就将这个对象的地址放入字符串常量池中，并返回放入的对象地址；

```java
public class StringConstruct {
    public static void main(String[] args) {
        String s1=new String("A")+new String("B");
        System.out.println(s1==s1.intern());
        System.out.println(s1=="AB");
    }
}
```
结果都是true;
#### 逐句分析
```java
String s1=new String("A")+new String("B");
```
 这一句会在常量池中创建A、B并在堆上存储A和B在常量池的引用， 在栈上创建引用变量s1，而s1引用的对象实体是"AB",因此会在堆上创建"AB",同时把"AB"的地址复制给s1;
 注意此时并没有把"AB"放在字符串常量池中
 
 ```java 
  System.out.println(s1==s1.intern());
```
执行s1.intern()方法时JDK1.6和1.7是不同的：  
**对于JDK1.6**:它会检查常量池中有没有s1引用的字符串，如果没有就会将这个字符串添加进去;然后返回这个常量在常量池上的地址（引用）；
**对于JDK1.7** 同样它会先检查常量池中有没有s1引用的字符串，如果没有就会将这个字符串的引用(就是s1存储的内容，也就是''AB"在堆上的地址)添加进去，然后返回这个常量的在堆上的引用（地址）；
分析语句 s1 == s1.intern() :  s1中存储的是堆上"AB"的地址；而s1.intern()返回这个常量的在堆上的引用；这也就是为什么s1 == s1.intern()结果是true了       
```java
System.out.println(s1=="AB");
```
这一句"AB"代表一个匿名对象，可以看作s2 = "AB",然后比较（s1 == s2）在创建s2对象时由于可以找到，通过常量池上存储的引用或字面值常量找到。所以s2存储的从常量池中取得”AB“的堆上地址（s1的值），结果也是true; 
简单画图看一下：![在这里插入图片描述](https://img-blog.csdnimg.cn/20191103160056583.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3NpbmF0XzM4MTcwOTEw,size_16,color_FFFFFF,t_70)

在看一个例子：
这是一个新的程序，不受的上面例子的影响；
```java
	String s = new String("A");
        s.intern();
        String s2 = "A";
        System.out.println(s == s2);
```
先说一下运行结果吧：**false**
逐行分析：
```java
String s = new String("A");
```
这一行会在常量池中先查找能不能找到A或A 的引用，很显然没有，那么就会在常量池创建字符A，然后在堆上创建对象，对象中存储常量池字符的地址，同时在栈上创建s，s存储堆上对象的地址；
那么在执行第二句
```java
s.intern();
```
这时常量池已经有了”A“，此方法就会返回常量池上”A”的地址；
第三句
```java
String s2 = "A";
```
此时将不会在堆上重新创建对象了，s2直接存储常量池的“A“的地址；
那么结果就显而易见了；
在看例子
```java
String s3 = new String("A") + new String("B");
s3.intern();
String s4 = "AB";
System.out.println(s3 == s4);

```
s3.intern();执行这个代码是常量池就存储了”AB“堆上对象的地址；
String s4 = "AB";此时s4s2直接存储常量池中存储的“AB“的对象地址；
那么结果就显而易见了为true；
需要补充一点前面说的常量池中存储的是：堆上对象内存的地址或常量直接值；其实Java1.7之后常量池也是在堆上，所以常见一个常量池中有的对象时，栈上的引用直接的常量池数据，就是堆上的；






