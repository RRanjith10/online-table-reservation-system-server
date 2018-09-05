DROP TABLE IF EXISTS customer;
create table customer (
	email_id varchar(255) not null, 
	cust_name varchar(255), 
	password varchar(255), 
	phone_no varchar(255), 
	primary key (email_id));
