CREATE TABLE score (
	sid VARCHAR(10) PRIMARY KEY,
	sname VARCHAR(10),
	score INT
);

--多行插入
INSERT INTO score (sid,sname,score)
VALUES
	("123456","CourageHe",99),
	("123457","CourageHe2",98),
	("123458","CourageHe3",97),
	("123459","CourageHe4",97);
	
--成绩名次
SELECT * FROM score 
ORDER BY score;

--根据学号查找
SELECT * FROM score WHERE sid='123456'

--不及格
SELECT * FROM score WHERE score < 60;