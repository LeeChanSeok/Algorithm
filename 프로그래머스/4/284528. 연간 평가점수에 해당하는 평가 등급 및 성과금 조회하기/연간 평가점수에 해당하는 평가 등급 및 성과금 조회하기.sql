-- 코드를 작성해주세요

SELECT A.EMP_NO, A.EMP_NAME, 
         (CASE 
            WHEN B.SCORE >= 96 THEN 'S'
            WHEN B.SCORE >= 90 THEN 'A'
            WHEN B.SCORE >= 80 THEN 'B'
            ELSE 'C'
          END
        ) GRADE,
        (CASE
            WHEN B.SCORE >= 96 THEN A.SAL * 0.2
            WHEN B.SCORE >= 90 THEN A.SAL * 0.15
            WHEN B.SCORE >= 80 THEN A.SAL * 0.1
            ELSE 0
         END
        ) BONUS 
FROM HR_EMPLOYEES A
JOIN 
    (SELECT E.EMP_NO, avg(G.SCORE) SCORE
    FROM HR_EMPLOYEES E
    JOIN HR_GRADE G
    ON E.EMP_NO = G.EMP_NO
    GROUP BY EMP_NO) B    
ON A.EMP_NO = B.EMP_NO
ORDER BY A.EMP_NO


