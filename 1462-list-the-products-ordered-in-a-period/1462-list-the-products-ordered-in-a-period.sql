# Write your MySQL query statement below

select p.product_name ,
sum(o.unit) as unit 
from Orders o left join Products p 
on o.product_id = p.product_id
where o.order_date >= "2020-02-01" and o.order_date < "2020-03-01"
group by o.product_id 
having sum(o.unit) >= 100 