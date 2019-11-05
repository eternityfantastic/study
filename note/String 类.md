###  String
字符串是由字符构成的一个序列，很多语言中，字符串都当作字符数组来处理，但Java中的字符串是一个对象；
string由11个构造方法和40多种处理字符串的方法；
 
##### String的字段：
private final byte[] value;用来引用一个常量，这个字符数组并没有开辟空间；
private final byte coder;
private int hash;

String是不可变的对象, 因此在每次对 String 类型进行改变的时候其实都等同于生成了一个新的 String 对象，
然后将指针指向新的 String 对象，所以经常改变内容的字符串最好不要用 String ，
因为每次生成对象都会对系统性能产生影响，特别当内存中无引用对象多了以后， 
#### 为什么String为fianl?
##### Sting的方法：

###### 常用构造器
* str= "ABC";这也是创建了一个对象，只是对象在常量池中对应设立this.value;coder; hash;并且这个常量值为“ABC”；
* new String()将“”放在常量池设立this.value;coder; hash;并且堆上创建对象指向常量池；

String​(byte[] bytes)
```java
//s="bcde"
String s = new String(new byte[]{98, 99, 100, 101});
```
String​(byte[] bytes, int offset, int length)
offset和length使用时确保不要产生越界异常；
```java
//s="e"
String s = new String(new byte[]{98, 99, 100, 101},3,1);
```
String​(byte[] bytes, int offset, int length, String charsetName)
使用charsetName来确定byte数组的于字符的对应关系；
```java
String s = new String(new byte[]{98, 99, 100, 101},1,1,"utf8");
```

String​(byte[] bytes, String charsetName)
```java
String s = new String(new byte[]{98, 99, 100, 101},"utf8");
``
String​(char[] value)
```java
String s1 = new String(new char[]{98, 99, 100, 101});
String s2 = new String(new char[]{'b','c','d','e'});
```
String​(char[] value, int offset, int count)
```java
//s=de;
String s = new String(new char[]{'b','c','d','e'},2,2);
```

* String​(String original)这个构造器可能是用的最多的一个了，虽然str="ABC"；要比str=new String("ABC")要好
但是我们还是看一下这个构造起的源码，来梳理一下String的本质
```java
public String(String original) {
        this.value = original.value;
        this.coder = original.coder;
        this.hash = original.hash;
    }
```
value是一个常引用，存储了original在常量池的地址；也就是这个对象并不存储字符串的字面值，只会存一个引用，并且引用的内容不能改；

String​(StringBuffer buffer)
String​(StringBuilder builder)
##### String的方法：
###### 字符串的比较；
boolean equals​(String str);判断两字符串是否相等
boolean equalsIgnoreCase​(String anotherString)忽略大小写判断两字符串是否相等
int compareTo​(String anotherString) 按字典序比较字符串大小，大于返回整数，小于返回负数，等于返回零，返回的数字是它们的差值；
int compareToIgnoreCase​(String str)忽略大小写进行比较；
boolean endsWith​(String suffix)判断是否以指定字符串结尾；
boolean startsWith​(String suffix)判断是否以指定字符串开始；
boolean startsWith​(String prefix, int toffset);判断字符串是否出现于指定位置

###### 字符串的长度，字符及组合字符串；
int length(); Returns the length of this string.
char charAt​(int index) ;Returns the char value at the specified index;
String concat​(String str); Concatenates the specified string to the end of this string.
###### 获取子串
CharSequence subSequence​(int beginIndex, int endIndex);返回一个从开始位置到结束位置构成的子符序列；
String substring​(int beginIndex);Returns a string that is a substring of this string.
String substring​(int beginIndex, int endIndex);Returns a string that is a substring of this string.
###### 字符串的转换、替换和分隔；
* 转换
char[] toCharArray(); Converts（转换） this string to a new character array.
String toLowerCase(); Converts all of the characters in this String to lower case using the rules of the default locale（语言环境）.
String toLowerCase​(Locale locale); Converts all of the characters in this String to lower case using the rules of the given Locale.
String toUpperCase(); Converts all of the characters in this String to upper case using the rules of the default locale.
String toUpperCase​(Locale locale);Converts all of the characters in this String to upper case using the rules of the given Locale.
String trim();返回去掉两端空格字符后的字符串；
* 替换
String replace​(char oldChar, char newChar);
Returns a string resulting from replacing all occurrences of oldChar in this string with newChar.
String replace​(CharSequence target, CharSequence replacement)
Replaces each substring of this string that matches the literal target sequence with the specified literal replacement sequence.
String replaceAll​(String regex(new), String replacement(new))
Replaces each substring of this string that matches the given regular expression with the given replacement.
String replaceFirst​(String old, String new)
Replaces the first substring of this string that matches the given regular(用) 
* 分隔
String[] split​(String regex);返回用定界符regex分割后的String数组
String[] split​(String regex, int limit);使用limit来限制对多分割几份
####### 找出字符串中的某个字符或者某个子串
int indexOf​(int ch); 
Returns the index within this string of the first occurrence（出现） of the specified character.
int indexOf​(int ch, int fromIndex) ;这个方法返回的还是字符在整个串中的index
Returns the index within this string of the first occurrence of the specified character, starting the search at the specified index.
int indexOf​(String str); Returns the index within this string of the first occurrence of the specified substring.
int indexOf​(String str, int fromIndex);Returns the index within this string of the first occurrence of the specified substring, starting at the specified index.
int lastIndexOf​(int ch);倒数第一个指定字符的index;
Returns the index within this string of the last occurrence of the specified character.
int lastIndexOf​(int ch, int fromIndex)fromIndex之前，倒数第一个指定字符的index;
Returns the index within this string of the last occurrence of the specified character, searching backward starting at the specified index.
int lastIndexOf​(String str)
Returns the index within this string of the last occurrence of the specified substring.
int lastIndexOf​(String str, int fromIndex)
Returns the index within this string of the last occurrence of the specified
###### 字符串和数组的转换
字符串变数组；
char[] toCharArray();Converts this string to a new character array.
void getChars​(int srcBegin, int srcEnd, char[] dst, int dstBegin);Copies characters from this string into the destination character array.

数组变字符串
使用构造函数或如下方法：
static String valueOf​(char[] data)；
###### 将字符变成字符串
static String valueOf​(boolean b)
Returns the string representation of the boolean argument.
static String valueOf​(char c)
Returns the string representation of the char argument.
static String valueOf​(char[] data)
Returns the string representation of the char array argument.
static String valueOf​(char[] data, int offset, int count)
Returns the string representation of a specific subarray of the char array argument.
static String valueOf​(double d)
Returns the string representation of the double argument.
static String valueOf​(float f)
Returns the string representation of the float argument.
static String valueOf​(int i)
Returns the string representation of the int argument.
static String valueOf​(long l)
Returns the string representation of the long argument.
static String valueOf​(Object obj)
Returns the string representation of the Object argument.
[最后就是inter方法了，详细请看我的博客](https://blog.csdn.net/sinat_38170910/article/details/102881117)
