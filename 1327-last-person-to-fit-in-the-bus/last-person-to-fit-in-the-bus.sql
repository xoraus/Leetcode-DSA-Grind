WITH CumulativeTotal AS (
    SELECT *, SUM(weight) OVER (ORDER BY turn ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW) AS running_total
    FROM Queue
)

SELECT person_name
FROM CumulativeTotal
WHERE running_total <= 1000
ORDER BY running_total DESC
LIMIT 1;
