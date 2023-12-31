


USE Y23S1B1
GO
CREATE TABLE [dbo].[Classes](
	[ClassID] [int] IDENTITY(1,1) NOT NULL primary key,
	[ClassName] [nvarchar](max) NOT NULL,
	[StartDate] [date] NOT NULL,
)
GO
insert into Classes values('SE1408','06/01/2020')
insert into Classes values('SE1409','07/01/2020')
insert into Classes values('SB1410','06/01/2020')
insert into Classes values('SB1411','07/01/2020')
GO
CREATE TABLE [dbo].[Students](
	[StudentID] [nvarchar](10) NOT NULL primary key,
	[StudentName] [nvarchar](30) NOT NULL,
	[BirthDate] datetime not NULL,
	[Gender] [bit] NULL,
	[ClassID] [int] NULL references Classes(ClassID)
)
GO
insert into Students values('SE05150','Tran Hung',CAST(0xCA1E0B00 AS Date),1,1)
insert into Students values('SE04931','Le Khanh',CAST(0x3A200B00 AS Date),0,1)
insert into Students values('SE01402','Nguyen Thanh',CAST(0x431D0B00 AS Date),0,3)
GO

CREATE TABLE [dbo].[Instructors](
	[InstructorID] [nvarchar](10) NOT NULL,
	[InstructorName] [nvarchar](30) NOT NULL,
	[BirthDate] datetime not NULL,
	[Gender] [bit] NULL,
	[ClassID] [int]  references Classes(ClassID),
	primary key([InstructorID],[ClassID])
)
GO
insert into Instructors values('HungDM','Doan Manh Hung',CAST(0x68220B00 AS Date),1,1)
insert into Instructors values('AnLT','Le Thi An',CAST(0xF81B0B00 AS Date),0,2)
insert into Instructors values('TuNM','Nguyen Ngoc Tu',CAST(0xCA1E0B00 AS Date),0,1)
