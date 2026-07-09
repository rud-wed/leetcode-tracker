-- Last updated: 7/9/2026, 10:24:34 AM
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      SELECT IFNULL(
          (
              SELECT salary
              FROM (
                  SELECT DISTINCT salary, 
                         DENSE_RANK() OVER (ORDER BY salary DESC) AS rnk
                  FROM Employee
              ) AS ranked
              WHERE rnk = N
          ),
      NULL)
  );
END;

