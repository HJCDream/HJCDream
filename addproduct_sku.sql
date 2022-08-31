alter table product drop foreign key FK_Classify
alter table product drop ProductPhoto
alter table product modify Price decimal(20,2)
alter table product rename product_sku

create table product_spu(
ProductID int auto_increment primary key comment '商品ID',
ProductName varchar(150) comment '商品名字',
ProductPhoto text comment '商品主图',
Classify varchar(100) comment '商品分类',
Status boolean comment '状态'
)

alter table product_spu change ProductID_spu ProductID_spu int auto_increment comment '商品ID'

set session auto_increment_increment=10
set session auto_increment_offset=1020
show variables like '%auto%'

show variables like '%version%'
alter table product_sku add ProductSpuID int
alter table product_sku add constraint FK_ProductSkuID foreign key(ProductSpuID) references product_spu(ProductID_spu)

create table productimg(
ProductName varchar(150) comment '商品名字',
Description varchar(150) comment '商品描述',
ProductPhoto varchar(300) comment '商品图片'
)


alter table product_spu auto_increment=1030
SHOW VARIABLES LIKE 'auto_inc%'
select p.*,k.price from product_spu p,product_sku k
alter table product_spu add Price decimal(20,2)
select * from product_spu
select * from product_sku where productspuid=1040
