-- 13. The state (or territory) name and sales tax for the top five highest sales of tax of all states and territories. 
-- Order the results by sales tax with the highest number first, then by state name alphabetically.
-- (5 rows)
Select state_name, sales_tax
From state
Order by sales_tax Desc
Limit 5;
