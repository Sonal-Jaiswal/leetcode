/* Write your PL/SQL query statement below */

SELECT 
    eu.unique_id,
    e.name
FROM EmployeeUNI eu 
Right JOIN Employees e
ON e.id = eu.id;