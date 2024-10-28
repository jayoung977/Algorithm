-- 코드를 입력하세요
SELECT I.REST_ID, REST_NAME, FOOD_TYPE, FAVORITES, ADDRESS, ROUND(AVG(REVIEW_SCORE),2) AS SCORE
FROM REST_INFO AS I 
JOIN REST_REVIEW AS R ON I.REST_ID = R.REST_ID
GROUP BY REST_ID
HAVING ADDRESS LIKE "서울%"
ORDER BY SCORE DESC, FAVORITES DESC