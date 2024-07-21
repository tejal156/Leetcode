# Write your MySQL query statement below

(select u.name as results 
from MovieRating m left join Users u
on m.user_id = u.user_id
group by m.user_id 
order by count(*) desc , u.name asc
limit 1) 

union all

(select mn.title as results 
from MovieRating m left join Movies mn
on m.movie_id = mn.movie_id
where m.created_at >= "2020-02-01" and  m.created_at < "2020-03-01"
group by m.movie_id 
order by avg(m.rating) desc , mn.title asc
limit 1 )
