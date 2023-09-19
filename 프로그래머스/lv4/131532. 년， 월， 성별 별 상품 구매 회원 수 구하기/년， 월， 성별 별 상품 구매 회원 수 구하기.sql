select YEAR(SALES_DATE) YEAR, MONTH(SALES_DATE) MONTH, GENDER, count(distinct a.USER_ID) USERS
from USER_INFO a JOIN ONLINE_SALE b
on a.USER_ID = b.USER_ID
group by YEAR, MONTH, GENDER
having GENDER is not null
order by 1, 2, 3