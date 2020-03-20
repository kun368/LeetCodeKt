drop table if exists Customers;
drop table if exists Orders;

Create table If Not Exists Customers
(
    Id   int,
    Name varchar(255)
);
Create table If Not Exists Orders
(
    Id         int,
    CustomerId int
);
insert into Customers (Id, Name)
values ('1', 'Joe');
insert into Customers (Id, Name)
values ('2', 'Henry');
insert into Customers (Id, Name)
values ('3', 'Sam');
insert into Customers (Id, Name)
values ('4', 'Max');
insert into Orders (Id, CustomerId)
values ('1', '3');
insert into Orders (Id, CustomerId)
values ('2', '1');

select *
from Customers;
select *
from Orders;

----------------------------------------------------

select Name as Customers
from Customers
where id not in (select distinct CustomerId from Orders);

----------------------------------------------------

select a.Name as Customers
from Customers a left outer join Orders b
ON a.Id = b.CustomerId
where b.CustomerId is NULL;
