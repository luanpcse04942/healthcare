CREATE DATABASE healthcare;
GO
USE healthcare;
GO
--drop database healthcare
CREATE TABLE dbo.[Role]
   (roleId int PRIMARY KEY NOT NULL IDENTITY,  
   roleName nvarchar(25) NOT NULL)  
GO  

CREATE TABLE dbo.[User]  
   (
   userId int PRIMARY KEY NOT NULL IDENTITY,
   roleId int FOREIGN KEY REFERENCES [Role](roleId),
   firstName nvarchar(max) NOT NULL,  
   lastName nvarchar(max) NOT NULL,  
   email nvarchar(max) NOT NULL,
   [password] nvarchar(max) NOT NULL,
   gender nvarchar(25) NULL,
   phoneNumber nvarchar(25) NULL,
   [address] nvarchar(max)NULL,
   [image] varBinary(max) NULL,
   createdAt date NULL,
   updatedAt date NULL
   )  
GO  


CREATE TABLE dbo.[Handbook]  
   (
   handBookId int PRIMARY KEY NOT NULL IDENTITY,  
   adminId int NOT NULL FOREIGN KEY REFERENCES [User](userId),  
   name nvarchar(max) NOT NULL,
   publishAt date NOT NULL,  
   content ntext NULL
   )  
GO 

CREATE TABLE dbo.[Position]  
   (
   positionId int PRIMARY KEY NOT NULL IDENTITY,  
   name nvarchar(max) NOT NULL
   )  
GO 

CREATE TABLE dbo.[Province]  
   (
   provinceId int PRIMARY KEY NOT NULL IDENTITY,  
   name nvarchar(max) NOT NULL
   )  
GO 

CREATE TABLE dbo.[MedicalFacilityInfo]  
   (
   medicalFacilityInfoId int PRIMARY KEY NOT NULL IDENTITY,
   medicalFacilityId int NOT NULL FOREIGN KEY REFERENCES [User](userId),
   provinceId int NOT NULL FOREIGN KEY REFERENCES [Province](provinceId),
   [description] nvarchar(max) NULL,
   established date NULL,
   createdAt date NULL,
   updatedAt date NULL
   )  
GO 

CREATE TABLE dbo.[Specialty]  
   (
   specialtyId int PRIMARY KEY NOT NULL IDENTITY,  
   name nvarchar(max) NOT NULL,
   [description] nvarchar(max) NULL,
   [image] varBinary(max) NULL
   )  
GO 

CREATE TABLE dbo.[Price]  
   (
   priceId int PRIMARY KEY NOT NULL IDENTITY,
   priceValue int NOT NULL
   )  
GO 

CREATE TABLE dbo.[Doctor_Working_Info]  
   (
   doctorWorkingInfoId int PRIMARY KEY NOT NULL IDENTITY,  
   doctorId int FOREIGN KEY REFERENCES [User](userId),
   medicalFacilityInfoId int FOREIGN KEY REFERENCES [MedicalFacilityInfo](medicalFacilityInfoId),
   specialtyId int FOREIGN KEY REFERENCES [Specialty](specialtyId),
   positionId int FOREIGN KEY REFERENCES [Position](positionId),
   priceId int NOT NULL FOREIGN KEY REFERENCES [Price](priceId),
   createdAt date NULL,
   updatedAt date NULL
   )  
GO 

CREATE TABLE dbo.[Facility_Specialty]  
   (
   id int PRIMARY KEY NOT NULL IDENTITY,  
   medicalFacilityInfoId int NOT NULL FOREIGN KEY REFERENCES [MedicalFacilityInfo](medicalFacilityInfoId),
   specialtyId int NOT NULL FOREIGN KEY REFERENCES [Specialty](specialtyId),
   )  
GO 
 

CREATE TABLE dbo.[Feedback]  
   (
   feedBackId int PRIMARY KEY NOT NULL IDENTITY,  
   patientId int NOT NULL FOREIGN KEY REFERENCES [User](userId),
   doctorWorkingInfoId int NOT NULL FOREIGN KEY REFERENCES [Doctor_Working_Info](doctorWorkingInfoId),
   content nvarchar(max) NOT NULL,
   createdAt date NULL,
   updatedAt date NULL
   )  
GO 

CREATE TABLE dbo.[Status]  
   (
   statusId int PRIMARY KEY NOT NULL IDENTITY,
   statusName nvarchar(max) NOT NULL
   )  
GO 

CREATE TABLE dbo.[Time]  
   (
   timeId int PRIMARY KEY NOT NULL IDENTITY,
   timeValue nvarchar(max) NOT NULL
   )  
