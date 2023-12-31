USE [PRJ30X_PE_SPRING2023]
GO
/****** Object:  Table [dbo].[CandidateTBL]    Script Date: 3/5/2023 11:49:45 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CandidateTBL](
	[cid] [int] IDENTITY(1,1) NOT NULL,
	[cname] [varchar](150) NOT NULL,
	[gender] [bit] NOT NULL,
	[dob] [date] NOT NULL,
	[gid] [int] NOT NULL,
	[created_by] [varchar](150) NOT NULL,
 CONSTRAINT [PK_CandidateTBL] PRIMARY KEY CLUSTERED 
(
	[cid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GroupTBL]    Script Date: 3/5/2023 11:49:45 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GroupTBL](
	[gid] [int] NOT NULL,
	[gname] [varchar](150) NOT NULL,
 CONSTRAINT [PK_GroupTBL] PRIMARY KEY CLUSTERED 
(
	[gid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MemberTBL]    Script Date: 3/5/2023 11:49:45 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MemberTBL](
	[mid] [int] IDENTITY(1,1) NOT NULL,
	[mname] [varchar](150) NOT NULL,
	[gender] [bit] NOT NULL,
	[dob] [date] NOT NULL,
	[gid] [int] NOT NULL,
	[created_by] [varchar](150) NOT NULL,
 CONSTRAINT [PK_MemberTBL] PRIMARY KEY CLUSTERED 
(
	[mid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[UserTBL]    Script Date: 3/5/2023 11:49:45 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[UserTBL](
	[username] [varchar](150) NOT NULL,
	[password] [varchar](150) NOT NULL,
	[displayname] [varchar](150) NOT NULL,
 CONSTRAINT [PK_UserTBL] PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[CandidateTBL] ON 

INSERT [dbo].[CandidateTBL] ([cid], [cname], [gender], [dob], [gid], [created_by]) VALUES (1, N'Nguyen Van A', 1, CAST(N'1999-03-05' AS Date), 1, N'mra')
INSERT [dbo].[CandidateTBL] ([cid], [cname], [gender], [dob], [gid], [created_by]) VALUES (2, N'Tran Hoang B', 1, CAST(N'2005-09-12' AS Date), 2, N'mra')
INSERT [dbo].[CandidateTBL] ([cid], [cname], [gender], [dob], [gid], [created_by]) VALUES (3, N'Hoang Thi C', 0, CAST(N'2003-11-24' AS Date), 2, N'mrb')
INSERT [dbo].[CandidateTBL] ([cid], [cname], [gender], [dob], [gid], [created_by]) VALUES (4, N'Tran Thi DDD', 0, CAST(N'2005-02-22' AS Date), 3, N'mrc')
INSERT [dbo].[CandidateTBL] ([cid], [cname], [gender], [dob], [gid], [created_by]) VALUES (5, N'Test Test ZZZ DDD', 1, CAST(N'2009-02-01' AS Date), 4, N'mrc')
INSERT [dbo].[CandidateTBL] ([cid], [cname], [gender], [dob], [gid], [created_by]) VALUES (6, N'AAA BBB CCC', 1, CAST(N'2002-01-02' AS Date), 4, N'mrc')
SET IDENTITY_INSERT [dbo].[CandidateTBL] OFF
GO
INSERT [dbo].[GroupTBL] ([gid], [gname]) VALUES (1, N'Account & Finance')
INSERT [dbo].[GroupTBL] ([gid], [gname]) VALUES (2, N'Development Team')
INSERT [dbo].[GroupTBL] ([gid], [gname]) VALUES (3, N'R&D Team')
INSERT [dbo].[GroupTBL] ([gid], [gname]) VALUES (4, N'Management Team')
GO
SET IDENTITY_INSERT [dbo].[MemberTBL] ON 

INSERT [dbo].[MemberTBL] ([mid], [mname], [gender], [dob], [gid], [created_by]) VALUES (1, N'Nguyen Van A', 1, CAST(N'1999-03-05' AS Date), 1, N'mra')
INSERT [dbo].[MemberTBL] ([mid], [mname], [gender], [dob], [gid], [created_by]) VALUES (2, N'Tran Hoang B', 1, CAST(N'2005-09-12' AS Date), 2, N'mra')
INSERT [dbo].[MemberTBL] ([mid], [mname], [gender], [dob], [gid], [created_by]) VALUES (3, N'Hoang Thi C', 0, CAST(N'2003-11-24' AS Date), 2, N'mrb')
INSERT [dbo].[MemberTBL] ([mid], [mname], [gender], [dob], [gid], [created_by]) VALUES (4, N'Tran Thi DDD', 0, CAST(N'2005-02-22' AS Date), 3, N'mrc')
INSERT [dbo].[MemberTBL] ([mid], [mname], [gender], [dob], [gid], [created_by]) VALUES (5, N'Test Test ZZZ DDD', 1, CAST(N'2009-02-01' AS Date), 4, N'mrc')
INSERT [dbo].[MemberTBL] ([mid], [mname], [gender], [dob], [gid], [created_by]) VALUES (6, N'AAA BBB CCC', 1, CAST(N'2002-01-02' AS Date), 4, N'mrc')
SET IDENTITY_INSERT [dbo].[MemberTBL] OFF
GO
INSERT [dbo].[UserTBL] ([username], [password], [displayname]) VALUES (N'mra', N'mra', N'Mr A')
INSERT [dbo].[UserTBL] ([username], [password], [displayname]) VALUES (N'mrb', N'mrb', N'Mr B')
INSERT [dbo].[UserTBL] ([username], [password], [displayname]) VALUES (N'mrc', N'mrc', N'Mr C')
INSERT [dbo].[UserTBL] ([username], [password], [displayname]) VALUES (N'mrd', N'mrd', N'Mr D')
GO
ALTER TABLE [dbo].[CandidateTBL]  WITH CHECK ADD  CONSTRAINT [FK_CandidateTBL_GroupTBL] FOREIGN KEY([gid])
REFERENCES [dbo].[GroupTBL] ([gid])
GO
ALTER TABLE [dbo].[CandidateTBL] CHECK CONSTRAINT [FK_CandidateTBL_GroupTBL]
GO
ALTER TABLE [dbo].[CandidateTBL]  WITH CHECK ADD  CONSTRAINT [FK_CandidateTBL_UserTBL] FOREIGN KEY([created_by])
REFERENCES [dbo].[UserTBL] ([username])
GO
ALTER TABLE [dbo].[CandidateTBL] CHECK CONSTRAINT [FK_CandidateTBL_UserTBL]
GO
ALTER TABLE [dbo].[MemberTBL]  WITH CHECK ADD  CONSTRAINT [FK_MemberTBL_GroupTBL] FOREIGN KEY([gid])
REFERENCES [dbo].[GroupTBL] ([gid])
GO
ALTER TABLE [dbo].[MemberTBL] CHECK CONSTRAINT [FK_MemberTBL_GroupTBL]
GO
ALTER TABLE [dbo].[MemberTBL]  WITH CHECK ADD  CONSTRAINT [FK_MemberTBL_UserTBL] FOREIGN KEY([created_by])
REFERENCES [dbo].[UserTBL] ([username])
GO
ALTER TABLE [dbo].[MemberTBL] CHECK CONSTRAINT [FK_MemberTBL_UserTBL]
GO
