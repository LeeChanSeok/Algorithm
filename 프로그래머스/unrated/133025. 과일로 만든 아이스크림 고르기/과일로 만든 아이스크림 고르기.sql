select f.FLAVOR
from FIRST_HALF f, ICECREAM_INFO i
where f.TOTAL_ORDER > 3000 and f.FLAVOR = i.FLAVOR and i.INGREDIENT_TYPE = 'fruit_Based'
order by f.TOTAL_ORDER desc