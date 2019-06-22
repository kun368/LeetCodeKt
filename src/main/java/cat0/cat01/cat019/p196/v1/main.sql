delete
from person
where Id not in (
    select Id
    from (select min(id) AS Id
          from person
          group by Email) a
);