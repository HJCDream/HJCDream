alter table product add constraint FK_Classify foreign key(Classify) references classify(Classify)

create table searchhistory(
SearchHistoryId int auto_increment primary key comment '搜索历史ID',
UserID int comment '用户ID,外键',
SearchHistory varchar(50) comment '搜索历史',
constraint FK_SearchHistory foreign key(UserID) references user(UserID)
)

create table browsinghistory(
BrowsingHistoryId int auto_increment primary key comment '浏览历史ID',
UserID int comment '用户ID,外键',
BrowsingHistory varchar(250) comment '浏览历史网址',
constraint FK_BrowsingHistory foreign key(UserID) references user(UserID)
)

create table shopcar(
ShopCarId int auto_increment primary key comment '购物车ID',
UserID int comment '用户ID',
ProductName varchar(100) comment '商品名称',
ProductID int comment '商品ID',
constraint FK_ShopCarUser foreign key(UserID) references user(UserID)
)
alter table shopcar add constraint FK_ShopCarProduct foreign key(ProductID) references product(ProductID)

create table Address(
AddressID int auto_increment primary key comment '地址ID',
UserID int comment '用户ID',
Province varchar(30) comment '省',
City varchar(30) comment '市',
District varchar(30) comment '区',
DetailedAddress varchar(250) comment '详细地址',
PhoneNum varchar(11) comment '电话号码',
UserName varchar(50) comment '收货人名称',
constraint FK_Address foreign key(UserID) references user(UserID)
)

create table coupon(
CouponID int auto_increment primary key comment '优惠券ID',
UserID int comment '用户ID',
CouponContent varchar(250) comment '优惠券内容',
Status boolean comment '状态，可用与否',
constraint FK_Coupon foreign key(UserID) references user(UserID)
)

create table favorite(
UserID int comment '用户ID',
ProductID int comment '商品ID',
constraint FK_favoriteUser foreign key(UserID) references user(UserID),
constraint FK_favoriteProduct foreign key(ProductID) references product(ProductID)

)

create table ordere(
OrderID int auto_increment primary key comment '订单编号',
UserID int comment '用户ID',
StartDate DateTime comment '订单创建时间',
ProductID int comment '商品ID',
Status varchar(20) comment '状态',
constraint FK_OrderUser foreign key(UserID) references user(UserID),
constraint FK_OrderProduct foreign key(ProductID) references product(ProductID)
)