GO 

CREATE TABLE dbo.[Schedule]  
   (
   scheduleId int PRIMARY KEY NOT NULL IDENTITY,
   doctorWorkingInfoId int NOT NULL FOREIGN KEY REFERENCES [Doctor_Working_Info](doctorWorkingInfoId),
   timeId int NOT NULL FOREIGN KEY REFERENCES [Time](timeId),
   scheduleDate date NOT NULL
   )  
GO 

CREATE TABLE dbo.[Appointment]  
   (
   appointmentId int PRIMARY KEY NOT NULL IDENTITY,
   userId int NOT NULL FOREIGN KEY REFERENCES [User](userId),
   doctorWorkingInfoId int NOT NULL FOREIGN KEY REFERENCES [Doctor_Working_Info](doctorWorkingInfoId),
   timeId int NOT NULL FOREIGN KEY REFERENCES [Time](timeId),
   statusId int NOT NULL FOREIGN KEY REFERENCES [Status](statusId),
   reasonExamination nvarchar(max) NOT NULL,
   bookingDate date NOT NULL
   )  
GO 


SET IDENTITY_INSERT dbo.[Role] ON;
GO
INSERT dbo.[Role] (RoleID, RoleName)  
    VALUES (1, N'Quản trị viên') , (2, N'Bác sĩ'), (3, N'Bệnh nhân'), (4, N'Cơ sở y tế');
GO 
SET IDENTITY_INSERT dbo.[Role] OFF;
GO

SET IDENTITY_INSERT dbo.[User] ON;
GO
INSERT dbo.[User] (userId, roleId, firstName, lastName, email, [password], gender, phoneNumber,[address], [image], createdAt, updatedAt)  
    VALUES	(1, 1, N'Phí Công', N'Luân', 'luanpc@gmail.com', '123456', 'Nam', '0999999999', N'Hà Nội', NULL, NULL, NULL),
			(2, 1, N'Phạm Xuân', N'Trung', 'trungpx@gmail.com', '123456', 'Nam', '0966666666',N'Hà Nội' , NULL, NULL, NULL),
			
			(3, 2, N'Trần Ngọc', N'Ân', 'antn@gmail.com', '123456', 'Nam', '0888888888', N'Số 219 Lê Duẩn - Hai Bà Trưng - Hà Nội' ,NULL, NULL, NULL),
			(4, 2, N'Nguyễn Mai', N'Hồng', 'hongnm@gmail.com', '123456', N'Nữ', '0985555555', N'Số 1E Trường Chinh - Thanh Xuân - Hà Nội' , NULL, NULL, NULL),
			(5, 2, N'Nguyễn Tuyết', N'Xương', 'xuongnt@gmail.com', '123456', 'Nam', '0888888888', N'Tầng 1, SH5-CT3 Iris Garden, 30 Trần Hữu Dực, Cầu Diễn, Nam Từ Liêm, Hà Nội' ,NULL, NULL, NULL),
			(6, 2, N'Đào Đình', N'Thi', 'thidd@gmail.com', '123456', 'Nam', '0985555555', N'Số 33, ngõ 38, phố Phương Mai - Đống Đa - Hà Nội' , NULL, NULL, NULL),
			(7, 2, N'Nguyễn Thị Hoài', N'An', 'annth@gmail.com', '123456', N'Nữ', '0888888888', N'Số 1E Trường Chinh - Thanh Xuân - Hà Nội' ,NULL, NULL, NULL),
			(8, 2, N'Dương Minh', N'Trí', 'tridm@gmail.com', '123456', 'Nam', '0985555555', N'101 Trần Hữu Trang, Phường 10, Quận Phú Nhuận, Thành phố Hồ Chí Minh' , NULL, NULL, NULL),
			
			(9, 3, N'Nguyễn Văn', N'Bình', 'binhnv@gmail.com', '123456', 'Nam', '09812312321', N'Hà Nội' , NULL, NULL, NULL),
			(10, 3, N'Nguyễn Văn', N'Đức', 'ducnv@gmail.com', '123456', 'Nam', '0777777777', N'Hà Nội' ,NULL, NULL, NULL),
			
			(11, 4, N'Bệnh viện', N'Y học cổ truyền Trung ương', 'yhoccotruyentw@gmail.com', '123456', NULL, '0987654321', N'Số 29 Nguyễn Bỉnh Khiêm, Hai Bà Trưng, Hà Nội' , NULL, NULL, NULL),
			(12, 4, N'Bệnh viện', N'Chợ Rẫy', 'chorayhospital@gmail.com', '123456', NULL, '0987654321', N'201B Nguyễn Chí Thanh, Phường 12, Quận 5, Hồ Chí Minh' , NULL, NULL, NULL),
			(13, 4, N'Phòng khám Bệnh viện', N'Đại học Y Dược 1', 'yhoccotruyentw@gmail.com', '123456', NULL, '0987654321', N'20-22 Dương Quang Trung, Phường 12, Quận 10, Tp. HCM' , NULL, NULL, NULL),
			(14, 4, N'Bệnh viện hữu nghị', N'Việt Đức', 'vietduchospital@gmail.com', '123456', NULL, '0123456789', N'Số 16-18 Phủ Doãn - Hoàn Kiếm - Hà Nội' , NULL, NULL, NULL),
			(15, 4, N'Bệnh viện', N'Y học cổ truyền Trung ương', 'yhoccotruyentw@gmail.com', '123456', NULL, '0987654321', N'Số 29 Nguyễn Bỉnh Khiêm, Hai Bà Trưng, Hà Nội' , NULL, NULL, NULL),
			(16, 4, N'Bệnh viện', N'Chợ Rẫy', 'chorayhospital@gmail.com', '123456', NULL, '0987654321', N'201B Nguyễn Chí Thanh, Phường 12, Quận 5, Hồ Chí Minh' , NULL, NULL, NULL),
			(17, 4, N'Phòng khám Bệnh viện', N'Đại học Y Dược 1', 'yhoccotruyentw@gmail.com', '123456', NULL, '0987654321', N'20-22 Dương Quang Trung, Phường 12, Quận 10, Tp. HCM' , NULL, NULL, NULL),
			(18, 4, N'Bệnh viện hữu nghị', N'Việt Đức', 'vietduchospital@gmail.com', '123456', NULL, '0123456789', N'Số 16-18 Phủ Doãn - Hoàn Kiếm - Hà Nội' , NULL, NULL, NULL);
