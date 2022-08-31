create table product(
ProductID int auto_increment primary key comment '商品ID',
ProductName varchar(100) comment '商品名字',
ProductPhoto varchar(300) comment '商品图片地址',
Classify varchar(100) comment '商品分类',
Description varchar(500) comment '商品描述',
Souce varchar(300) comment '出产地',
Price Long comment '价格',
Inventory Long comment '库存',
Specification varchar(100) comment '商品规格',
Label varchar(50) comment '标签',
Status boolean comment '状态（上下架）' 

)auto_increment=1000

alter table product auto_increment=1015

update product
set ProductID=1005 where ProductID=5

set auto_increment_offset=1015
set auto_increment_increment=5
set auto_increment=1015
product