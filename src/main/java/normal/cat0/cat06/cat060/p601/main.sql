# drop table if exists Stadium;
# Create table If Not Exists Stadium
# (
#     id         int,
#     visit_date DATE NULL,
#     people     int
# );
# Truncate table Stadium;
# insert into Stadium (id, visit_date, people)
# values ('1', '2017-01-01', '10');
# insert into Stadium (id, visit_date, people)
# values ('2', '2017-01-02', '109');
# insert into Stadium (id, visit_date, people)
# values ('3', '2017-01-03', '150');
# insert into Stadium (id, visit_date, people)
# values ('4', '2017-01-04', '99');
# insert into Stadium (id, visit_date, people)
# values ('5', '2017-01-05', '145');
# insert into Stadium (id, visit_date, people)
# values ('6', '2017-01-06', '1455');
# insert into Stadium (id, visit_date, people)
# values ('7', '2017-01-07', '199');
# insert into Stadium (id, visit_date, people)
# values ('8', '2017-01-09', '188');

with base as (select *
              from Stadium
              where people >= 100),
     ok as (select a.id aid, b.id bid, c.id cid
            from base a
                     join base b
                          on a.id + 1 = b.id
                     join base c
                          on a.id + 2 = c.id)
select distinct base.id, visit_date, people
from base
         join ok on base.id = ok.aid or base.id = ok.bid or base.id = ok.cid
order by visit_date;