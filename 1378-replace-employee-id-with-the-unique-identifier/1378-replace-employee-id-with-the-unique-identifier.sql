# Write your MySQL query statement below
select unique_id,name from Employees LEFT outer join EmployeeUNI on
Employees.id  = EmployeeUNI.id;
