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
