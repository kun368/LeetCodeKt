# drop table if exists Employee;
# drop table if exists Bonus;
# Create table If Not Exists Employee
# (
#     empId      int,
#     name       varchar(255),
#     supervisor int,
#     salary     int
# );
# Create table If Not Exists Bonus
# (
#     empId int,
#     bonus int
# );
# Truncate table Employee;
# insert into Employee (empId, name, supervisor, salary)
# values ('3', 'Brad', NULL, '4000');
# insert into Employee (empId, name, supervisor, salary)
# values ('1', 'John', '3', '1000');
# insert into Employee (empId, name, supervisor, salary)
# values ('2', 'Dan', '3', '2000');
# insert into Employee (empId, name, supervisor, salary)
# values ('4', 'Thomas', '3', '4000');
# Truncate table Bonus;
# insert into Bonus (empId, bonus)
# values ('2', '500');
# insert into Bonus (empId, bonus)
# values ('4', '2000');


select a.name as name, b.bonus as bonus
from Employee a
         left join Bonus b
                   on a.empId = b.empId
where b.bonus is null
   or b.bonus < 1000