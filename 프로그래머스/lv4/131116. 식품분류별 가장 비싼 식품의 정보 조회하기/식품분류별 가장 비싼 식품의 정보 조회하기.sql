select CATEGORY, PRICE MAX_PRICE, PRODUCT_NAME
from FOOD_PRODUCT
where (CATEGORY, PRICE) in (
  select CATEGORY, max(PRICE)
  from FOOD_PRODUCT  
  group by CATEGORY
  having CATEGORY in ('과자', '국', '김치', '식용유')
)
order by 2 desc