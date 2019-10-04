### Bootstrap
1. 概念：一个前端开发框架，bootstrap，来自twitter。
	* 优点： 定义了许多css样式和JavaScript插件。
	* 响应式布局可以兼容不同分辨率设备
* 响应式布局
	* 同一套页面可以兼容于不同分辨率的设备
	* 实现：以来与山歌系统：将一行平均分成12个各自，可以指定元素占几个格子
	* 步骤：
		1. 定义容器：
			* 容器的分类：
				1. container：两边留白
				2. container-fluid：每一种设备都是100%宽度
		2. 定义行。样式row
		3. 定义元素。指定元素在不同设备上，所占的格子数目。样式：col-设备代号-格子数目
			* 设备代号：
				1. xs:超小屏幕（<768px）
				2. sm:小屏幕（>=768px）
				3. md:中等屏幕（>=992px）
				4. lg:大屏幕	（>=1200px）
		* 注意：
			* 一行中如果格子数超过12，则超出的部分自动换行
			* 栅格类属性可以向上兼容
			* 如果真实设备宽度小于设置的栅格属性值的最小值，会一个元素占满一整行
#### css样式和js插件
	* 按钮：class="btn btn-default"
	* 图片：
		* class="img-responsive": 图片在任意尺寸都站100%
		* 图片形状
			* class="img-rounded":方形
			* class="img-circle":圆形
			* class="img-thumbnail":相框
	* 表格
		* table
		* table-bordered
		* table—hover
	* 表单
		class="form-control"			
		
							
	 
	