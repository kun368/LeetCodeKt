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

SELECT CASE WHEN COUNT(1) = 0 THEN NULL ELSE a.Salary END AS SecondHighestSalary
FROM ( SELECT DISTINCT(Salary) AS Salary FROM Employee ORDER BY Salary DESC LIMIT 1, 1) a
