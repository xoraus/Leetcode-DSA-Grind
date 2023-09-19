# Write your MySQL query statement below

WITH OrderCounts AS (
    SELECT customer_number, COUNT(order_number) AS NumOrders
    FROM Orders
    GROUP BY customer_number
)
SELECT customer_number
FROM OrderCounts
WHERE NumOrders = (
    SELECT MAX(NumOrders) 
    FROM OrderCounts
);
