SELECT ID, PROJECT_DURATION
FROM (
    SELECT ID, DATEDIFF(month, START_DATE, FINISH_DATE) AS PROJECT_DURATION
    FROM project) AS duration_table
WHERE PROJECT_DURATION = (
    SELECT MAX(DATEDIFF(month, START_DATE, FINISH_DATE))
    FROM project
)