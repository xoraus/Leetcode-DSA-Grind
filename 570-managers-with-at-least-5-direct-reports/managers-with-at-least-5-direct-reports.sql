# Write your MySQL query statement below

SELECT name
FROM Employee 
WHERE id IN
    (SELECT managerId
    FROM Employee E
    GROUP BY (managerId)
    HAVING COUNT(id) >=5 )
