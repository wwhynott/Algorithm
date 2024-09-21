-- 코드를 입력하세요
SELECT MONTH(START_DATE) AS MONTH, CAR_ID, COUNT(HISTORY_ID) AS RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE car_id IN (SELECT car_id
                 FROM   car_rental_company_rental_history
                 WHERE  start_date BETWEEN '2022-08-01' AND '2022-10-31'
                 GROUP  BY car_id
                 HAVING Count(*) >= 5)
AND start_date BETWEEN '2022-08-01' AND '2022-10-31'
GROUP BY CAR_ID, MONTH
ORDER BY MONTH, CAR_ID DESC;