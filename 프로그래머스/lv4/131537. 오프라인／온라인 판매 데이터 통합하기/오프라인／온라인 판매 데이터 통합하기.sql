SELECT DATE_FORMAT(T1.sales_date, '%Y-%m-%d') AS SALES_DATE, PRODUCT_ID, USER_ID, SALES_AMOUNT 
FROM
    (SELECT * FROM ONLINE_SALE
    UNION ALL
    SELECT OFFLINE_SALE_ID, NULL, PRODUCT_ID, SALES_AMOUNT, SALES_DATE 
    FROM OFFLINE_SALE) T1
WHERE DATE_FORMAT(T1.sales_date, '%Y-%m') = '2022-03'
ORDER BY SALES_DATE ASC, PRODUCT_ID ASC, USER_ID ASC