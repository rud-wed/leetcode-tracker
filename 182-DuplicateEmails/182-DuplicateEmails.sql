-- Last updated: 7/9/2026, 10:24:26 AM
# Write your MySQL query statement below
SELECT email AS Email
FROM Person
GROUP BY email
HAVING COUNT(email) > 1;
