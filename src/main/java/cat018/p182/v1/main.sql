drop table if exists Person;
Create table If Not Exists Person
(
    Id    int,
    Email varchar(255)
);
insert into Person (Id, Email)
values ('1', 'a@b.com');
insert into Person (Id, Email)
values ('2', 'c@d.com');
insert into Person (Id, Email)
values ('3', 'a@b.com');


------------------------------------------------------

select distinct a.Email AS Email
from Person a
where exists(
              select *
              from Person b
              where a.Id != b.Id
                and a.Email = b.Email
          );

------------------------------------------------------

select distinct a.Email AS Email
from Person a
         join Person b
              On a.Id != b.Id and a.Email = b.Email;

------------------------------------------------------

select distinct a.Email AS Email
from Person a
         join Person b
where a.Id != b.Id
  and a.Email = b.Email;

------------------------------------------------------

select Email
from Person a
group by Email
having count(1) > 1;
