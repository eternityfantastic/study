### SQL
#### SQL 是什么？
SQL，指结构化查询语言，全称是 Structured Query Language。 
SQL 让您可以访问和处理数据库。 
SQL 是一种 ANSI（American National Standards Institute 美国国家标准化组织）标准的计算机语言。

#### SQL 能做什么？
SQL 面向数据库执行查询 
SQL 可从数据库取回数据 
SQL 可在数据库中插入新的记录 
SQL 可更新数据库中的数据 
SQL 可从数据库删除记录 
SQL 可创建新数据库 
SQL 可在数据库中创建新表 
SQL 可在数据库中创建存储过程 
SQL 可在数据库中创建视图 
SQL 可以设置表、存储过程和视图的权限 

#### 使用 SQL 访问和处理数据系统中的数据
* 增（insert）
	* 不指定列进行插入(必须给所有的列进行赋值)；
		* 插入一行
		```
		INSERT INTO table_name
		VALUES (value1,value2,value3,...);
		```
		* 插入多行
		```
		INSERT INTO table_name
		VALUES (value1,value2,value3,...),
		(value1,value2,value3,...),
		.....
		(value1,value2,value3,...);
		
		```
	* 指定特定列进行插入(未指定的列将赋予默认值)
		* 插入一行
		```
		INSERT INTO table_name (column1,column2,column3,...)
		VALUES (value1,value2,value3,...);
		```
		* 插入多行
		```
		INSERT INTO table_name (column1,column2,column3,...)
		VALUES (value1,value2,value3,...),
		(value1,value2,value3,...),
		.....
		(value1,value2,value3,...);
		
		```
* 删（delect）
	* 用于删除一条或多条记录（行）
	DELETE FROM table_name WHERE some_column=some_value;
	WHERE 子句规定哪条记录或者哪些记录需要删除。如果您省略了 WHERE 子句，所有的记录都将被删除！,但表结构、属性、索引将保持不变
* 查（select）别名：用空格空开即可；
```
SELECT field1, field2,...fieldN from table_name1, table_name2...
[WHERE Clause]
[OFFSET M ][LIMIT N]

```
	SELECT column_name,column_name FROM table_name;
	用于从表中选取对应列的信息；
	SELECT column_name name FROM table_name;
	用于从表中选取column_name列的信息并起别名为name；
	SELECT DISTINCT column_name,column_name	FROM table_name;
	对指定列所构成的信息进行去重，只显示剩余的互不同的元素（所有列信息都相同，才为重复数据）

__说明：__
* 查询语句中你可以使用一个或者多个表，表之间使用逗号(,)分割，并使用WHERE语句来设定查询条件。 
* SELECT 命令可以读取一条或者多条记录。 
* 你可以使用星号（*）来代替其他字段，SELECT语句会返回表的所有字段数据 
* 你可以使用 WHERE 语句来包含任何条件。 
* 你可以通过OFFSET指定SELECT语句开始查询的数据偏移量。默认情况下偏移量为0。 
* 你可以使用 LIMIT 属性来设定返回的记录数。

* 改（update）
	UPDATE Customers SET ContactName='Alfred Schmidt', City='Hamburg' 
	WHERE CustomerName='Alfreds Futterkiste'; 
	同样WHERE 子句规定哪条记录或者哪些记录需要修改。如果您省略了 WHERE 子句，所有的记录都将被修改！
