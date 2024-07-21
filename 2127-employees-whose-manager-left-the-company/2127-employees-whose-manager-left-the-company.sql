# Write your MySQL query statement below

select nt.employee_id 
from 
(
    select it.employee_id , it.manager_id from  Employees it where it.salary <30000 
) as nt
where  nt.manager_id not in (
    select it2.employee_id from Employees it2 
)
order by nt.employee_id
