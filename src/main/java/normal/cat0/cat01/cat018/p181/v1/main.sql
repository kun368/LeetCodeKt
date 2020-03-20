drop table if exists Employee;
Create table If Not Exists Employee
(
    Id        int,
    Name      varchar(255),
    Salary    int,
    ManagerId int
);
insert into Employee (Id, Name, Salary, ManagerId)
values ('1', 'Joe', '70000', '3');
insert into Employee (Id, Name, Salary, ManagerId)
values ('2', 'Henry', '80000', '4');
insert into Employee (Id, Name, Salary, ManagerId)
values ('3', 'Sam', '60000', 'None');
insert into Employee (Id, Name, Salary, ManagerId)
values ('4', 'Max', '90000', 'None');

select * from Employee;

----------------------------------------------------------------


select a.Name as Employee
from Employee a
         left outer join Employee b
                         on a.ManagerId = b.Id
where a.Salary > b.Salary
;