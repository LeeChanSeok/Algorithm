-- 코드를 작성해주세요
SELECT COUNT(*) as FISH_COUNT
FROM FISH_INFO I
JOIN FISH_NAME_INFO N
on I.FISH_TYPE = N.FISH_TYPE
WHERE N.FISH_NAME = 'BASS' or N.FISH_NAME = 'SNAPPER'