GO 
SET IDENTITY_INSERT dbo.[User] OFF;
GO


SET IDENTITY_INSERT dbo.[Handbook] ON;
GO
INSERT dbo.[Handbook] (handBookId, adminId, name, publishAt, content)  
    VALUES	(1, 1 , N'Chiến lược Online Marketing phòng khám: Trọn bộ từ A đến Z', '2022/09/13', NULL),
    	(2, 1 , N'Gợi ý 5 ý tưởng Marketing phòng khám giúp thu hút khách hàng', '2022/09/13', NULL),
    	(3, 1 , N'Review 5 địa chỉ điều trị tàn nhang uy tín, hiệu quả tại Hà Nội', '2022/09/13', NULL);
GO
SET IDENTITY_INSERT dbo.[Handbook] OFF;
GO


SET IDENTITY_INSERT dbo.[Position] ON;
GO
INSERT dbo.[Position] (positionId, name)  
    VALUES	(1, N'Bác sĩ'),
			(2, N'Thạc sĩ'),
			(3, N'Tiến sĩ'),
			(4, N'Phó giáo sư'),
			(5, N'Giáo sư');
GO
SET IDENTITY_INSERT dbo.[Position] OFF;
GO 


SET IDENTITY_INSERT dbo.[Province] ON;
GO
INSERT dbo.[Province] (provinceId, name)  
    VALUES	(1, N'Hà Nội'),
			(2, N'Hồ Chí Minh'),
			(3, N'Đà Nẵng'),
			(4, N'Cần Thơ'),
			(5, N'Bình Dương'),
			(6, N'Đồng Nai'),
			(7, N'Quảng Ninh'),
			(8, N'Thừa Thiên Huế'),
			(9, N'Quảng Bình'),
			(10, N'Khánh Hòa');
GO
SET IDENTITY_INSERT dbo.[Province] OFF;
GO


SET IDENTITY_INSERT dbo.[Specialty] ON;
GO
INSERT dbo.[Specialty] (specialtyId, name, [description], [image])  
    VALUES	(1, N'Cơ xương khớp', NULL , NULL),
			(2, N'Thần kinh', NULL, NULL),
			(3, N'Tiêu hóa', NULL, NULL),
			(4, N'Tim mạch', NULL , NULL),
			(5, N'Tai Mũi Họng', NULL, NULL),
			(6, N'Cột sống', NULL , NULL),
			(7, N'Nhi khoa', NULL , NULL),
			(8, N'Da liễu', NULL , NULL);
GO 
SET IDENTITY_INSERT dbo.[Specialty] OFF;
GO

