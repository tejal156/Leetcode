# Write your MySQL query statement below
-- select l1.num as ConsecutiveNums  , sum(  if(l2.id - l1.id = 1 and l1.num = l2.num , 1, 0)  ) as c
-- select l1.* , l2.*  , sum(  if(l2.id - l1.id = 1 and l1.num = l2.num , 1, 0)  ) as c
-- from Logs l1 cross join Logs l2
-- group by l1.num 
-- having sum(  if(l2.id - l1.id = 1 and l1.num = l2.num , 1, 0)  )>=2

-- -- select l1.num as ConsecutiveNums
-- select l1.* , l2.*
-- from Logs l1 cross join Logs l2
-- where l2.id - l1.id = 1 and l1.num = l2.num
-- -- group by l1.num
-- -- having count(l2.id) >= 2
-- order by l1.num

select distinct num as ConsecutiveNums
from Logs l
where 
(select num from Logs where id = l.id) = (select num from Logs where id = l.id+1)
and 
(select num from Logs where id = l.id+2) = (select num from Logs where id = l.id+1)