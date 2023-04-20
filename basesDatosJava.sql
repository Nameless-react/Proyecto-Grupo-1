create database Proyecto;
use Proyecto;
drop table Cliente;
create table Cliente(
	identification varchar(20) primary key not null,
	name varchar(20) not null,
    firstSurName varchar(20) not null,
    secondSurName varchar(20) not null,
    age int not null,
    email varchar(20) not null,
    password varchar(20) not null,
    state boolean not null,
    nickName varchar(20) not null
);


create table Earnings(
	earnings bigint not null
);

select * from Cliente;
select * from Earnings;