SET IDENTITY_INSERT dbo.[MedicalFacilityInfo] ON;
GO
INSERT dbo.[MedicalFacilityInfo] (medicalFacilityInfoId, medicalFacilityId, provinceId, [description], established, createdAt, updatedAt)  
    VALUES	(1, 11, 1, NULL , NULL, NULL, NULL),
			(2, 12, 2, NULL , NULL, NULL, NULL),
			(3, 13, 2, NULL , NULL, NULL, NULL),
			(4, 14, 1, NULL , NULL, NULL, NULL),
			(5, 15, 1, NULL , NULL, NULL, NULL),
			(6, 16, 2, NULL , NULL, NULL, NULL),
			(7, 17, 2, NULL , NULL, NULL, NULL),
			(8, 18, 1, NULL , NULL, NULL, NULL);
GO
SET IDENTITY_INSERT dbo.[MedicalFacilityInfo] OFF;
GO


SET IDENTITY_INSERT dbo.[Price] ON;
GO
INSERT dbo.[Price] (priceId, priceValue)  
    VALUES	(1, 200000),
			(2, 250000),
			(3, 300000),
			(4, 350000),
			(5, 400000),
			(6, 450000),
			(7, 500000);
GO
SET IDENTITY_INSERT dbo.[Price] OFF;
GO


SET IDENTITY_INSERT dbo.[Doctor_Working_Info] ON;
GO
INSERT dbo.[Doctor_Working_Info] (doctorWorkingInfoId, doctorId, medicalFacilityInfoId, specialtyId, positionId, priceId, createdAt, updatedAt)  
    VALUES	(1, 3, 1, 1, 1, 1, NULL, NULL),
			(2, 4, 2, 2, 3, 3, NULL, NULL),
			(3, 5, 3, 3, 2, 4, NULL, NULL),
			(4, 6, 4, 4, 5, 5, NULL, NULL),
			(5, 7, 5, 5, 4, 6, NULL, NULL),
			(6, 8, 6, 6, 3, 7, NULL, NULL);
GO 
SET IDENTITY_INSERT dbo.[Doctor_Working_Info] OFF;
GO


SET IDENTITY_INSERT dbo.[Facility_Specialty] ON;
GO
INSERT dbo.[Facility_Specialty] (id, medicalFacilityInfoId, specialtyId)  
    VALUES	(1, 1, 1),(2, 1, 2),(3, 1, 3),(4, 1, 4),(5, 1, 5),(6, 1, 6),(7, 1, 7),(8, 1, 8),
			(9, 2, 1),(10, 2, 2),(11, 2, 3),(12, 2, 4),(13, 2, 5),
			(14, 3, 1),(15, 3, 2),(16, 3, 3),(17, 3, 4),(18, 3, 5),(19, 3, 6),(20, 3, 7),(21, 3, 8),
			(22, 4, 1),(23, 4, 2),(24, 4, 3),(25, 4, 4),(26, 4, 5),(27, 4, 6),(28, 4, 7),(29, 4, 8),
			(30, 5, 1),(31, 5, 2),(32, 5, 3),(33, 5, 4),(34, 5, 5),(35, 5, 6),(36, 5, 7),(37, 5, 8),
			(38, 6, 1),(39, 6, 2),(40, 6, 3),(41, 6, 4),(42, 6, 5),
			(43, 7, 1),(44, 7, 2),(45, 7, 3),(46, 7, 4),(47, 7, 5),(48, 7, 6),(49, 7, 7),(50, 7, 8),
			(51, 8, 1),(52, 8, 2),(53, 8, 3),(54, 8, 4),(55, 8, 5),(56, 8, 6),(57, 8, 7),(58, 8, 8);
GO
SET IDENTITY_INSERT dbo.[Facility_Specialty] OFF;
GO


SET IDENTITY_INSERT dbo.[Status] ON;
GO
INSERT dbo.[Status] (statusId, statusName)  
    VALUES	(1, N'Lịch hẹn mới'),
			(2, N'Đã xác nhận'),
			(3, N'Đã khám xong'),
			(4, N'Đã hủy');
GO 
SET IDENTITY_INSERT dbo.[Status] OFF;
GO


SET IDENTITY_INSERT dbo.[Time] ON;
GO
INSERT dbo.[Time] (timeId, timeValue)  
    VALUES	(1, '8:00 - 9:00'),
			(2, '9:00 - 10:00'),
			(3, '10:00 - 11:00'),
			(4, '11:00 - 12:00'),
			(5, '13:00 - 14:00'),
			(6, '14:00 - 15:00'),
			(7, '15:00 - 16:00'),
			(8, '16:00 - 17:00');
GO 
SET IDENTITY_INSERT dbo.[Time] OFF;