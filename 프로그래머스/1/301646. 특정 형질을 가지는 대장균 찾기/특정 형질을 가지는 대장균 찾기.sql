-- 코드를 작성해주세요
# 1번 4 3번 1 4번 3 2번 2
SELECT COUNT(ID) AS COUNT
FROM ECOLI_DATA
WHERE (GENOTYPE & 2 = 0) 
  AND ((GENOTYPE & 4) > 0 OR (GENOTYPE & 1) > 0);