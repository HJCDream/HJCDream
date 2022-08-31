create table comments(
ProductID int comment '商品ID',
UserID int comment '用户ID',
Comments varchar(1000) comment '评论内容',
CommentPhoto varchar(300) comment '评论图片地址',
constraint FK_CommentProduct foreign key(ProductID) references product(ProductID),
constraint FK_CommentUser foreign key(UserID) references user(UserID)
)