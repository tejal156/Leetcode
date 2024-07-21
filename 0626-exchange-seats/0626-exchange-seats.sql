# Write your MySQL query statement below
select s1.id , If(s2.student is null , s1.student , s2.student) as student
from Seat s1 left join Seat s2
on s1.id = If( s1.id %2 = 0 , s2.id+1 , s2.id-1 )
order by s1.id asc