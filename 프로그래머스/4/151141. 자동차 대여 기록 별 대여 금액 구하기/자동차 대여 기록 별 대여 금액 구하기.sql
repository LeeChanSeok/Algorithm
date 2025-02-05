-- 코드를 입력하세요
SELECT A.HISTORY_ID, ROUND(A.DAILY_FEE * (DATEDIFF(A.END_DATE, A.START_DATE) + 1) * (100 - IFNULL(P.DISCOUNT_RATE, 0)) / 100) FEE
FROM
    (SELECT H.HISTORY_ID, H.START_DATE, H.END_DATE, C.CAR_TYPE, C.DAILY_FEE, 
        (case 
             WHEN DATEDIFF(H.END_DATE, H.START_DATE)+1 >= 90 then '90일 이상'
             WHEN DATEDIFF(H.END_DATE, H.START_DATE)+1 >= 30 then '30일 이상'
             WHEN DATEDIFF(H.END_DATE, H.START_DATE)+1 >= 7 then '7일 이상'
         END
        ) DURATION_TYPE
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY H
    JOIN CAR_RENTAL_COMPANY_CAR C
    ON H.CAR_ID = C.CAR_ID
    WHERE C.CAR_TYPE = '트럭') A
LEFT JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN P
ON A.CAR_TYPE = P.CAR_TYPE and A.DURATION_TYPE = P.DURATION_TYPE
ORDER BY FEE desc, A.HISTORY_ID desc