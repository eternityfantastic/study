### HTML
HTML文档也叫做 web 页面       
* “超文本”就是指页面内可以包含图片、链接等非文本内容。（就是比普通文本强大，并非编程语言）
* “标记”就是使用标签的 方法将需要的内容包括起来。  

#### HTML语法规范
1. 文件后缀位.html或者.htm建议使用.html
2. 整个html文件由头部<head></head>和体部<body></body>组成
3. html文件由开始标签和结束标签组成
4. html文件忽略大小写，建议小写
<!DOCTYPE>声明有助于浏览器中正确显示网页。网络上有很多不同的文件，如果能够正确声明HTML的版本，浏览器就能正确显示网页内容。
例如<!DOCTYPE html> 声明为 HTML5 文档;        
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">声明为 HTML4.01 文档;        
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN""http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">声明为 HTML1.0 文档;               
<html> 元素是 HTML 页面的根元素           
<head> 元素包含了文档的元（meta）数据，如 <meta charset="utf-8"> 目前在大部分浏览器中，直接输出中文会出现中文乱码的情况，这时候我们就需要在头部将字符声明为 UTF-8 或 GBK。                
<title> 元素描述了文档的标题            
<body> 元素包含了可见的页面内容      
<h1> 元素定义一个大标题           
<p> 元素定义一个段落         
#### HTML标签学习
* 标题标签
1. h1-h6：例如<h1></h1>
2. 注释标签:	<!---->
3. 水平线<hr>
4. 换行<br>
5. 段落标签<p></p>
6. 字体标签<font></font>,相关属性color，size(1-7逐渐变大)，face设置字体 ……
7. <b></b>加粗，<i></i>斜体
* 图片标签
<img/>:相关属性src指定图片位置，width,height设置大下，alt图片无法显示时显示的信息
* 列表标签
无序列表: <u1></u1>，<li></li>每一个列表项
有序列表: <o1></o1>
* 超链接标签
HTML 链接是通过标签 <a> 来定义的.
<a href="www.跳转链接" target="_blank"></a>新打开一个页面         
<a href="www.跳转链接" target="_self"></a>将本页面变为链接页面     
* table表格
