# bankdemo
A springboot demo App for banking transactions

need to clone and import the project into IDE

run the this sql script to create database

DROP DATABASE IF EXISTS bank;
CREATE DATABASE bank;
GRANT ALL ON bank.* TO 'admin'@'localhost' IDENTIFIED BY 'admin';
FLUSH PRIVILEGES;


run this sql script to create a current account

use bank;
insert into current(acc_number,balance,overdraft_limit)
values(121231,50000,-100000);
