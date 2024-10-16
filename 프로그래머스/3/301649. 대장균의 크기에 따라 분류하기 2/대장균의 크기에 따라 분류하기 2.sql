-- 코드를 작성해주세요

SELECT A.ID,
    (CASE 
         WHEN A.PCT< 0.25 THEN 'CRITICAL'
         WHEN A.PCT< 0.5 THEN 'HIGH'
         WHEN A.PCT< 0.75 THEN 'MEDIUM'
         ELSE 'LOW'
     END) as COLONY_NAME
     
FROM (SELECT ID, 
            PERCENT_RANK() over (ORDER BY SIZE_OF_COLONY DESC) as PCT
      FROM ECOLI_DATA) A
ORDER BY A.ID
