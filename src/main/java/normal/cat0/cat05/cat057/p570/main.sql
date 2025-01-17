# Create table If Not Exists Employee
# (
#     id         int,
#     name       varchar(255),
#     department varchar(255),
#     managerId  int
# );
# Truncate table Employee;
# insert into Employee (id, name, department, managerId)
# values ('101', 'John', 'A', NULL);
# insert into Employee (id, name, department, managerId)
# values ('102', 'Dan', 'A', '101');
# insert into Employee (id, name, department, managerId)
# values ('103', 'James', 'A', '101');
# insert into Employee (id, name, department, managerId)
# values ('104', 'Amy', 'A', '101');
# insert into Employee (id, name, department, managerId)
# values ('105', 'Anne', 'A', '101');
# insert into Employee (id, name, department, managerId)
# values ('106', 'Ron', 'B', '101');

select a.name AS name
from Employee a
         join (select managerId
               from Employee
               group by managerId
               having count(distinct id) >= 5) b
              on a.id = b.managerId;
