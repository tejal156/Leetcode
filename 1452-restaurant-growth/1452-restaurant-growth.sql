# Write your MySQL query statement below
-- select c1.visited_on , 
-- sum(c2.amount) as amount ,
-- round( avg(c2.amount) ,2 ) as average_amount
-- from Customer c1 cross join Customer c2
-- where datediff(  c1.visited_on , c2.visited_on ) <= 7 and  datediff(  c1.visited_on , c2.visited_on ) > 0
-- group by c1.visited_on
-- -- having datediff( c2.visited_on , c1.visited_on ) <= 7
-- order by c1.visited_on

-- select customer_id from Customer having  min(visited_on) = visited_on ;

-- select t1.visited_on  , sum(t2.amount) as amount ,round(avg(t2.amount),2) as average_amount
-- from Customer t1 inner join Customer t2
-- on datediff(t1.visited_on , t2.visited_on )>= 0 and datediff(t1.visited_on , t2.visited_on ) < 7 
-- group by t1.visited_on 
-- having datediff(t1.visited_on,min(t2.visited_on) )>= 6 

-- select visited_on from Customer having datediff(visited_on, min(visited_on)  )>= 7 


select c.visited_on ,
( 
    select sum(amount) 
    from Customer 
    where visited_on between
    date_sub(c.visited_on , interval 6 day) and c.visited_on
) as amount, 
round(( 
    select sum(amount)/7 
    from Customer 
    where visited_on between
    date_sub(c.visited_on , interval 6 day) and c.visited_on
),2)
 as average_amount
from  Customer c 
where visited_on >= 
(
    select date_add( min(visited_on)  , interval 6 day ) from Customer 
)
group by c.visited_on







