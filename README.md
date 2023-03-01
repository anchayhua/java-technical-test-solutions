# java-technical-test-solutions
Solution apis java

### **Requirements**

1. Write an **HTTP GET** method to retrieve all information from the **planets** and **people** databases from [SWAPI](https://swapi.dev/) with a **page** param. For example, if parameter **page** is 1, then you will get all elements from **page 1**. If parameter **page** is 2, then you will get all elements from **page 1** to **page 2**. If paramater **page** is 5, then you will get all elements from **page 1** to **page 5**. Consider not using the internal database, but get the data directly from SWAPI.
2. Write an **HTTP GET** method to retrieve information from the **planets** databases from [SWAPI](https://swapi.dev/) and save information in a internal database.
3. Write an **HTTP GET** method to retrieve information from **people** databases from [SWAPI](https://swapi.dev/) and save information in a internal database.

*******************************************************************************************
///////////////////////////////////////////////////////////////////////////////////////////
*******************************************************************************************


Write a query to get the customer with the highest total order value for each year-month.

The result should include the columns **year**, **month**, **customerid**, **total_monthly_order_value**. See the output under the sample data tables below for the correct data format to use. Be sure to match the format exactly. The output should be ordered by **year** and **month** in ascending order.

**Note**: In case, there are 2 customers with equal highest10 total order value, return the one with a lower customerid.

Table definitions and a data sample are given below.


::::::::::::::::::: CREATION TABLE :::::::::::::::::::

CREATE TABLE orders (
  orderid INT PRIMARY KEY,
  customerid INT NOT NULL,
  orderdate DATE NOT NULL
);

CREATE TABLE order_detail (
  orderid INT,
  productid INT NOT NULL,
  unitprice INT NOT NULL,
  quantity INT NOT NULL,
  PRIMARY KEY (orderid, productid),
  FOREIGN KEY (orderid) REFERENCES orders(orderid)
);


::::::::::::::::::: SOLUTION :::::::::::::::::::

SELECT YEAR(o.orderdate) AS year, 
       MONTH(o.orderdate) AS month, 
       od.customerid, 
       SUM(od.quantity * od.unitprice) AS total_monthly_order_value 
FROM orders o 
JOIN order_details od ON o.orderid = od.orderid 
WHERE o.orderdate IS NOT NULL 
GROUP BY YEAR(o.orderdate), MONTH(o.orderdate), od.customerid 
HAVING SUM(od.quantity * od.unitprice) = (
  SELECT MAX(monthly_order_value) 
  FROM (
    SELECT YEAR(o.orderdate) AS year, 
           MONTH(o.orderdate) AS month, 
           od.customerid, 
           SUM(od.quantity * od.unitprice) AS monthly_order_value 
    FROM orders o 
    JOIN order_details od ON o.orderid = od.orderid 
    WHERE o.orderdate IS NOT NULL 
    GROUP BY YEAR(o.orderdate), MONTH(o.orderdate), od.customerid
  ) AS monthly_orders 
  WHERE monthly_orders.year = YEAR(o.orderdate) AND monthly_orders.month = MONTH(o.orderdate)
) 
ORDER BY year ASC, month ASC, customerid ASC;
