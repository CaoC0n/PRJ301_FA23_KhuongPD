USE [PRJ321_SP20]
GO
/****** Object:  Table [dbo].[Comments]    Script Date: 3/24/2020 6:36:28 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Comments](
	[commentid] [int] IDENTITY(1,1) NOT NULL,
	[username] [varchar](150) NOT NULL,
	[content] [varchar](150) NOT NULL,
	[created_date] [date] NOT NULL,
	[urgen] [bit] NOT NULL,
 CONSTRAINT [PK_Comments] PRIMARY KEY CLUSTERED 
(
	[commentid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Requests]    Script Date: 3/24/2020 6:36:28 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Requests](
	[requestid] [int] IDENTITY(1,1) NOT NULL,
	[username] [varchar](150) NOT NULL,
	[from] [date] NOT NULL,
	[to] [date] NOT NULL,
	[reason] [varchar](150) NULL,
 CONSTRAINT [PK_Requests] PRIMARY KEY CLUSTERED 
(
	[requestid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Users]    Script Date: 3/24/2020 6:36:28 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Users](
	[username] [varchar](150) NOT NULL,
	[password] [varchar](150) NOT NULL,
 CONSTRAINT [PK_Users] PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[Comments] ON 

INSERT [dbo].[Comments] ([commentid], [username], [content], [created_date], [urgen]) VALUES (3, N'mra', N'my laptop getting an error ', CAST(0xCF400B00 AS Date), 1)
INSERT [dbo].[Comments] ([commentid], [username], [content], [created_date], [urgen]) VALUES (4, N'mrb', N'The template of detail design should be remade', CAST(0x11410B00 AS Date), 0)
SET IDENTITY_INSERT [dbo].[Comments] OFF
SET IDENTITY_INSERT [dbo].[Requests] ON 

INSERT [dbo].[Requests] ([requestid], [username], [from], [to], [reason]) VALUES (1, N'mra', CAST(0xC8300B00 AS Date), CAST(0xD4300B00 AS Date), N'Business Trip')
INSERT [dbo].[Requests] ([requestid], [username], [from], [to], [reason]) VALUES (2, N'mrb', CAST(0xC8300B00 AS Date), CAST(0xD4300B00 AS Date), N'Business Trip')
INSERT [dbo].[Requests] ([requestid], [username], [from], [to], [reason]) VALUES (4, N'mrb', CAST(0x233F0B00 AS Date), CAST(0x263F0B00 AS Date), N'Anual Leave')
SET IDENTITY_INSERT [dbo].[Requests] OFF
INSERT [dbo].[Users] ([username], [password]) VALUES (N'mra', N'mra')
INSERT [dbo].[Users] ([username], [password]) VALUES (N'mrb', N'mrb')
INSERT [dbo].[Users] ([username], [password]) VALUES (N'mrc', N'mrc')
ALTER TABLE [dbo].[Comments]  WITH CHECK ADD  CONSTRAINT [FK_Comments_Users] FOREIGN KEY([username])
REFERENCES [dbo].[Users] ([username])
GO
ALTER TABLE [dbo].[Comments] CHECK CONSTRAINT [FK_Comments_Users]
GO
ALTER TABLE [dbo].[Requests]  WITH CHECK ADD  CONSTRAINT [FK_Requests_Users1] FOREIGN KEY([username])
REFERENCES [dbo].[Users] ([username])
GO
ALTER TABLE [dbo].[Requests] CHECK CONSTRAINT [FK_Requests_Users1]
GO
