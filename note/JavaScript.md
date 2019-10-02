### JavaScript
*基本特点      
	1. JavaScript是一种属于网络的脚本语言,已经被广泛用于Web应用开发,常用来为网页添加各式各样的动态功能,
为用户提供更流畅美观的浏览效果。通常JavaScript脚本是通过嵌入在HTML中来实现自身的功能的。   
	2. 是一种解释性脚本语言（代码不进行预编译）。
	3. 主要用来向HTML（标准通用标记语言下的一个应用）页面添加交互行为。   
	4. 可以直接嵌入HTML页面，但写成单独的js文件有利于结构和行为的分离。   
	5. 跨平台特性，在绝大多数浏览器的支持下，可以在多种平台下运行（如Windows、Linux、Mac、Android、iOS等）。
Javascript脚本语言同其他语言一样，有它自身的基本数据类型，表达式和算术运算符及程序的基本程序框架。
Javascript提供了四种基本的数据类型和两种特殊数据类型用来处理数据和文字。
而变量提供存放信息的地方，表达式则可以完成较复杂的信息处理。
* 基本语法
	1. 与HTML结合方式
		1. 内部js:
			* 定义<script>,标签体内容就是js代码
		2. 外部js
			* 定义<script>,通过src属性引入外部的js文件
		* 注意：
			1. <script>可以定义在html的任何位置，但定义的位置会影响到执行顺序。
			2. <script>可以定义多个
	2. 注释
		1. 单行注释：//
		2. 多行注释：/**/
	3. 数据类型:
		1. 原始数据类型（基本数据类型）
			1. number:数字。整数/小数/NaN
			2. string：字符串。"abc","a",'abc'
			3. boolean:true或false
			4. null:一个对象为空的占位符
			5. undefined:未定义。如果一个变量没有给初始化值，则会被赋予默认值undefined 
		2. 引用数据类型：对象
	4. 变量	
		* 变量：一块存储数据的内存空间
		* Java语言类型是强类型，而JavaScript是弱类型
			* 强类型：在开辟空间时，定义了空间将来要存储的数据的数据类型。只能用来存储固定类型的数据
			* 弱类型： 在开辟空间时，不定义将来存储的数据类型，可以存放任意类型数据
		* 语法
			* var 变量名 = 初始化值
		* typedof运算符：获取变量的类型
			* 注: null运算后得到的是object
	5. 运算符（详情略）
		* 其他类型转化为Boolean
			1. number：0或NaN为假，其余为真
			2. string：空字符为假，其余为真
			3. null和undefined都是false
			4. 对象：所有对象都是true
				
	6. 流程控制（略）
	7. 特殊语法
		* 变量的定义可以使用var,也可以不用
			* 用var：定义的变量是局部变量
			* 不用var:定义的变量是全局变量
			
* 基本对象
	* Function:函数对象
		1. 创建
			1. var fun = new Function(形式参数列表，方法体);
			2. 
				```
				function 方法名称（形式参数）{
				方法体
				}
			3. 	```
				```
				var 方法名 = Function（形式参数列表）{
				方法体
				}
				```
		2. 方法：
		3. 属相：
			length:代表形式参数的个数
		4. 特点：
			1. 方法定义时，形参类型和返回值类型都不用写
			2. 方法是一个对象，如果定义同名方法，会覆盖
			3. 方法的调用只与方法名有关，和参数列表无关
			4. 在方法声明中有一个隐藏的内置对象（数组），argument，封装所有的实际参数
		5. 调用
			方法名（实参列表）
	2. Array：数组对象
		1. 创建
			1. var arr = new Array(元素列表)；
			2. var arr = new Array(默认长度)；
			3. var arr = [元素列表]；
		2. 方法
			1. join(参数)：将数组的元素按照给定符号拼接；
			2. push()向数组的末尾添加一个或多个元素，并返回新的长度
		3. 属性
			length:数组的长度
	3. Boolean
	4. Date：日期对象
		1. 创建：
			var date = new Date();
		2. 方法：
			toLocaleString():返回当前date对象对应的时间本地字符串格式    
			getTime():获取毫秒数，1970年1月1日至今的毫秒数      			
	5. Math；数学对象
		1. 创建：
			* 特点：Math对象不用创建，直接使用。Math.方法名；
			* 常用方法：
				* random()返回[0,1）之间的随机数；
				* ceil（x）向上取整;
				* floor(x)向下取整;
				* round(x)四舍五入;
			3. 属性：
				PI
	6. Number
	7. String
	9. RegExp:正则表达式对象
		1. 正则表达式：定义字符串的组成规则				
				1. 单个字符[]
					如：[a]只能由a组成，[ab]由a或b组成，[a-zA-Z0-9]由字母或数字组成       
					* 特殊符号代表特殊含义的单个字符：    
						\d：单个数字0~9
						\w:单个字符[a~zA~Z0~9_]
				2. 量词符号
					？：表示出现0次或1次
					*：表示出现0次或多次
					+：表示s出现1次或多次
					{m,n}: m <= 表示出现次数<=n
					* 如果m缺省：{,n}最多n次
					* 如果n缺省：{m,}最少m次
				3. 开始结束符
					* ^:开始
					* $:结束
		2. 正则对象
			1. 创建
				1. var reg = new RegExp("正则表达式")
				2. var reg = /正则表达式/
										
			2. 方法
				1. test(参数)：验证指定的字符串是否符合正则表达式的规范		
					
<<<<<<< HEAD
### DOM简单学习
	* 概念：Document Object Model文件对象模型
		* 将标记语言文档的各个组成部分，封装为对象。可以使用这些对象，对标记语言文档进行CRUD的动态操作
	* W3W DOM 标记被分为3个不同的部分：
		* 核心DOM-针对任何结构化文档的标准模型
			* Document:文档模型
			* Element：元素对象
			* Attribute：属性对象
			* Text：文本对象
			* Comment：注释对象
			* Node:节点对象，其他5个的父对象
		* XML DOM-针对XML文档的标准模型
		* HTML DOM-针对HTML文档的标准模型	
	#### 核心DOM模型
		* Document：文件对象
			1. 创建（获取）：在HTML DOM模型中可以使用window对象来获取
				1. window。document
				2. document
			2. 方法：
				1. 获取Element对象：
					1. getElementById():根据id属性值获取元素对象。id属性值一般唯一
					2. getElementsByTagName():根据元素名称获取元素对象们。返回值是一个数组。	 	
					3. getElementsByClassName():根据Class属性值获取元素对象们。返回值是一个数组	 	
					4. getElementsByName():根据name属性值获取元素对象们。返回值是一个数组。	
				2. 创建其他DOM对象：
					createAttribute（name）	 	
					createComment（）	 	
					createElement（）	 	
					createTextNode（）
				3. 属相
		* Element:元素对象
			1. 获取/创建：通过document来获取车创建
			2. 方法：
				1. removeAttribute():删除属性
				2. setAttribute():设置属性
		*Node：节点对象，其他５个对象的父对象
			* 特点：所有dom对象都可以被认为是一个节点
			* 方法：
				*CURD DOM树：
					* appendChild():向节点的子节点列表的结尾添加心得子节点
					* removeChild():删除（并返回）当前节点的指定子节点
					* replaceChild():用新节点替换一个子节点。
			* 属性：
				* parentNode返回节点的父节点。
	#### HTML DOM
		1. 标签体的设置和获取：innerHTML
		2. 使用HTML元素对象的属性
		3. 控制元素样式
								
### BOM简单学习								
													 
=======
							
													 
>>>>>>> f062def6d5bf2848d9e208202ad6dcac91d2e950
