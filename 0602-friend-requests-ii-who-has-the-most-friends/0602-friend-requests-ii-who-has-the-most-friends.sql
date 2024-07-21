# Write your MySQL query statement below
select id , num
from 
((select requester_id as id ,
(
    select count(*) 
    from RequestAccepted 
    where requester_id = rt.requester_id or
    rt.requester_id = accepter_id
) as num
from RequestAccepted rt
group by rt.requester_id
order by num desc
limit 1)

union

(select accepter_id as id ,
(
    select count(*) 
    from RequestAccepted 
    where requester_id = rt.accepter_id or
    rt.accepter_id = accepter_id
) as num
from RequestAccepted rt
group by rt.accepter_id
order by num desc
limit 1)

) as nt
order by num desc
limit 1