# Write your MySQL query statement below

select employee_id , 
  if( did2 is null , department_id , did2) as department_id  
from 
(select employee_id ,
    department_id ,
    (
        select department_id from Employee 
        where e1.employee_id = employee_id and primary_flag = "Y"
    ) as did2 
    , 
    (
        select count(*) from Employee 
        where e1.employee_id = employee_id
    ) as c 
from Employee e1
group by employee_id) as nt
where ( c = 1 or ( c > 1 and did2 is not null ) )