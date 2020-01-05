CREATE TABLE dbo.TB_DeptType(
	dpType SMALLINT PRIMARY KEY,--单位类别
	dpTypeName NVARCHAR(20) UNIQUE NOT NULL,--单位名称
);


--读者类别表
CREATE TABLE dbo.TB_ReaderType(
	rdType SMALLINT IDENTITY PRIMARY KEY,--读者类别
	rdTypeName NVARCHAR(20) UNIQUE NOT NULL,--读者类别名称
	CanLendQty INT,--可借书数量，
	CanLendDay INT,--可借书天数
	CanContinueTimes INT,--可续借的次数
	PunishRate FLOAT,--罚款率（元/天）
	DateValid SMALLINT NOT NULL--整数有效期（年）0表示永久有效
);

--读者信息表
CREATE TABLE TB_Reader(
	rdID INT PRIMARY KEY,--读者类别
	rdName NVARCHAR(20),--姓名
	rdSex NCHAR(1),--性别 男/女
	rdType SMALLINT NOT NULL FOREIGN KEY(rdType) REFERENCES TB_ReaderType(rdType),--读者类别（外键）
	rdDept INT,--单位代码/单位名称
	rdPhone NVARCHAR(25),--电话号码
	rdEmail NVARCHAR(25),--电子邮箱
	rdDateReg DATETIME DEFAULT GETDATE(),--读者登记日期/办证日期
	rdPhoto IMAGE,--读者照片
	rdStatus NCHAR(2),--证件状态，3个：有效、挂失、注销
	rdBorrowQty INT,--已借书数量
	rdPwd NVARCHAR(20),--读者密切（储值为123），可加密存储
	rdAdminRoles SMALLINT--管理角色0-读者、1-借书证管理、2-图书管理、4-借阅管理 8-系统管理 可组合
	);
	
SELECT *  FROM TB_Reader WHERE rdID=201702991
--图书信息表 
CREATE TABLE TB_Book(
	bkID	Int IDENTITY PRIMARY KEY ,--	图书序号【标识列，主键】
	bkCode	Nvarchar (20),--	图书编号或条码号（前文中的书号）
	bkName	Nvarchar(50),--	书名
	bkAuthor	Nvarchar(30),--	作者
	bkPress	Nvarchar(50),--	出版社
	bkDatePress	datetime,--	出版日期
	bkISBN	Nvarchar (15),--	ISBN书号
	bkCatalog	Nvarchar(30),--	分类号（如：TP316-21/123）
	bkLanguage	SmallInt,--	语言，0-中文，1-英文，2-日文，3-俄文，4-德文，5-法文
	bkPages	Int,--	页数
	bkPrice	Money,--	价格
	bkDateIn	DateTime DEFAULT GETDATE(),--	入馆日期
	bkBrief	Text,--	内容简介
	bkCover	image,--	图书封面照片
	bkStatus	NChar(2),--	图书状态，在馆、借出、遗失、变卖、销毁
);
-- 借阅信息表
CREATE TABLE TB_Borrow(
	BorrowID	BIGINT IDENTITY PRIMARY KEY,--		借书顺序号【主键】
	rdID	Int FOREIGN KEY(rdID) REFERENCES TB_Reader(rdID),--		读者序号【外键TB_Reader】
	bkID	Int	FOREIGN KEY(bkID) REFERENCES TB_Book(bkID),--	图书序号【外键TB_Book】
	ldContinueTimes	Int,--		续借次数（第一次借时，记为0）
	ldDateOut	DateTime,--		借书日期
	ldDateRetPlan	DateTime,--		应还日期
	ldDateRetAct	DateTime,--		实际还书日期
	ldOverDay	Int	,--	超期天数
	ldOverMoney	Money,--		超期金额（应罚款金额）
	ldPunishMoney	Money,--		罚款金额
	isHasReturn	Bit	DEFAULT 0,--	是否已经还书，缺省为0-未还
	OperatorLend	Nvarchar(20),--		借书操作员
	OperatorRet	Nvarchar(20),--		还书操作员
);
SELECT GETDATE();
--sp_columns TB_Reader;


--插入
SET IDENTITY_INSERT  TB_ReaderType ON;
insert into [TB_ReaderType](rdType,rdTypeName,CanLendQty,CanLendDay,CanContinueTimes,PunishRate,DateValid)values(10,'教师',12,60,2,0.05,0);
insert into [TB_ReaderType](rdType,rdTypeName,CanLendQty,CanLendDay,CanContinueTimes,PunishRate,DateValid)	values(20,'本科生',8,30,1,0.05,4);
insert into [TB_ReaderType](rdType,rdTypeName,CanLendQty,CanLendDay,CanContinueTimes,PunishRate,DateValid)	values(21,'专科生',8,30,1,0.05,3);
insert into [TB_ReaderType]	(rdType,rdTypeName,CanLendQty,CanLendDay,CanContinueTimes,PunishRate,DateValid)values(30,'硕士研究生',8,30,1,0.05,3);
insert into [TB_ReaderType]	(rdType,rdTypeName,CanLendQty,CanLendDay,CanContinueTimes,PunishRate,DateValid)values(31,'博士研究生',8,30,1,0.05,4);
--identity关闭插入模式
SET IDENTITY_INSERT  TB_ReaderType OFF;
GO

insert into [TB_DeptType]	values(10,'计算机科学学院');--教师单位为学院
insert into [TB_DeptType]	values(11,'软件工程');--

insert into [TB_DeptType]	values(12,'计算机科学与技术');
insert into [TB_DeptType]	values(13,'物联网工程');
insert into [TB_DeptType]	values(14,'网络工程');

select * from TB_DeptType


--删除
IF OBJECT_ID('dbo.TB_Borrow', 'U') IS NOT NULL
DROP TABLE dbo.TB_Borrow;


IF OBJECT_ID('dbo.TB_Book', 'U') IS NOT NULL
DROP TABLE dbo.TB_Book;

IF OBJECT_ID('dbo.TB_Reader', 'U') IS NOT NULL
DROP TABLE dbo.TB_Reader;

IF OBJECT_ID('dbo.TB_ReaderType', 'U') IS NOT NULL
DROP TABLE dbo.TB_ReaderType;

IF OBJECT_ID('dbo.TB_DeptType', 'U') IS NOT NULL
DROP TABLE dbo.TB_DeptType;