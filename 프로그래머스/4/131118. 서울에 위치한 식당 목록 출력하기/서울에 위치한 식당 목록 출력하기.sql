-- 코드를 입력하세요
# SELECT R.REST_ID, R.REST_NAME, R.FOOD_TYPE,
#         R.FAVORITES, R.ADDRESS, ROUND(AVG(REVIEW_SCORE), 2)  as score FROM REST_INFO R
# JOIN REST_REVIEW RV ON RV.REST_ID = R.REST_ID
# GROUP BY R.REST_ID
# HAVING ADDRESS like '서울%'
# ORDER BY score desc, R.FAVORITES desc;

-- 코드를 입력하세요
SELECT I.REST_ID, I.REST_NAME, I.FOOD_TYPE, I.FAVORITES, I.ADDRESS, ROUND(AVG(R.REVIEW_SCORE),  2) as score
FROM REST_INFO I
JOIN REST_REVIEW R ON R.REST_ID = I.REST_ID
GROUP BY I.REST_ID
HAVING ADDRESS like '서울%'
ORDER BY score desc, I.FAVORITES desc;