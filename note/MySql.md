### MySQL
RDBMS即关系数据库管理系统(Relational Database Management System)的特点：
1.数据以表格的形式出现 
2.每行为各种记录名称 
3.每列为记录名称所对应的数据域 
4.许多的行和列组成一张表单 
5.若干的表单组成database 
##### RDBMS的一些术语：
- 数据库: 数据库是一些关联表的集合。 
- 数据表: 表是数据的矩阵。在一个数据库中的表看起来像一个简单的电子表格。 
- 列: 一列(数据元素) 包含了相同的数据, 例如邮政编码的数据。 
- 行：一行（=元组，或记录）是一组相关的数据，例如一条用户订阅的数据。 
- 冗余：存储两倍数据，冗余可以使系统速度更快。 
- 主键：主键是唯一的。一个数据表中只能包含一个主键。你可以使用主键来查询数据。 
- 外键：外键用于关联两个表。 
- 复合键：复合键（组合键）将多个列作为一个索引键，一般用于复合索引。 
- 索引：使用索引可快速访问数据库表中的特定信息。索引是对数据库表中一列或多列的值进行排序的一种结构。类似于书籍的目录。 
- 参照完整性: 参照的完整性要求关系中不允许引用不存在的实体。与实体完整性是关系模型必须满足的完整性约束条件，目的是保证数据的一致性。 


##### 数据库操作
* 连接数据库
```
root@host]# mysql -u root -p
Enter password:******
```
* 创建数据库
```sql
CREATE DATABASE [IF NOT EXISTS] db_name [create_specification [, 
create_specification] ...]
create_specification:
 [DEFAULT] CHARACTER SET charset_name
 [DEFAULT] COLLATE collation_name
```
说明：
大写的表示关键字
[] 是可选项
CHARACTER SET: 指定数据库采用的字符集
COLLATE: 指定数据库字符集的校验规则
示例：
创建名为 db_test1 的数据库
CREATE DATABASE db_test1;
说明：当我们创建数据库没有指定字符集和校验规则时，系统使用默认字符集：utf8，校验规
	* create database if not exists t1 character set utf8mb4;
		
	* 删 drop
	* 显示 show
	
- 表操作
	* 增 create table
	* 删 drop
	* 显示表结构 desc
	别名：用空格空开即可；
	in 和 OR
##### [SQL](https://github.com/eternityfantastic/study/blob/master/note/SQL.md)	 
