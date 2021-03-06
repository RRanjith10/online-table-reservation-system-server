DROP TABLE IF EXISTS booking;
create table booking (
	booking_id integer not null auto_increment, 
	bill_total bigint, 
	booked_date varchar(255), 
	email_id varchar(255) not null, 
	hid integer not null, 
	primary key (booking_id));
DROP TABLE IF EXISTS customer;
create table customer (
	email_id varchar(255) not null, 
	cust_name varchar(255), 
	password varchar(255), 
	phone_no varchar(255), 
	primary key (email_id));
DROP TABLE IF EXISTS hotels;
create table hotels (
	hid integer not null, 
	address varchar(255), 
	city varchar(255), 
	hname varchar(255), 
	state varchar(255), 
	primary key (hid));