create table classify(
Classify varchar(100),
ClassifyID int auto_increment primary key
)
alter table classify auto_increment=100
set session auto_increment_increment=100
set session auto_increment_offset=100
show session variables like 'auto_inc%'