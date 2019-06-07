Create table If Not Exists Employee
(
    Id     int,
    Salary int
);
Truncate table Employee;
insert into Employee (Id, Salary)
values ('1', '100');
insert into Employee (Id, Salary)
values ('2', '200');
insert into Employee (Id, Salary)
values ('3', '300');

# =====================================================================
# 第二高的薪水
# =====================================================================

SELECT MAX(Salary) AS SecondHighestSalary
FROM Employee A
WHERE A.Salary NOT IN (
    SELECT MAX(Salary)
    FROM Employee
)
