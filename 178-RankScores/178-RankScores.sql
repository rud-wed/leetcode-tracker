-- Last updated: 7/9/2026, 10:24:33 AM
SELECT 
    s.score,
    (SELECT COUNT(DISTINCT t.score) 
     FROM Scores t 
     WHERE t.score >= s.score) AS `rank`
FROM Scores s
ORDER BY s.score DESC;
