# Write your MySQL query statement below
-- select Q.*  from 
-- (select * 
-- from Queue
-- order by turn 
-- )as Q
-- having sum(Q.weight)<= 1000 ;
select temp.person_name
from 
(select q1.person_name , sum(q2.weight) as currW 
from Queue q1 left join Queue q2 
on q1.turn >= q2.turn
group by q1.person_id
having currW <= 1000
order by currW desc
limit 1)as temp