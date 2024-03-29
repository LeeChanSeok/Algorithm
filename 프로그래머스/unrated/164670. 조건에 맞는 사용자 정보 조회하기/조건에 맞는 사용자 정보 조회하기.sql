select USER_ID, NICKNAME, 
concat(CITY, " ", STREET_ADDRESS1, " ", STREET_ADDRESS2) 전체주소,
concat(LEFT(TLNO,3), "-", SUBSTR(TLNO, 4, 4), "-", RIGHT(TLNO,4)) 전화번호

from USED_GOODS_USER 
where USER_ID in (
  select WRITER_ID
  from USED_GOODS_BOARD
  group by WRITER_ID
  having count(*) >= 3
)
order by 1 desc