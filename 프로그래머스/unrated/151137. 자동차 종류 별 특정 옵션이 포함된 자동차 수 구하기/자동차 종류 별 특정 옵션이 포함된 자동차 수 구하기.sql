select CAR_TYPE, count(*) CARS
from CAR_RENTAL_COMPANY_CAR
where OPTIONS LIKE '%통풍시트%' or OPTIONS LIKE '%열선시트%' or OPTIONS LIKE '%가죽시트%'
group by CAR_TYPE
order by 1