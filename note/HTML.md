### HTML
&lt;h1 > - &lt;h6 &gt;
HTML文档也叫做 web 页面       
* “超文本”就是指页面内可以包含图片、链接等非文本内容。（就是比普通文本强大，并非编程语言）
* “标记”就是使用标签的 方法将需要的内容包括起来。  

#### HTML语法规范
1. 文件后缀位.html或者.htm建议使用.html
2. 整个html文件由头部<head></head>和体部<body></body>组成
3. html文件由开始标签和结束标签组成
4. html文件忽略大小写，建议小写              
&lt;h1> 元素定义一个大标题           
&lt;p> 元素定义一个段落         
#### HTML标签学习
* 标题标签
* 标签分为围堵标签和自闭和标签，标签可以嵌套；在开始标签中可以定义属性，属性由键值对组成，值用引号引起来单引号双引号都可以

* 文件标签   
&lt;!DOCTYPE>声明有助于浏览器中正确显示网页。网络上有很多不同的文件，如果能够正确声明HTML的版本，浏览器就能正确显示网页内容。
例如&lt;!DOCTYPE html> 声明为 HTML5 文档;        
&lt;!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">声明为 HTML4.01 文档;        
&lt;!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN""http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">声明为 HTML1.0 文档;               
&lt;html> 元素是 HTML 页面的根元素           
&lt;head> 元素包含了文档的元（meta）数据，如 <meta charset="utf-8"> 目前在大部分浏览器中，直接输出中文会出现中文乱码的情况，这时候我们就需要在头部将字符声明为 UTF-8 或 GBK。                
&lt;title> 元素描述了文档的标题            
&lt;body> 元素包含了可见的页面内容      

* 文本标签     
1. h1-h6：例如&lt;h1 &gt;  &lt;/h1 &gt;
2. 注释标签:&lt;	!---->
3. 水平线&lt;hr>
4. 换行&lt;br>
5. 段落标签&lt;p>&lt;/p>
6. 字体标签&lt;font>&lt;/font>,相关属性color，size(1-7逐渐变大)，face设置字体 ，width,align……
   color:1. 设置为英文单词；
         2. 设置为rgb(值1，值2，值3)，值的范围是0~255;rgb(123,34,244)
         3. 设置为#值1值2值3：值为00~FF,如#00FFCC;
7. &lt;b>&lt;/b>加粗，&lt;i>&lt;/i>斜体    


* 图片标签     
&lt;img/>:相关属性src指定图片位置，width,height设置大下，alt图片无法显示时显示的信息

* 列表标签       
无序列表: &lt;u1>&lt;/u1>，&lt;li>&lt;/li>每一个列表项
有序列表: &lt;o1>&lt;/o1>
* 超链接标签
HTML 链接是通过标签 &lt;a> 来定义的.
&lt;a href="www.跳转链接" target="_blank">&lt;/a>新打开一个页面         
&lt;a href="www.跳转链接" target="_self">&lt;/a>将本页面变为链接页面    

* div是块级标签每个div标签单独占一行，span是内联标签，文本信息在一行展示，HTML为了提高程序的可阅读性，增加了header,和footer标签     

* table表格  
	* width:宽度
	* border: 边框
	* cellpadding: 定义内容和单元格的距离
	* cellspacing: 定义单元格之间的距离。如果指定为0，则单元格的线会合并成一条线；
	* bgcolor: 背景色；
	* aligh: 定义对齐方式；
1. tr: 定义行
2. td: 定义列
	* colspan:合并列
	* rowspan:合并行
3. th: 定义表头单元格
	* &lt;caption>: 表格标题
	* &lt;tbody>: 表格体部分
	* &lt;thead>: 表格头部分
	* &lt;tfoot>: 表格脚部分	
* input标签
<input> 标签用于搜集用户信息。
根据不同的 type 属性值，输入字段拥有很多种形式。
输入字段可以是文本字段、复选框、掩码后的文本控件、
单选按钮、按钮等等。
* type属性：
	* text：文本输入框，
		* placeholder:指定输入框的提示信息，当输入框的内容发生变化，会自动清空提示信息
	* password：密码输入框
	* radio：单选框
		* 注意：
			1. 要想让多个单选框事项单选的效果，则多个单选框的name属性值必须一样
			2. 一般会给每一个单选框提供value属性，指定其被选中后提交的值
			3. checked属性，可以指定默认值。	
	* file：文件选择框
	* hidden:隐藏域，用于提交一些信息
	* 按钮
		* submit：提交按钮。可以提交表单
		* button： 普通按钮
		* image：图片提交按钮
			* src属性指定图片的路径
	* label：指定输入项的文字描述信息
		* 注意 ： label的for属性一般会和input的id属性值对应。如果对应了，则点击label区域会让输入框获取焦点。
	* select：下拉列表
		* 子元素：option，指定列表项
	* textarea：文本域
		* cols指定列数，每一行有多少子
		* rows指定默认行数，会自动扩容
								
						
* 表单标签
	* 表单：
		* 概念：用于采集用户输入的数据。用于和服务器进行交互。
		* form：用于定义表单。可以定义一个范围，范围代表采集数据的范围。
			* 属性
				* action： 指定提交数据的URL
				* method：指定提交方式
					* 分类：一共有7种，2种比较常用
						* get： 
							1. 请求参数会在地址栏中显示。会封装在请求行中
							2. 请求参数大小有限制。
							3. 不太安全
						* post：
							1. 请求参数不会在地址栏中显示。会封装在请求体中
							2. 请求参数大小没有限制。
							3. 比较安全                    
				* 表单中的数据想要被提交，必须指定其name属性
							
	
