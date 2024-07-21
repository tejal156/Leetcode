# Write your MySQL query statement below

select d.name as Department , 
e.name as Employee , 
e.salary as Salary
from Department d inner join Employee e
on d.id = e.departmentId 
where  
(
    select count( distinct salary) 
    from Employee ei
    where d.id = ei.departmentId 
    and ei.salary > e.salary
      
) < 3 
