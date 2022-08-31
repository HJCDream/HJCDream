create table user(
UserID int auto_increment not null primary key COMMENT '用户ID,主键',
UserName varchar(50) Not Null COMMENT '用户名称',
UserNum varchar(50) Not Null comment '用户账号',
PhoneNum varchar(11) comment '用户手机号',
AddressID varchar(16) comment '默认地址ID,外键',
UserImage varchar(500) comment '用户头像，写入存放在OSS阿里云上的图片网址'
)

alter table classify modify ClassifyID int
alter table classify drop primary key;
alter table classify add primary key(Classify)