
select CATEGORY, sum(SALES) TOTAL_SALES

from BOOK T1 JOIN 
(
  select * 
  from BOOK_SALES s 
  where YEAR(s.SALES_DATE) = 2022 and MONTH(s.SALES_DATE) = 1
) T2
on T1.BOOK_ID = T2.BOOK_ID
group by CATEGORY
order by 1