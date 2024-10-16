-- 코드를 작성해주세요
SELECT A.ID
FROM ECOLI_DATA A
JOIN ECOLI_DATA B
ON A.PARENT_ID = B.ID
JOIN ECOLI_DATA C
ON B.PARENT_ID = C.ID
WHERE C.PARENT_ID is null
ORDER BY A.ID