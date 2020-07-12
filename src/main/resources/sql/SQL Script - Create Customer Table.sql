

CREATE TABLE Customer(
	[id] [bigint] IDENTITY(1,1) NOT NULL,	
	[firstName] [varchar](50) NOT NULL,	
	[lastName] [varchar](50) NOT NULL,
	[dob] DATETIME NOT NULL,
	[email] [varchar](50) NOT NULL,	
	[password] [varchar](50) NOT NULL,	
	
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, FILLFACTOR = 90) ON [PRIMARY]
) ON [PRIMARY]

GO


insert into Customer
values('Satheesh', 'Babu', '12/14/1990', 'satheeshappu141@gmail.com', 'xdf@1234')
