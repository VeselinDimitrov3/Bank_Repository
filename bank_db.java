create database bank_db;
use bank_db;

select * from currencies;
select * from client_statuses;
select * from clients;
select * from statuses;
select * from transactions;

select * from currencies
inner join statuses
on currencies.id = statuses.id;