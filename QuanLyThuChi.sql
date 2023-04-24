drop database if exists QuanLyThuChi;
create database if not exists QuanLyThuChi;
use QuanLyThuChi;

create table `Term`(
`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
`date` date not null,
`title` varchar(100) not null,
`price` int not null,
`description` varchar(1000) not null,
`role` enum('thu','chi')
);