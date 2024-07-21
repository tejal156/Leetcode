# Write your MySQL query statement below

select if(count(*) =  1 , null , min(salary) ) as SecondHighestSalary
from 
(select distinct salary
from Employee
order by salary desc
limit 2 ) as t1
