### Java基本类型
在Java这门面向对象语言中，将一切皆对象的思想阐述的淋漓尽致，
然而对于普通基本类型，如果同样在 堆中new一个对象,将变得有点墨守成规，
不够高效，于是Java在提供对应变量封装类的不变条件下，
还采用了与C/C++同样的方法，也就是说，可以不用new来创建变量，
而是创建一个并非引用类型的“自动”变量。这个变量直接存储“值”
并置于堆栈中，因此更加有效;
Java语言提供了八种基本类型。六种数字类型（四个整数型，两个浮点型），一种字符类型，还有一种布尔型。   
#### byte：
byte 数据类型是8位  
byte 类型用在大型数组中节约空间，主要代替整数，因为 byte 变量占用的空间只有 int 类型的四分之一；          
例子：byte a = 100，byte b = -50。
#### short：
short 数据类型是 16 位   
Short 数据类型也可以像 byte 那样节省空间。一个short变量是int型变量所占空间的二分之一；            
例子：short s = 1000，short r = -20000。        
#### int：
int 数据类型是32位    
一般的整型变量默认为 int 类型；            
#### long：      
long 数据类型是 64 位                 
这种类型主要使用在需要比较大整数的系统上；      
例子： long a = 100000L，Long b = -200000L。          
"L"理论上不分大小写，但是若写成"l"容易与数字"1"混淆，不容易分辩。所以最好大写。
若不写L则当long类型变量赋值了大于int性的数字，此时会报错（数字大于Interger.MAX_VALUE);     
#### float：
float 数据类型是单精度、32位、符合IEEE 754标准的浮点数；         
float 在储存大型浮点数组的时候可节省内存空间；       
浮点数不能用来表示精确的值，如货币；           
例子：float f1 = 234.5f。           
#### double：            
double 数据类型是双精度、64 位、符合IEEE 754标准的浮点数；             
浮点数的默认类型为double类型；                  
double类型同样不能表示精确的值，如货币；         
例子：double d1 = 123.4。           
#### boolean：        
boolean数据类型表示一位的信息 ；                        
__只有两个取值：true 和 false；__           
这种类型只作为一种标志来记录 true/false 情况；                
默认值是 false；                 
例子：boolean one = true。          
#### char（\u0000~\uffff）：
char类型是一个单一的 16 位 Unicode 字符；                           
char 数据类型可以储存任何字符；      
例子：char letter = 'A';      
##### Java没有sizeof
为什么Java中没有sizeof()?
Java是一种纯面向对象的编程语言，
它将内存管理的细节都交给Java Virtual Machine（JVM）进行。
同时Java是一种跨平台的语言，可移植性好，它在数据类型在机器中的大小都相同。
而在C/C++中需要sizeof是因为移植，不同的数据类型在不同的机器上大小可能不同，程序员必须知道对应的数据类型大小。
#### Java数据类型的安全性
int a = Interger.MAX_VALUE+1;                 
编译时会直接报错，而不是将二进制进行截取;
```
int a = 10;
short b = 10;
b = a;
```
大类型数据赋值给小类型数据会直接报错，需要强转；另外char和short之间也需要强转；                     
__如果右值整数不加修饰，默认为int;取值只有（-2^31~2^31-1）;__         
__如果右值小数不加修饰，默认为double;__
__总之右值默认是int或double,使用时小心溢出__.
*再将数据读入内存时，（变量初始化），先判断右值是否大于左值范围; 再判断右值是否符合规范（有没有L，f等修饰，没有的话就按int和double算，这时候就有可能会有超出int范围的错误）;             
__只有参与运算后才会有整型提升，以方便cpu读取数据；__
#### 参与运算时会整形自动转换         
__计算机会将所有小于int范围的类型转换为int型，然后进行运算操作（CPU存取数据是以4个字节进行处理）；__
``` java
int a = Integer.MAX_VALUE;
short b = Short.MAX_VALUE;
System.out.println(a+1);	//-2147483648
System.out.println(b+1);	//32768,由于b进行了整型提升已经不是short了，所以b不是-32768
short c = 10;
short d = c + 1 ;					// 编译错误，1是int型；
```
```
demo：              
      char a = 12;                     
      short b =123;                     
      short c = a+b;										//此时会将a和b相加的结果先进行整形提升变为int；而后int赋值给short将出现错误；               
      int a =123;
      int b=122;                
      long  c = (long )a+b；							//为避免整型相加后溢出；                  
      long d =0xffff ffff ff；         ❌		//此时默认0xffff ffff ff是int型结果发现溢出了就会报错；            
      long d =0xffff ffff ffL     ✔		//同样的浮点型变量会默认转化为double；           
      float a = 12.3;							❌              
      float a = 12.3f;						✔            
      double b = 12.3;						✔                
      double b = 12.3D;						✔          
```            
### 基本类型对应的封装类
### 高精度数
- BigInteger：支持任意精度的整数。
	* 
- BigDecimal：支持任意精度的定点数。（进行货币计算）