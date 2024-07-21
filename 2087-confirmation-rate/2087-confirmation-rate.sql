# Write your MySQL query statement below
select user_id , 
if(num = 0 , 0 , round(num/den,2)) as confirmation_rate

from 
(select  s.user_id , 
if(c.user_id is null , 0 , 
(select count(*) from Confirmations where user_id = s.user_id and action = "confirmed") 
) as num ,
count(*)  as den 

from Signups s left join Confirmations c
on s.user_id = c.user_id
group by s.user_id  ) as nt

