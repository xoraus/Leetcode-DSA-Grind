# Write your MySQL query statement below

WITH cte AS (
    SELECT *,
        RANK() OVER (PARTITION BY customer_id ORDER BY order_date) AS order_number,
        CASE WHEN order_date = customer_pref_delivery_date THEN 'immediate' ELSE 'scheduled' END AS order_type
    FROM Delivery
)
SELECT ROUND(
    (SUM(CASE WHEN order_type = 'immediate' THEN 1 ELSE 0 END) / COUNT(*)) * 100, 2
) AS immediate_percentage
FROM cte
WHERE order_number = 1;
