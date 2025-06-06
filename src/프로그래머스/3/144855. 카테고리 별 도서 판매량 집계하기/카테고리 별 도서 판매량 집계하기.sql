SELECT b.CATEGORY
    , SUM(bs.SALES) AS TOTAL_SALES
FROM BOOK b
    LEFT JOIN BOOK_SALES bs
    ON b.BOOK_ID = bs.BOOK_ID
WHERE YEAR(bs.SALES_DATE) = 2022
    AND MONTH(bs.SALES_DATE) = 1
GROUP BY 1
ORDER BY 1 ASC