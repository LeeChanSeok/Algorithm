select LEFT(PRODUCT_CODE, 2) CATEGORY, count(*) PRODUCTS
from PRODUCT
group by CATEGORY
order by 1