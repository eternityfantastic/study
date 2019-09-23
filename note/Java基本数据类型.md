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
一般地整型变量默认为 int 类型；            
例子：int a = 100000, int b = -200000。      
#### long：      
long 数据类型是 64 位                 
这种类型主要使用在需要比较大整数的系统上；      
例子： long a = 100000L，Long b = -200000L。          
"L"理论上不分大小写，但是若写成"l"容易与数字"1"混淆，不容易分辩。所以最好大写。     
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
只有两个取值：true 和 false；           
这种类型只作为一种标志来记录 true/false 情况；                
默认值是 false；                 
例子：boolean one = true。          
#### char：
char类型是一个单一的 16 位 Unicode 字符；                           
char 数据类型可以储存任何字符；      
例子：char letter = 'A';      
整型变量会默认转成int类型；只有在数字常量赋值给变量时，会视变量为对应变脸类型；
基本类型对应的封装类
-----------
#####待补充
#### 整形自动转换         
计算机会将所有小于int范围的类型转换为int型；
demo：              
      char a = 12;                     
      short b =123;                     
      short c = a+b;//此时会将a和b先进行整形提升变为int；而后int赋值给short将出现错误；               
      int a =123;int b=122;                
      long  c = (long )a+b；为避免整型相加后溢出；                  
      long d =0xffff ffff ff；❌//此时默认0xffff ffff ff是int型结果发现溢出了就会报错；            
      long d =0xffff ffff ffL  ✔同样的浮点型变量会默认转化为double；           
      float a = 12.3;❌              
      float a = 12.3f;✔            
      double b = 12.3;✔                
      double b = 12.3D;✔                
